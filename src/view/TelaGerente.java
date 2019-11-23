package view;

import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import model.dao.DaoFactory;
import model.dao.GerenteDao;
import model.entities.Gerente;

public class TelaGerente extends JFrame {

    public TelaGerente() {
        initComponents();
    }
    
 // Variables declaration 
    private JButton add;
    private JButton delete;
    private JButton edit;
    private JLabel text;
    private JLabel logoLogin;
    private JSeparator upper;
    private JSeparator upperMinor;
    private JSeparator leftSide;
    private JSeparator rightSide;
    private JSeparator bottom;
    private JTextField textField;
    private JScrollPane pane;
    private JTable tableGerente;
    // End variables  

    @SuppressWarnings("unchecked")
    private void initComponents() {
    	
    	GerenteDao g = DaoFactory.createGerenteDao();
    	List<Gerente> gl = g.findAll();
    	
    	// Layout null for background image
        getContentPane().setLayout(null);
    	// End layout 
    	
    	// Start add
    	add = new JButton();
        add.setText("ADICIONAR");
        getContentPane().add(add);
        add.setBounds(130, 363, 110, 40);
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	addActionPerformed(evt);
            }
        });
    	// End add
        
        // Start delete
        delete = new JButton();
        delete.setText("EXCLUIR");
        getContentPane().add(delete);
        delete.setBounds(280, 363, 110, 40);
        //End delete
        
        // Start edit
        edit = new JButton();
        edit.setText("EDITAR");
        getContentPane().add(edit);
        edit.setBounds(430, 363, 110, 40);
        // End edit
        
        // Start text
        text = new JLabel();
        text.setText("GERENTES");
        getContentPane().add(text);
        text.setBounds(40, 20, 60, 20);
        // End text 
        
        // Start upper
        upper = new JSeparator();
        getContentPane().add(upper);
        upper.setBounds(105, 30, 725, 10);
        // End upper
        
        // Start upperMinor
        upperMinor = new JSeparator();
        getContentPane().add(upperMinor);
        upperMinor.setBounds(10, 30, 20, 10);
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
        
        // Start textField
        textField = new JTextField();
        getContentPane().add(textField);
        textField.setBounds(610, 370, 200, 30);
        // End textField

        String[] colunas = {"ID", "Nome", "CPF", "Telefone", "E-mail", "Data de Nascimento"};
        DefaultTableModel model = new DefaultTableModel(colunas, 0);
        
        tableGerente = new JTable();
        
        for(Gerente gerente : gl) {
        	model.addRow(new Object[] {gerente.getId(), gerente.getNome(), gerente.getCpf(), gerente.getTelefone(),
        			gerente.getEmail(), gerente.getData_nascimento()
        	});
        }
        
        tableGerente.setModel(model);
        getContentPane().add(tableGerente);
        
        // Start pane
        pane = new JScrollPane();
        pane.setViewportView(tableGerente);
        getContentPane().add(pane);
        pane.setBounds(20, 60, 800, 250);
        // End pane
        
        // Start LogoLogin
        logoLogin = new JLabel();
        logoLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/TelaPrincipal.jpeg"))); // NOI18N
        getContentPane().add(logoLogin);
        logoLogin.setBounds(0, -30, 900, 470);
        // End LogoLogin
        
       
    }    
    
    private void addActionPerformed(java.awt.event.ActionEvent evt) {  
    	AddGerente adg = new AddGerente();
    	adg.setVisible(true);
    	adg.setSize(620, 476);
    	adg.setLocation(227,126);
    }
}