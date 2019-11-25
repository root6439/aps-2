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
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import model.dao.DaoFactory;
import model.dao.GerenteDao;
import model.dao.ProdutoDao;
import model.entities.Gerente;
import model.entities.Produto;

public class TelaProdutos extends JFrame {

	// Variables declaration
	private JButton jButton3;
	private JButton jButton4;
	private JButton jButton5;
	private JSeparator upper;
	private JSeparator upperMinor;
	private JSeparator leftSide;
	private JSeparator rightSide;
	private JTextField text;
	private JSeparator bottom;
	private JLabel jLabelNomePrincipal;
	private javax.swing.JTable jTableProdutos;
	private javax.swing.JScrollPane pane;
	private javax.swing.JLabel jLabelTelaPrincipal;

// End of variables declaration

	public TelaProdutos() {
		initComponents();
	}

	@SuppressWarnings("unchecked")
	private void initComponents() {

		ProdutoDao p = DaoFactory.createProdutoDao();
		List<Produto> pl = p.findAll();

		// Home layout null for background image
		getContentPane().setLayout(null);
		// End

		// Home
		jButton3 = new JButton();
		jButton3.setText("ADICIONAR");
		getContentPane().add(jButton3);
		jButton3.setBounds(220, 360, 100, 40);
		jButton3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton3ActionPerformed(evt);
			}
		});
		// End

		// Home
		jButton4 = new JButton();
		jButton4.setText("EDITAR");
		getContentPane().add(jButton4);
		jButton4.setBounds(330, 360, 100, 40);
		jButton4.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					updateActionPerformed(evt);
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
		});
		// End

		// Home
		jButton5 = new JButton();
		jButton5.setText("EXCLUIR");
		getContentPane().add(jButton5);
		jButton5.setBounds(440, 360, 100, 40);
		jButton5.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				deleteActionPerformed(evt);
			}
		});
		// End

		// Start text
		text = new JTextField();
		getContentPane().add(text);
		text.setBounds(610, 370, 180, 30);
		// End text

		// Home
		jLabelNomePrincipal = new javax.swing.JLabel();
		jLabelNomePrincipal.setText("PRODUTOS");
		getContentPane().add(jLabelNomePrincipal);
		jLabelNomePrincipal.setBounds(30, 25, 100, 14);
		// End

		// Start upper
		upper = new JSeparator();
		getContentPane().add(upper);
		upper.setBounds(100, 30, 730, 10);
		// End upper

		// Start upperMinor
		upperMinor = new JSeparator();
		getContentPane().add(upperMinor);
		upperMinor.setBounds(10, 30, 10, 10);
		// End upperMinor

		// Start leftSide
		leftSide = new JSeparator();
		leftSide.setOrientation(javax.swing.SwingConstants.VERTICAL);
		getContentPane().add(leftSide);
		leftSide.setBounds(10, 30, 10, 310);
		// End leftSide

		// Start rightSide
		rightSide = new JSeparator();
		rightSide.setOrientation(javax.swing.SwingConstants.VERTICAL);
		getContentPane().add(rightSide);
		rightSide.setBounds(830, 30, 10, 310);
		// End rightSide

		// Start bottom
		bottom = new JSeparator();
		getContentPane().add(bottom);
		bottom.setBounds(10, 340, 820, 10);
		// End bottom

		String[] colunas = { "ID", "Nome", "Setor", "Descrição", "Valor" };

		// Home
		jTableProdutos = new JTable();
		DefaultTableModel model = new DefaultTableModel(colunas, 0);

		for (Produto produto : pl) {
			model.addRow(new Object[] { produto.getId(), produto.getNome(), produto.getProduto_setor().getNome(),
					produto.getDescricao(), produto.getValor() });
		}

		jTableProdutos.setModel(model);
		getContentPane().add(jTableProdutos);

		jTableProdutos.setColumnSelectionAllowed(true);

		// Start pane
		pane = new JScrollPane();
		pane.setViewportView(jTableProdutos);
		getContentPane().add(pane);
		pane.setBounds(20, 60, 800, 250);
		// End pane

		jLabelTelaPrincipal = new JLabel();
		jLabelTelaPrincipal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/TelaPrincipal.jpeg"))); // NOI18N
		getContentPane().add(jLabelTelaPrincipal);
		jLabelTelaPrincipal.setBounds(0, -30, 900, 470);
	}

	private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
		AddProduto adp = new AddProduto();
		adp.setVisible(true);
		adp.setSize(620, 476);
		adp.setLocation(227, 126);
	}

	private void deleteActionPerformed(java.awt.event.ActionEvent evt) {

		Integer id;
		id = Integer.parseInt(JOptionPane.showInputDialog(null, "Id do produto a ser removido:", "Remover",
				JOptionPane.OK_CANCEL_OPTION));

		ProdutoDao p = DaoFactory.createProdutoDao();
		p.deleteById(id);

		JOptionPane.showMessageDialog(null, "Produto removido");

	}

	private void updateActionPerformed(java.awt.event.ActionEvent evt) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		Integer id = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o id do produto: "));

		String campo = JOptionPane.showInputDialog(null, "Digite o campo que deseja alterar").toLowerCase();

		String dado = JOptionPane.showInputDialog(null, "Digite o novo valor: ");

		ProdutoDao produto = DaoFactory.createProdutoDao();
		Produto aux = produto.findById(id);

		if (campo.equals("descrição")) {
			aux.setDescricao(dado);
		} else if (campo.equals("valor")) {
			aux.setValor(Double.parseDouble(dado));
		} 

		produto.update(aux);

		JOptionPane.showMessageDialog(null, "Atualização feita");

	}
}
