package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.dao.DaoFactory;
import model.dao.ProdutoDao;
import model.dao.SetorDao;
import model.entities.Produto;
import model.entities.Setor;

public class AddProduto extends JFrame {
	public AddProduto() {
		initComponents();
	}
	
	private JTextField idProduto;
	private JTextField nomeProduto;
	private JTextField setorProduto;
	private JTextField descricao;
	private JTextField quantidade;
	private JTextField valor;
	private JButton salvar;
	private JButton limpar;
	private JLabel jLabelTelaPrincipal;
	private JLabel id, nome, setor, des, quant, val;
	
	private void initComponents() {
		// Home layout null for background image
        getContentPane().setLayout(null);
		// End 
        
        // home
        id = new JLabel();
        id.setText("Id Produto:");
        getContentPane().add(id);
        id.setBounds(100, 50, 70, 14);
        //end
        
        // Home idProduto
        idProduto = new JTextField();
        getContentPane().add(idProduto);
        idProduto.setBounds(200, 50, 180, 30);
        // End
        
        // home
        nome = new JLabel();
        nome.setText("Nome: ");
        getContentPane().add(nome);
        nome.setBounds(100, 100, 70, 14);
        //end
        
        // Home idProduto
        nomeProduto = new JTextField();
        getContentPane().add(nomeProduto);
        nomeProduto.setBounds(200, 100, 180, 30);
        // End
        
        // home
        setor = new JLabel();
        setor.setText("Setor: ");
        getContentPane().add(setor);
        setor.setBounds(100, 150, 70, 14);
        //end
        
        // Home idProduto
        setorProduto = new JTextField();
        getContentPane().add(setorProduto);
        setorProduto.setBounds(200, 150, 180, 30);
        // End
        
        // home
        des = new JLabel();
        des.setText("Descrição: ");
        getContentPane().add(des);
        des.setBounds(100, 200, 70, 14);
        //end
        
        // Home idProduto
        descricao = new JTextField();
        getContentPane().add(descricao);
        descricao.setBounds(200, 200, 180, 30);
        // End
        
        // home
        quant = new JLabel();
        quant.setText("Quantidade: ");
        getContentPane().add(quant);
        quant.setBounds(100, 250, 70, 14);
        //end
        
        // Home idProduto
       
        // End
        
        // home
        val = new JLabel();
        val.setText("Valor: ");
        getContentPane().add(val);
        val.setBounds(100, 300, 70, 14);
        //end
        
        // Home idProduto
        valor = new JTextField();
        getContentPane().add(valor);
        valor.setBounds(200, 300, 180, 30);
        // End
        
        // home 
        salvar = new JButton();
        salvar.setText("ADICIONAR");
        salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	salvarActionPerformed(evt);
            }
        });
        getContentPane().add(salvar);
        salvar.setBounds(500, 190, 90, 30);
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
        limpar.setBounds(500, 290, 90, 30);
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

    	Produto p = new Produto();
    	p.setNome(nomeProduto.getText());
    	p.setDescricao(descricao.getText());
    	p.setValor(Double.parseDouble(valor.getText()));
    	
    	Setor s = new Setor();
    	s.setId(Integer.parseInt(setorProduto.getText()));
    	
    	p.setProduto_setor(s);
    	
    	ProdutoDao produto = DaoFactory.createProdutoDao();
    	produto.insert(p);
    	
    	JOptionPane.showMessageDialog(null, "Produto cadastrado");
    	
    }
    
    private void limparActionPerformed(java.awt.event.ActionEvent evt) {
    	idProduto.setText("");
    	nomeProduto.setText("");
    	setorProduto.setText("");
    	descricao.setText("");
    	quantidade.setText("");
    	valor.setText("");
    }
}
