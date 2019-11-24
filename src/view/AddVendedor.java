package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class AddVendedor extends JFrame {
	public AddVendedor() {
		initComponents();
	}

	private JTextField nomevendedor;
	private JTextField cpf;
	private JTextField email;
	private JTextField setor;
	private JTextField nascimentoField, telefoneField;

	private JButton salvar;
	private JButton limpar;
	private JLabel jLabelTelaPrincipal;
	private JLabel nome, c, ema, set, nascimentoLabel, telefoneLabel;

	private void initComponents() {
		// Home layout null for background image
		getContentPane().setLayout(null);
		// End

		// home
		nome = new JLabel();
		nome.setText("Nome: ");
		getContentPane().add(nome);
		nome.setBounds(100, 100, 70, 14);
		// end

		// Home idProduto
		nomevendedor = new JTextField();
		getContentPane().add(nomevendedor);
		nomevendedor.setBounds(200, 100, 180, 30);
		// End

		// home
		c = new JLabel();
		c.setText("CPF: ");
		getContentPane().add(c);
		c.setBounds(100, 150, 70, 14);
		// end

		// Home idProduto
		cpf = new JTextField();
		getContentPane().add(cpf);
		cpf.setBounds(200, 150, 180, 30);
		// End

		// home
		ema = new JLabel();
		ema.setText("E-mail: ");
		getContentPane().add(ema);
		ema.setBounds(100, 200, 70, 14);
		// end

		// Home idProduto
		email = new JTextField();
		getContentPane().add(email);
		email.setBounds(200, 200, 180, 30);
		// End

		// home
		set = new JLabel();
		set.setText("Setor: ");
		getContentPane().add(set);
		set.setBounds(100, 250, 70, 14);
		// end

		// Home idProduto
		setor = new JTextField();
		getContentPane().add(setor);
		setor.setBounds(200, 250, 180, 30);
		// End
		
		nascimentoLabel = new JLabel();
		nascimentoLabel.setText("Nascimento: ");
		getContentPane().add(nascimentoLabel);
		nome.setBounds(100, 300, 70, 14);
		// end

		// Home idProduto
		nascimentoField = new JTextField();
		getContentPane().add(nascimentoField);
		nascimentoField.setBounds(200, 300, 180, 30);
		
		telefoneLabel = new JLabel();
		telefoneLabel.setText("Telefone: ");
		getContentPane().add(telefoneLabel);
		nome.setBounds(100, 350, 70, 14);
		// end

		// Home idProduto
		telefoneField = new JTextField();
		getContentPane().add(telefoneField);
		telefoneField.setBounds(200, 350, 180, 30);

		// home
		salvar = new JButton();
		salvar.setText("SALVAR");
		salvar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				salvarActionPerformed(evt);
			}
		});
		getContentPane().add(salvar);
		salvar.setBounds(150, 400, 90, 30);
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
		limpar.setBounds(300, 400, 90, 30);
		// end limpar

		// Home
		jLabelTelaPrincipal = new javax.swing.JLabel();
		jLabelTelaPrincipal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/TelaPrincipal.jpeg")));
		getContentPane().add(jLabelTelaPrincipal);
		jLabelTelaPrincipal.setBounds(0, -30, 800, 470);
		// End

		setSize(new java.awt.Dimension(600, 478));
		setLocationRelativeTo(null);
	}

	private void salvarActionPerformed(java.awt.event.ActionEvent evt) {
	}

	private void limparActionPerformed(java.awt.event.ActionEvent evt) {
	}
}
