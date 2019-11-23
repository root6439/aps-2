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
import model.dao.VendaDao;
import model.entities.Venda;

public class TelaVenda extends JFrame {
	
	private JButton add;
	private JButton search;
	private JButton edit;
	private JButton delete;
	private JSeparator bottom;
	private JSeparator rightSide;
	private JSeparator leftSide;
	private JSeparator upperMinor;
	private JSeparator upper;
	private JTextField text;
	private JLabel title;
	private JTable tableVendas;
	private JScrollPane scrollPainel;
	private JLabel logo;
	
    public TelaVenda() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
    	
    	VendaDao v = DaoFactory.createVendaDao();
    	List<Venda> vl = v.findAll();
    	
    	// Home layout null for background image 
        getContentPane().setLayout(null);
    	// End 
    	
    	// Home add
    	add = new JButton();
    	add.setText("ADICIONAR");
        getContentPane().add(add);
        add.setBounds(360, 370, 110, 40);
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });
    	// End add
    	
    	// Home search
        search = new JButton();
        search.setText("BUSCAR");
        getContentPane().add(search);
        search.setBounds(500, 370, 90, 40);
    	// End search
    	
    	// Home edit
        edit = new javax.swing.JButton();
        edit.setText("EDITAR");
        getContentPane().add(edit);
        edit.setBounds(90, 370, 100, 40);
    	// End edit
    	
    	// Home delete
        delete = new javax.swing.JButton();
        delete.setText("EXCLUIR");
        getContentPane().add(delete);
        delete.setBounds(230, 370, 90, 40);
    	// End delete
    	
    	// Home bottom
        bottom = new javax.swing.JSeparator();
        getContentPane().add(bottom);
        bottom.setBounds(20, 360, 830, 20);
    	// End bottom
    	
    	// Home rightSide
        rightSide = new javax.swing.JSeparator();
        rightSide.setOrientation(javax.swing.SwingConstants.VERTICAL);
        getContentPane().add(rightSide);
        rightSide.setBounds(850, 30, 10, 330);
    	// End rightSide
    	
    	// Home leftSide
        leftSide = new javax.swing.JSeparator();
        leftSide.setOrientation(javax.swing.SwingConstants.VERTICAL);
        getContentPane().add(leftSide);
        leftSide.setBounds(20, 30, 10, 330);
    	// End leftSide
    	
    	// Home upperMinor
        upperMinor = new javax.swing.JSeparator();
        getContentPane().add(upperMinor);
        upperMinor.setBounds(20, 30, 10, 10);
    	// End upperMinor
    	
    	// Home upper
        upper = new javax.swing.JSeparator();
        getContentPane().add(upper);
        upper.setBounds(95, 30, 755, 10);
    	// End  upper
    	
    	// Home text
        text = new javax.swing.JTextField();
        getContentPane().add(text);
        text.setBounds(610, 380, 180, 30);
    	// End text
    	
    	// Home title
        title = new javax.swing.JLabel();
        title.setText("VENDAS");
        getContentPane().add(title);
        title.setBounds(40, 20, 60, 20);
    	// End title
    	
        String[] colunas = {"Id", "Nome do cliente", "Produto", "Itens vendidos"};
        
    	// Home tableVendas
        tableVendas = new JTable();
        DefaultTableModel model = new DefaultTableModel(colunas, 0);
        
        for(Venda venda : vl) {
        	model.addRow(new Object[] {venda.getId(), venda.getVenda_cliente().getNome(), venda.getVenda_produto().getNome(),
        			venda.getNum_itens_vendidos()
        	});
        }
        
        tableVendas.setModel(model);
        getContentPane().add(tableVendas);
        
        // End tableVendas
    	
    	// Home scrollPainel
        scrollPainel = new javax.swing.JScrollPane();
        scrollPainel.setViewportView(tableVendas);
        getContentPane().add(scrollPainel);
        scrollPainel.setBounds(60, 60, 750, 280);
    	// End scrollPainel
    	
    	// Home logo
        logo = new javax.swing.JLabel();
        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/TelaPrincipal.jpeg"))); // NOI18N
        logo.setIconTextGap(5);
        getContentPane().add(logo);
        logo.setBounds(0, -30, 900, 470);
    	// End logo
    }
    
    private void addActionPerformed(java.awt.event.ActionEvent evt) {  
    	AddVenda adp = new AddVenda();
    	adp.setVisible(true);
        adp.setSize(620, 476);
        adp.setLocation(227,126);
    }
}