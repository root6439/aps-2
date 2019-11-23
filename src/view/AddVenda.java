package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import model.entities.Venda;

public class AddVenda extends JFrame {

	private static final long serialVersionUID = 1L;

	public AddVenda() {
		initComponents();
	}

	private JTextField nomeCliente;
	private JTextField cpf;
	private JTextField tel;
	private JTextField data;
	private JButton salvar;
	private JButton limpar;
	private JLabel jLabelTelaPrincipal;
	private JLabel id, nome, c, te, quant, val, ema;
	private JLabel codProduto;
	private JTextField codProdutoField;

	private void initComponents() {
		// Home layout null for background image
		getContentPane().setLayout(null);
		// End

		// home
		nome = new JLabel();
		nome.setText("Código do cliente:");
		getContentPane().add(nome);
		nome.setBounds(100, 100, 70, 50);
		// end

		// Home idProduto
		nomeCliente = new JTextField();
		getContentPane().add(nomeCliente);
		nomeCliente.setBounds(300, 100, 180, 30);
		// End

		// home
		c = new JLabel();
		c.setText("Código do produto: ");
		getContentPane().add(c);
		c.setBounds(100, 150, 70, 14);
		// end

		// Home idProduto
		cpf = new JTextField();
		getContentPane().add(cpf);
		cpf.setBounds(200, 150, 180, 30);
		// End

		// home
		te = new JLabel();
		te.setText("Data da venda: ");
		getContentPane().add(te);
		te.setBounds(100, 200, 70, 14);
		// end

		// Home idProduto
		tel = new JTextField();
		getContentPane().add(tel);
		tel.setBounds(200, 200, 180, 30);
		// End

		// home
		val = new JLabel();
		val.setText("Quantidade: ");
		getContentPane().add(val);
		val.setBounds(100, 250, 70, 14);
		// end

		// Home idProduto
		data = new JTextField();
		getContentPane().add(data);
		data.setBounds(200, 250, 180, 30);
		// End

		// home
		salvar = new JButton();
		salvar.setText("SALVAR");
		salvar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				salvarActionPerformed(evt);
			}
		});
		getContentPane().add(salvar);
		salvar.setBounds(150, 380, 90, 30);
		// end salvar

		// home limpar
		limpar = new JButton();
		limpar.setText("LIMPAR");
		limpar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				limparActionPerformed(evt);
			}
		});
		getContentPane().add(limpar);
		limpar.setBounds(300, 380, 90, 30);
		// end limpar

		// Home
		jLabelTelaPrincipal = new javax.swing.JLabel();
		jLabelTelaPrincipal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/TelaPrincipal.jpeg"))); // NOI18N
		getContentPane().add(jLabelTelaPrincipal);
		jLabelTelaPrincipal.setBounds(0, -30, 650, 470);
		// End

		setSize(new java.awt.Dimension(600, 478));
		setLocationRelativeTo(null);
	}

	private void salvarActionPerformed(java.awt.event.ActionEvent evt) {

		Venda v = new Venda();

	}

	private void limparActionPerformed(java.awt.event.ActionEvent evt) {
	}
}
