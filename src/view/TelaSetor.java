package view;

import java.text.ParseException;
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
import model.dao.SetorDao;
import model.entities.Gerente;
import model.entities.Setor;

public class TelaSetor extends JFrame {

	private static final long serialVersionUID = 1L;

	public TelaSetor() {
		initComponents();
	}

	private JButton add;
	private JButton edit;
	private JButton delete;
	private JSeparator bottom;
	private JSeparator rightSide;
	private JSeparator leftSide;
	private JSeparator upperMinor;
	private JSeparator upper;
	private JLabel title;
	private JTable tableSetores;
	private JScrollPane scrollPainel;
	private JLabel Logo;

	private void initComponents() {

		SetorDao s = DaoFactory.createSetorDao();
		List<Setor> sl = s.findAll();

		// Start layout null for background image
		getContentPane().setLayout(null);
		// End

		// Start add
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

		// Start edit
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

		// Start delete
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

		// Start upperMinor
		upperMinor = new JSeparator();
		getContentPane().add(upperMinor);
		upperMinor.setBounds(20, 30, 10, 10);
		// End upperMinor

		// Start leftSide
		leftSide = new JSeparator();
		leftSide.setOrientation(javax.swing.SwingConstants.VERTICAL);
		getContentPane().add(leftSide);
		leftSide.setBounds(20, 30, 10, 330);
		// End leftSide

		// Start upper
		upper = new JSeparator();
		getContentPane().add(upper);
		upper.setBounds(105, 30, 745, 10);
		// End upper

		// Start rightSide
		rightSide = new JSeparator();
		rightSide.setOrientation(javax.swing.SwingConstants.VERTICAL);
		getContentPane().add(rightSide);
		rightSide.setBounds(850, 30, 10, 330);
		// End rightSide

		// Start bottom
		bottom = new JSeparator();
		getContentPane().add(bottom);
		bottom.setBounds(20, 360, 830, 20);
		// End bottom

		// Start title
		title = new JLabel();
		title.setText("SETORES");
		getContentPane().add(title);
		title.setBounds(40, 20, 70, 20);
		// End

		String[] colunas = { "Id", "Nome", "Gerente" };

		// Start
		tableSetores = new JTable();
		DefaultTableModel model = new DefaultTableModel(colunas, 0);

		for (Setor setor : sl) {
			model.addRow(new Object[] { setor.getId(), setor.getNome(), setor.getGerente_setor().getNome() });
		}

		tableSetores.setModel(model);
		getContentPane().add(tableSetores);

		// End

		// Start scrollPainel
		scrollPainel = new JScrollPane();
		scrollPainel.setViewportView(tableSetores);
		getContentPane().add(scrollPainel);
		scrollPainel.setBounds(60, 60, 750, 280);
		// End scrollPainel

		// Start Logo
		Logo = new JLabel();
		Logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/TelaPrincipal.jpeg"))); // NOI18N
		Logo.setIconTextGap(5);
		getContentPane().add(Logo);
		Logo.setBounds(0, -24, 912, 470);
		// End Logo

	}

	private void addActionPerformed(java.awt.event.ActionEvent evt) {
		AddSetor adp = new AddSetor();
		adp.setVisible(true);
		adp.setSize(620, 476);
		adp.setLocation(227, 126);
	}

	private void deleteActionPerformed(java.awt.event.ActionEvent evt) {

		Integer id;
		id = Integer.parseInt(JOptionPane.showInputDialog(null, "Id do Setor a ser removido:", "Remover",
				JOptionPane.OK_CANCEL_OPTION));

		SetorDao s = DaoFactory.createSetorDao();
		s.deleteById(id);

		JOptionPane.showMessageDialog(null, "Setor removido");

	}

	private void updateActionPerformed(java.awt.event.ActionEvent evt) throws ParseException {

		Integer id = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o id do setor: "));

		String campo = JOptionPane.showInputDialog(null, "Digite o campo que deseja alterar").toLowerCase();

		String dado = JOptionPane.showInputDialog(null, "Digite o novo valor: ");

		SetorDao setor = DaoFactory.createSetorDao();
		Setor aux = setor.findById(id);
		aux.setGerente_setor(new Gerente());
		
		System.out.println(aux.toString());

		if (campo.equals("nome")) {
			aux.setNome(dado);
		} else if (campo.equals("gerente")) {
			aux.getGerente_setor().setId(Integer.parseInt(dado));
		}

		setor.update(aux);

		System.out.println(aux.toString());
		
		JOptionPane.showMessageDialog(null, "Atualização feita");

	}
}