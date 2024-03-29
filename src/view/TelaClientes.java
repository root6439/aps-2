package view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.dao.ClienteDao;
import model.dao.DaoFactory;
import model.entities.Cliente;

public class TelaClientes extends JFrame {

	private static final long serialVersionUID = 1L;

	public TelaClientes() {
		initComponents();
	}

	// Variables declaration
	private JButton add;
	private JButton edit;
	private JButton delete;
	private JLabel title;
	private JSeparator bottom;
	private JSeparator rigthSide;
	private JSeparator leftSide;
	private JSeparator upperMinor;
	private JSeparator upper;
	private JTable tableClientes;
	private JScrollPane jScrollPane1;
	private JLabel telaPrincipal;
	private List<Cliente> cl;
	DefaultTableModel model;

// End variables

	private void initComponents() {

		ClienteDao c = DaoFactory.createClienteDao();
		cl = c.findAll();

		// Start layout for background null
		getContentPane().setLayout(null);
		// End layout

		// Start add
		add = new JButton();
		add.setText("ADICIONAR");
		getContentPane().add(add);
		add.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				addActionPerformed(evt);
			}
		});
		add.setBounds(600, 370, 120, 40);
		// End add

		// Start edit
		edit = new JButton();
		edit.setText("EDITAR");
		getContentPane().add(edit);
		edit.setBounds(200, 370, 100, 40);
		edit.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					updateActionPerformed(evt);
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
		});
		// End edit

		// Start delete
		delete = new JButton();
		delete.setText("EXCLUIR");
		getContentPane().add(delete);
		delete.setBounds(400, 370, 120, 40);
		delete.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				deleteActionPerformed(evt);
			}
		});
		// End delete

		// Start title
		title = new JLabel();
		title.setText("CLIENTES");
		getContentPane().add(title);
		title.setBounds(40, 20, 100, 20);
		// End title

		// Start bottom
		bottom = new JSeparator();
		getContentPane().add(bottom);
		bottom.setBounds(20, 360, 830, 20);
		// End bottom

		// Start rigthSide
		rigthSide = new JSeparator();
		rigthSide.setOrientation(javax.swing.SwingConstants.VERTICAL);
		getContentPane().add(rigthSide);
		rigthSide.setBounds(850, 30, 10, 330);
		// End rigthSide

		// Start leftSide
		leftSide = new JSeparator();
		leftSide.setOrientation(javax.swing.SwingConstants.VERTICAL);
		getContentPane().add(leftSide);
		leftSide.setBounds(20, 30, 10, 330);
		// End leftSide

		// start upperMinor
		upperMinor = new JSeparator();
		getContentPane().add(upperMinor);
		upperMinor.setBounds(20, 30, 10, 10);
		// End upperMinor

		// Start upper
		upper = new JSeparator();
		getContentPane().add(upper);
		upper.setBounds(105, 30, 745, 10);
		// End upper

		// Start tableClientes
		tableClientes = new JTable();

		String[] colunas = { "ID", "Nome", "CPF", "Telefone", "Data de Nascimento" };
		model = new DefaultTableModel(colunas, 0);

		for (Cliente cliente : cl) {
			model.addRow(new Object[] { cliente.getId(), cliente.getNome(), cliente.getCpf(), cliente.getTelefone(),
					cliente.getData_nascimento() });
		}

		tableClientes.setModel(model);
		getContentPane().add(tableClientes);

		// End

		// Start jScrollPane1
		jScrollPane1 = new JScrollPane();
		jScrollPane1.setViewportView(tableClientes);
		getContentPane().add(jScrollPane1);
		jScrollPane1.setBounds(60, 60, 750, 280);
		// End jScrollPane1

		// Start telaPrincipal
		telaPrincipal = new JLabel();
		telaPrincipal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/TelaPrincipal.jpeg"))); // NOI18N
		telaPrincipal.setIconTextGap(5);
		getContentPane().add(telaPrincipal);
		telaPrincipal.setBounds(0, -24, 912, 470);
		// End telaPrincipal

	}

	private void addActionPerformed(java.awt.event.ActionEvent evt) {
		AddCliente adc = new AddCliente();
		adc.setVisible(true);
		adc.setSize(620, 476);
		adc.setLocation(227, 126);
	}

	private void deleteActionPerformed(java.awt.event.ActionEvent evt) {

		Integer id;
		id = Integer.parseInt(JOptionPane.showInputDialog(null, "Id do cliente a ser removido:", "Remover",
				JOptionPane.OK_CANCEL_OPTION));

		ClienteDao c = DaoFactory.createClienteDao();
		c.deleteById(id);

		JOptionPane.showMessageDialog(null, "Cliente removido");

	}

	private void updateActionPerformed(java.awt.event.ActionEvent evt) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		Integer id = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o id do cliente: ", "Atualizar dados"));

		String campo = JOptionPane.showInputDialog(null, "Digite o campo que deseja alterar").toLowerCase();

		String dado = JOptionPane.showInputDialog(null, "Digite o novo valor: ", "Novo valor");

		ClienteDao cliente = DaoFactory.createClienteDao();
		Cliente aux = cliente.findById(id);

		if (campo.equals("nome")) {
			aux.setNome(dado);
		} else if (campo.equals("cpf")) {
			aux.setCpf(dado);
		} else if (campo.equals("telefone")) {
			aux.setTelefone(dado);
		} else if (campo.equals("data de nascimento")) {
			aux.setData_nascimento(sdf.parse(dado));
		} else {
			JOptionPane.showMessageDialog(null, "Algo deu errado, tente de novo");
		}

		cliente.update(aux);

		JOptionPane.showMessageDialog(null, "Atualização feita");

	}

}
