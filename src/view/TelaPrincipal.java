package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class TelaPrincipal extends JFrame {
	
    // Variables declaration - do not modify  
	private JButton product;
	private JButton client;
	private JButton manager;
	private JButton sales;
	private JButton sector;
	private JButton salesman;
	    
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabelImgCliente;
    private javax.swing.JLabel jLabelImgGerente;
    private javax.swing.JLabel jLabelImgProdutos;
    private javax.swing.JLabel jLabelProdutos;
    private javax.swing.JLabel jLabelTelaPrincipal;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration  

    public TelaPrincipal() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
    	
    	// Home layout null for background image
        getContentPane().setLayout(null);
    	// End layout
    	
    	// Home
        jLabel2 = new javax.swing.JLabel();
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Logo.jpeg"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(-100, 10, 380, 120);
    	// End 
        
    	// Home
        jLabel5 = new javax.swing.JLabel();
        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setText("Usuário: pauloglata");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(50, 220, 150, 30);
    	// End 
        
    	// Home
        jLabel6 = new javax.swing.JLabel();
        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setText("Gerente de vendas");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(50, 250, 160, 30);
    	// End
        
    	
    	// Home
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(440, 80, 10, 220);
    	// End 
    	
    	// Home product
    	product = new javax.swing.JButton();
    	product.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Produtos.jpeg"))); // NOI18N
    	product.setSelected(true);
    	getContentPane().add(product);
    	product.setBounds(470, 80, 60, 50);
    	product.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	productActionPerformed(evt);
            }
        });
    	// End product
    	
    	// Home
        jLabel3 = new javax.swing.JLabel();
        jLabel3.setText("PRODUTOS");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(470, 140, 80, 20);
    	// End 
    	
    	// Home client
    	client = new javax.swing.JButton();
    	client.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Clientes.jpeg"))); // NOI18N
    	client.setSelected(true);
        getContentPane().add(client);
        client.setBounds(620, 80, 60, 50);
        client.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clientActionPerformed(evt);
            }
        });
    	// End client
        
        // Home
        jLabel1 = new javax.swing.JLabel();
        jLabel1.setText("CLIENTES");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(622, 140, 80, 14);
        // End
    	
    	// Home manager
        manager = new javax.swing.JButton();
        manager.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Gerente.jpeg"))); // NOI18N
        manager.setSelected(true);
        getContentPane().add(manager);
        manager.setBounds(760, 80, 60, 50);
        manager.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                managerActionPerformed(evt);
            }
          });
    	// End manager
        
        // Home
        jLabelProdutos = new javax.swing.JLabel();
        jLabelProdutos.setText("GERENTES");
        getContentPane().add(jLabelProdutos);
        jLabelProdutos.setBounds(760, 140, 80, 14);
        // End
    	
    	// Home salesman
        salesman = new javax.swing.JButton();
        salesman.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Vendedor.jpeg"))); // NOI18N
        salesman.setSelected(true);
        getContentPane().add(salesman);
        salesman.setBounds(760, 210, 60, 50);
        salesman.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	salesmanActionPerformed(evt);
            }
        });
    	// End salesman
        
    	// Home
        jLabel4 = new javax.swing.JLabel();
        jLabel4.setText("VENDEDORES");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(750, 265, 80, 20);
    	// End 
    	
    	// Home
        sales = new javax.swing.JButton();
        sales.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Venda.jpeg"))); // NOI18N
        sales.setSelected(true);
        getContentPane().add(sales);
        sales.setBounds(470, 210, 60, 50);
        sales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	salesActionPerformed(evt);
            }
          });
    	// End 
        
    	// Home
        jLabel5 = new javax.swing.JLabel();
        jLabel5.setText("VENDAS");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(475, 265, 80, 20);
    	// End 
    	
    	// Home
        sector = new javax.swing.JButton();
        sector.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Produtos.jpeg"))); // NOI18N
        sector.setSelected(true);
        getContentPane().add(sector);
        sector.setBounds(620, 210, 60, 50);
        sector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	sectorActionPerformed(evt);
            }
        });
    	// End 
        
    	// Home
        jLabel6 = new javax.swing.JLabel();
        jLabel6.setText("SETORES");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(625, 265, 80, 20);
    	// End 
        
    	// Home
        jLabel7 = new javax.swing.JLabel();
        jLabel7.setText("@ares 2019");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(800, 390, 70, 14);
    	// End 
        
    	// Home
        jLabelTelaPrincipal = new javax.swing.JLabel();
        jLabelTelaPrincipal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/TelaPrincipal.jpeg"))); // NOI18N
      getContentPane().add(jLabelTelaPrincipal);
      jLabelTelaPrincipal.setBounds(0, -30, 900, 470);
    	// End 

        setSize(new java.awt.Dimension(913, 478));
        setLocationRelativeTo(null);
    }                       

    private void clientActionPerformed(java.awt.event.ActionEvent evt) {                                         
    	TelaClientes tc = new TelaClientes();
    	tc.setVisible(true);
    	tc.setResizable(false);
        tc.setSize(912, 476);
        tc.setLocation(227,126);
    }                                        

    private void managerActionPerformed(java.awt.event.ActionEvent evt) {                                         
    	TelaGerente tg = new TelaGerente();
    	tg.setVisible(true);
	tg.setResizable(false);
        tg.setSize(912, 476);
        tg.setLocation(227,126);
    }  
    
    private void productActionPerformed(java.awt.event.ActionEvent evt) {                                         
    	TelaProdutos tp = new TelaProdutos();
    	tp.setVisible(true);
	tp.setResizable(false);
        tp.setSize(912, 476);
        tp.setLocation(227,126);
    }
    
    private void salesActionPerformed(java.awt.event.ActionEvent evt) {                                         
    	TelaVenda tv = new TelaVenda();
    	tv.setVisible(true);
	tv.setResizable(false);
        tv.setSize(912, 476);
        tv.setLocation(227,126);
    }
    
    private void sectorActionPerformed(java.awt.event.ActionEvent evt) {                                         
    	TelaSetor ts = new TelaSetor();
    	ts.setVisible(true);
	ts.setResizable(false);
        ts.setSize(912, 476);
        ts.setLocation(227,126);
    }
    
    private void salesmanActionPerformed(java.awt.event.ActionEvent evt) {                                         
    	TelaVendedor tvs = new TelaVendedor();
    	tvs.setVisible(true);
    	tvs.setResizable(false);
        tvs.setSize(912, 476);
        tvs.setLocation(227,126);
    }
      
	
}
