package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.dao.DaoFactory;
import model.dao.SetorDao;
import model.entities.Gerente;
import model.entities.Setor;

public class AddSetor extends JFrame {
	public AddSetor() {
		initComponents();
	}

	private JTextField nomeSetor;
	private JTextField gerente;
	private JTextField des;
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
		nome.setText("Nome: ");
		getContentPane().add(nome);
		nome.setBounds(100, 100, 70, 14);
		// end

		// Home idProduto
		nomeSetor = new JTextField();
		getContentPane().add(nomeSetor);
		nomeSetor.setBounds(200, 100, 180, 30);
		// End

		// home
		c = new JLabel();
		c.setText("Gerente: ");
		getContentPane().add(c);
		c.setBounds(100, 150, 70, 14);
		// end

		// Home idProduto
		gerente = new JTextField();
		getContentPane().add(gerente);
		gerente.setBounds(200, 150, 180, 30);
		// End

		// home
		te = new JLabel();
		te.setText("Descrição: ");
		getContentPane().add(te);
		te.setBounds(100, 200, 70, 14);
		// end

		// Home idProduto
		des = new JTextField();
		getContentPane().add(des);
		des.setBounds(200, 200, 180, 30);
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
		salvar.setBounds(150, 280, 90, 30);
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
		limpar.setBounds(300, 280, 90, 30);
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
		
		Gerente g = new Gerente();
		g.setId(Integer.parseInt(gerente.getText()));
		
		Setor s =  new Setor();
		s.setNome(nomeSetor.getText());
		s.setGerente_setor(g);
		
		SetorDao setor = DaoFactory.createSetorDao();
		setor.insert(s);
		
		JOptionPane.showMessageDialog(null, "Setor cadastrado");
		
	}

	private void limparActionPerformed(java.awt.event.ActionEvent evt) {
		
		nomeSetor.setText("");
		gerente.setText("");
		des.setText("");
		
	}
}
