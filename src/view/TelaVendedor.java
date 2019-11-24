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
import model.dao.VendedorDao;
import model.entities.Vendedor;

public class TelaVendedor extends JFrame {
	
	private JButton add;
	private JButton search;
	private JButton edit;
	private JButton delete;
	private JTextField text;	
	private JSeparator bottom;
	private JSeparator rightSide;
	private JSeparator leftSide;
	private JSeparator upperMinor;
	private JSeparator upper;
	private JLabel title;
	private JLabel logo;
	private JTable tableVendedor;
	private JScrollPane scrollPainel;
	private javax.swing.JLabel jLabelTelaPrincipal;
	
    public TelaVendedor() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
    	
    	VendedorDao v = DaoFactory.createVendedorDao();
    	List<Vendedor> vl = v.findAll();
    	
    	// Home layout null for background image
        getContentPane().setLayout(null);
    	// End 
    	
    	// Home add
    	add = new JButton();
    	add.setText("ADICIONAR");
        getContentPane().add(add);
        add.setBounds(370, 370, 100, 40);
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
    	// End
    	
    	// Home edit
        edit = new JButton();
        edit.setText("EDITAR");
        getContentPane().add(edit);
        edit.setBounds(90, 370, 100, 40);
    	// End edit
    	
    	// Home delete
        delete = new JButton();
        delete.setText("EXCLUIR");
        getContentPane().add(delete);
        delete.setBounds(230, 370, 90, 40);
    	// End delete
    	
    	// Home bottom
        bottom = new JSeparator();
        getContentPane().add(bottom);
        bottom.setBounds(20, 360, 830, 20);
    	// End bottom
    	
    	// Home rightSide
        rightSide = new JSeparator();
        rightSide.setOrientation(javax.swing.SwingConstants.VERTICAL);
        getContentPane().add(rightSide);
        rightSide.setBounds(850, 30, 10, 330);
    	// End rightSide
    	
    	// Home leftSide
        leftSide = new JSeparator();
        leftSide.setOrientation(javax.swing.SwingConstants.VERTICAL);
        getContentPane().add(leftSide);
        leftSide.setBounds(20, 30, 10, 330);
    	// End leftSide
    	
    	// Home upperMinor
        upperMinor = new JSeparator();
        getContentPane().add(upperMinor);
        upperMinor.setBounds(20, 30, 10, 10);
    	// End upperMinor
    	
    	// Home upper
        upper = new JSeparator();
        getContentPane().add(upper);
        upper.setBounds(125, 30, 725, 10);
    	// End upper
    	
    	// Home text
        text = new JTextField();
        getContentPane().add(text);
        text.setBounds(610, 380, 180, 30);
    	// End text
    	
    	// Home title
        title = new javax.swing.JLabel();
        title.setText("VENDEDORES");
        getContentPane().add(title);
        title.setBounds(40, 20, 80, 20);

        String[] colunas = { "ID", "Nome", "CPF", "Telefone", "Data de Nascimento", "Setor"};
        
    	// Home tableVendedor
        tableVendedor = new JTable();
        DefaultTableModel model = new DefaultTableModel(colunas, 0);
        
        for(Vendedor vendedor : vl) {
        	model.addRow(new Object[] {vendedor.getId(), vendedor.getNome(), vendedor.getCpf(),
        			vendedor.getTelefone(), vendedor.getData_nascimento(), vendedor.getSetor_vendedor().getNome()
        	});
        }
        
        tableVendedor.setModel(model);
        getContentPane().add(tableVendedor);

    	// End tableVendedor

    	// Home scrollPainel
        scrollPainel = new JScrollPane();
        scrollPainel.setViewportView(tableVendedor);
        getContentPane().add(scrollPainel);
        scrollPainel.setBounds(60, 60, 750, 280);
    	// End scrollPainel
 
    	// Home logo
        logo = new JLabel();
        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/TelaPrincipal.jpeg"))); // NOI18N
        logo.setIconTextGap(5);
        getContentPane().add(logo);
        logo.setBounds(0, -30, 900, 470);
    	// End logo
    }
    
    private void addActionPerformed(java.awt.event.ActionEvent evt) {  
    	AddVendedor adp = new AddVendedor();
    	adp.setVisible(true);
        adp.setSize(620, 476);
        adp.setLocation(227,126);
    }
}
