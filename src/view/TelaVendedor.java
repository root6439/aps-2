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

import model.dao.DaoFactory;
import model.dao.VendedorDao;
import model.entities.Vendedor;

public class TelaVendedor extends JFrame {

	private static final long serialVersionUID = 1L;

	private JButton add;
	private JButton edit;
	private JButton delete;
	private JSeparator bottom;
	private JSeparator rightSide;
	private JSeparator leftSide;
	private JSeparator upperMinor;
	private JSeparator upper;
	private JLabel title;
	private JLabel logo;
	private JTable tableVendedor;
	private JScrollPane scrollPainel;

	private VendedorDao v;
	private List<Vendedor> vl;
	
	private DefaultTableModel model;

	public TelaVendedor() {
		initComponents();
	}

	private void initComponents() {

		v = DaoFactory.createVendedorDao();
		vl = v.findAll();

		// Home layout null for background image
		getContentPane().setLayout(null);
		// End

		// Home add
		add = new JButton();
		add.setText("ADICIONAR");
		getContentPane().add(add);
		add.setBounds(200, 370, 120, 40);
		add.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				addActionPerformed(evt);
			}
		});
		// End add

		// Home edit
		edit = new JButton();
		edit.setText("EDITAR");
		getContentPane().add(edit);
		edit.setBounds(400, 370, 120, 40);
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

		// Home delete
		delete = new JButton();
		delete.setText("EXCLUIR");
		getContentPane().add(delete);
		delete.setBounds(600, 370, 120, 40);
		delete.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				deleteActionPerformed(evt);
			}
		});
		// End delete

		// Home bottom
		bottom = new JSeparator();
		getContentPane().add(bottom);
		bottom.setBounds(20, 360, 830, 20);
		// End bottom

		// Home rightSide
		rightSide = new JSeparator();
		rightSide.setOrientation(javax.swing.SwingConstants.VERTICAL);
		getContentPane().add(rightSide);
		rightSide.setBounds(850, 30, 10, 330);
		// End rightSide

		// Home leftSide
		leftSide = new JSeparator();
		leftSide.setOrientation(javax.swing.SwingConstants.VERTICAL);
		getContentPane().add(leftSide);
		leftSide.setBounds(20, 30, 10, 330);
		// End leftSide

		// Home upperMinor
		upperMinor = new JSeparator();
		getContentPane().add(upperMinor);
		upperMinor.setBounds(20, 30, 10, 10);
		// End upperMinor

		// Home upper
		upper = new JSeparator();
		getContentPane().add(upper);
		upper.setBounds(135, 30, 715, 10);
		// End upper

		// Home title
		title = new javax.swing.JLabel();
		title.setText("VENDEDORES");
		getContentPane().add(title);
		title.setBounds(40, 20, 100, 20);

		String[] colunas = { "ID", "Nome", "CPF", "Telefone", "Data de Nascimento", "Setor" };

		// Home tableVendedor
		tableVendedor = new JTable();
		model = new DefaultTableModel(colunas, 0);

		for (Vendedor vendedor : vl) {
			model.addRow(new Object[] { vendedor.getId(), vendedor.getNome(), vendedor.getCpf(), vendedor.getTelefone(),
					vendedor.getData_nascimento(), vendedor.getSetor_vendedor().getNome() });
		}

		tableVendedor.setModel(model);
		getContentPane().add(tableVendedor);

		// End tableVendedor

		// Home scrollPainel
		scrollPainel = new JScrollPane();
		scrollPainel.setViewportView(tableVendedor);
		getContentPane().add(scrollPainel);
		scrollPainel.setBounds(60, 60, 750, 280);
		// End scrollPainel

		// Home logo
		logo = new JLabel();
		logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/TelaPrincipal.jpeg"))); // NOI18N
		logo.setIconTextGap(5);
		getContentPane().add(logo);
		logo.setBounds(0, -24, 912, 470);
		// End logo
	}

	private void addActionPerformed(java.awt.event.ActionEvent evt) {
		AddVendedor adp = new AddVendedor();
		adp.setVisible(true);
		adp.setSize(620, 476);
		adp.setLocation(227, 126);
	}

	private void deleteActionPerformed(java.awt.event.ActionEvent evt) {

		Integer id;
		id = Integer.parseInt(JOptionPane.showInputDialog(null, "Id do vendedor a ser removido:", "Remover",
				JOptionPane.OK_CANCEL_OPTION));

		VendedorDao v = DaoFactory.createVendedorDao();
		v.deleteById(id);

		JOptionPane.showMessageDialog(null, "Vendedor removido");

	}

	private void updateActionPerformed(java.awt.event.ActionEvent evt) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		Integer id = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o id do vendedor: "));

		String campo = JOptionPane.showInputDialog(null, "Digite o campo que deseja alterar").toLowerCase();

		String dado = JOptionPane.showInputDialog(null, "Digite o novo valor: ");

		VendedorDao vend = DaoFactory.createVendedorDao();
		Vendedor aux = vend.findById(id);

		if (campo.equals("nome")) {
			aux.setNome(dado);
		} else if (campo.equals("cpf")) {
			aux.setCpf(dado);
		} else if (campo.equals("telefone")) {
			aux.setTelefone(dado);
		} else if (campo.equals("data de nascimento")) {
			aux.setData_nascimento(sdf.parse(dado));
		} else if (campo.equals("setor")) {
			aux.getSetor_vendedor().setId(Integer.parseInt(dado));
		}

		vend.update(aux);

		JOptionPane.showMessageDialog(null, "Atualização feita");
		
		for (Vendedor vendedor : vl) {
			model.addRow(new Object[] { vendedor.getId(), vendedor.getNome(), vendedor.getCpf(), vendedor.getTelefone(),
					vendedor.getData_nascimento(), vendedor.getSetor_vendedor().getNome() });
		}

	}
}
