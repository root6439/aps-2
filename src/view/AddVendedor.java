package view;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.dao.DaoFactory;
import model.dao.VendedorDao;
import model.entities.Setor;
import model.entities.Vendedor;

public class AddVendedor extends JFrame {
	public AddVendedor() {
		initComponents();
	}

	private JTextField nomevendedor;
	private JTextField cpf;
	private JTextField setor;
	private JTextField nascimentoField, telefoneField;

	private JButton salvar;
	private JButton limpar;
	private JLabel jLabelTelaPrincipal;
	private JLabel nome, c, set, nascimentoLabel, telefoneLabel;

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
		set = new JLabel();
		set.setText("Setor: ");
		getContentPane().add(set);
		set.setBounds(100, 200, 70, 14);
		// end

		// Home idProduto
		setor = new JTextField();
		getContentPane().add(setor);
		setor.setBounds(200, 200, 180, 30);
		// End
		
		nascimentoLabel = new JLabel();
		nascimentoLabel.setText("Nascimento: ");
		getContentPane().add(nascimentoLabel);
		nome.setBounds(100, 250, 70, 14);
		// end

		// Home idProduto
		nascimentoField = new JTextField();
		getContentPane().add(nascimentoField);
		nascimentoField.setBounds(200, 250, 180, 30);
		
		
		telefoneLabel = new JLabel();
		telefoneLabel.setText("Telefone: ");
		getContentPane().add(telefoneLabel);
		nome.setBounds(100, 300, 70, 14);
		// end

		// Home idProduto
		telefoneField = new JTextField();
		getContentPane().add(telefoneField);
		telefoneField.setBounds(200, 300, 180, 30);

		// home
		salvar = new JButton();
		salvar.setText("SALVAR");
		salvar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					salvarActionPerformed(evt);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		getContentPane().add(salvar);
		salvar.setBounds(150, 350, 90, 30);
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
		limpar.setBounds(300, 350, 90, 30);
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

	private void salvarActionPerformed(java.awt.event.ActionEvent evt) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Setor s = new Setor();
		s.setId(Integer.parseInt(setor.getText()));
		
		Vendedor v = new Vendedor();
		v.setNome(nomevendedor.getText());
		v.setCpf(cpf.getText());
		v.setData_nascimento(sdf.parse(nascimentoField.getText()));
		v.setTelefone(telefoneField.getText());
		v.setSetor_vendedor(s);
		
		VendedorDao vendedor = DaoFactory.createVendedorDao();
		vendedor.insert(v);
		
		JOptionPane.showMessageDialog(null, "Vendedor cadastrado");
		
	}

	private void limparActionPerformed(java.awt.event.ActionEvent evt) {
		nomevendedor.setText("");
		cpf.setText("");
		nascimentoField.setText("");
		telefoneField.setText("");
		setor.setText("");
	}
}
