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
import model.dao.ProdutoDao;
import model.entities.Produto;

public class TelaProdutos extends JFrame {

	private static final long serialVersionUID = 1L;
	
	// Variables declaration
	private JButton jButton3;
	private JButton jButton4;
	private JButton jButton5;
	private JSeparator upper;
	private JSeparator upperMinor;
	private JSeparator leftSide;
	private JSeparator rightSide;
	private JSeparator bottom;
	private JLabel jLabelNomePrincipal;
	private javax.swing.JTable jTableProdutos;
	private javax.swing.JScrollPane pane;
	private javax.swing.JLabel jLabelTelaPrincipal;

// End of variables declaration

	public TelaProdutos() {
		initComponents();
	}

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
		jButton3.setBounds(200, 360, 120, 40);
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
		jButton4.setBounds(400, 360, 100, 40);
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
		jButton5.setBounds(600, 360, 100, 40);
		jButton5.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				deleteActionPerformed(evt);
			}
		});
		// End

		// Home
		jLabelNomePrincipal = new javax.swing.JLabel();
		jLabelNomePrincipal.setText("PRODUTOS");
		getContentPane().add(jLabelNomePrincipal);
		jLabelNomePrincipal.setBounds(55, 25, 100, 14);
		// End

		// Start upper
		upper = new JSeparator();
		getContentPane().add(upper);
		upper.setBounds(140, 30, 730, 10);
		// End upper

		// Start upperMinor
		upperMinor = new JSeparator();
		getContentPane().add(upperMinor);
		upperMinor.setBounds(40, 30, 10, 10);
		// End upperMinor

		// Start leftSide
		leftSide = new JSeparator();
		leftSide.setOrientation(javax.swing.SwingConstants.VERTICAL);
		getContentPane().add(leftSide);
		leftSide.setBounds(40, 30, 10, 310);
		// End leftSide

		// Start rightSide
		rightSide = new JSeparator();
		rightSide.setOrientation(javax.swing.SwingConstants.VERTICAL);
		getContentPane().add(rightSide);
		rightSide.setBounds(870, 30, 10, 310);
		// End rightSide

		// Start bottom
		bottom = new JSeparator();
		getContentPane().add(bottom);
		bottom.setBounds(40, 340, 832, 10);
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
		pane.setBounds(50, 60, 800, 250);
		// End pane

		jLabelTelaPrincipal = new JLabel();
		jLabelTelaPrincipal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/TelaPrincipal.jpeg"))); // NOI18N
		getContentPane().add(jLabelTelaPrincipal);
		jLabelTelaPrincipal.setBounds(0, -24, 912, 470);
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
