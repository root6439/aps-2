package view;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.dao.ClienteDao;
import model.dao.DaoFactory;
import model.entities.Cliente;

public class AddCliente extends JFrame {
	
	private static final long serialVersionUID = 1L;

	public AddCliente() {
		initComponents();
	}

	private JTextField idCliente;
	private JTextField nomeCliente;
	private JTextField cpf;
	private JTextField tel;
	private JTextField data;
	private JButton salvar;
	private JButton limpar;
	private JLabel jLabelTelaPrincipal;
	private JLabel id, nome, c, te, val;

	private void initComponents() {
		// Home layout null for background image
		getContentPane().setLayout(null);
		// End

		// home
		id = new JLabel();
		id.setText("Id Cliente:");
		getContentPane().add(id);
		id.setBounds(100, 50, 70, 14);
		// end

		// Home idProduto
		idCliente = new JTextField();
		getContentPane().add(idCliente);
		idCliente.setBounds(200, 50, 180, 30);
		// End

		// home
		nome = new JLabel();
		nome.setText("Nome: ");
		getContentPane().add(nome);
		nome.setBounds(100, 100, 70, 14);
		// end

		// Home idProduto
		nomeCliente = new JTextField();
		getContentPane().add(nomeCliente);
		nomeCliente.setBounds(200, 100, 180, 30);
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
		te = new JLabel();
		te.setText("Telefone: ");
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
		val.setText("Nascimento: ");
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
				try {
					salvarActionPerformed(evt);
				} catch (ParseException e) {
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
		jLabelTelaPrincipal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/TelaPrincipal.jpeg"))); // NOI18N
		getContentPane().add(jLabelTelaPrincipal);
		jLabelTelaPrincipal.setBounds(0, -30, 650, 470);
		// End

		setSize(new java.awt.Dimension(600, 478));
		setLocationRelativeTo(null);
	}

	private void salvarActionPerformed(java.awt.event.ActionEvent evt) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		Cliente cliente = new Cliente();
		cliente.setId(Integer.parseInt(idCliente.getText()));
		cliente.setNome(nomeCliente.getText());
		cliente.setCpf(cpf.getText());
		cliente.setTelefone(tel.getText());
		cliente.setData_nascimento(sdf.parse(data.getText()));

		ClienteDao c = DaoFactory.createClienteDao();
		c.insert(cliente);
		
		JOptionPane.showMessageDialog(null, "Cliente cadastrado");

	}

	private void limparActionPerformed(java.awt.event.ActionEvent evt) {

		idCliente.setText("");
		nomeCliente.setText("");
		cpf.setText("");
		tel.setText("");
		data.setText("");
	}
}