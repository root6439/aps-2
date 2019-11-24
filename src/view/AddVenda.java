package view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.dao.DaoFactory;
import model.dao.VendaDao;
import model.entities.Cliente;
import model.entities.Produto;
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

	private void initComponents() {
		// Home layout null for background image
		getContentPane().setLayout(null);
		// End

		// home
		nome = new JLabel();
		nome.setText("Código do cliente:");
		getContentPane().add(nome);
		nome.setBounds(100, 100, 150, 30);
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
		c.setBounds(100, 150, 150, 30);
		// end

		// Home idProduto
		cpf = new JTextField();
		getContentPane().add(cpf);
		cpf.setBounds(300, 150, 180, 30);
		// End

		// home
		te = new JLabel();
		te.setText("Data da venda: ");
		getContentPane().add(te);
		te.setBounds(100, 200, 180, 30);
		// end

		// Home idProduto
		tel = new JTextField();
		getContentPane().add(tel);
		tel.setBounds(300, 200, 180, 30);
		// End

		// home
		val = new JLabel();
		val.setText("Quantidade: ");
		getContentPane().add(val);
		val.setBounds(100, 250, 180, 30);
		// end

		// Home idProduto
		data = new JTextField();
		getContentPane().add(data);
		data.setBounds(300, 250, 180, 30);
		// End

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

	private void salvarActionPerformed(java.awt.event.ActionEvent evt) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Produto p = new Produto();
		p.setId(Integer.parseInt(cpf.getText()));
		
		Cliente c = new Cliente();
		c.setId(Integer.parseInt(nomeCliente.getText()));
		
		Venda v = new Venda();
		v.setVenda_cliente(c);
		v.setVenda_produto(p);
		v.setNum_itens_vendidos(Integer.parseInt(data.getText()));
		v.setData_venda(sdf.parse(tel.getText()));
		
		VendaDao venda = DaoFactory.createVendaDao();
		venda.insert(v);
		
		JOptionPane.showMessageDialog(null, "Venda cadastrada");

	}

	private void limparActionPerformed(java.awt.event.ActionEvent evt) {
		
		nomeCliente.setText("");
		cpf.setText("");
		tel.setText("");
		data.setText("");
		
	}
}
