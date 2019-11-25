package view;

import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import model.dao.DaoFactory;
import model.dao.ProdutoDao;
import model.dao.SetorDao;
import model.entities.Setor;

public class TelaSetor extends JFrame {

    public TelaSetor() {
        initComponents();
    }

    private JButton add;
    private JButton seacher;
    private JButton edit;
    private JButton delete;
    private JSeparator bottom;
    private JSeparator rightSide;
    private JSeparator leftSide;
    private JSeparator upperMinor;
    private JSeparator upper;
    private JLabel title;
    private JTextField text;
    private JTable tableSetores;
    private JScrollPane scrollPainel;
    private JLabel Logo;

    @SuppressWarnings("unchecked")
    private void initComponents() {

    	SetorDao s = DaoFactory.createSetorDao();
    	List<Setor> sl = s.findAll();
    	
        // Start layout null for background image
        getContentPane().setLayout(null);
        // End

        // Start add
        add = new JButton();
        add.setText("ADICIONAR");
        getContentPane().add(add);
        add.setBounds(370, 370, 90, 40);
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });
        // End add

        // Start seacher
        seacher = new JButton();
        seacher.setText("BUSCAR");
        getContentPane().add(seacher);
        seacher.setBounds(500, 370, 90, 40);
        // End seacher

        // Start edit
        edit = new JButton();
        edit.setText("EDITAR");
        getContentPane().add(edit);
        edit.setBounds(90, 370, 100, 40);
        // End edit

        // Start delete
        delete = new JButton();
        delete.setText("EXCLUIR");
        getContentPane().add(delete);
        delete.setBounds(230, 370, 90, 40);
        delete.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				deleteActionPerformed(evt);
			}
		});
        // End delete

        // Start text
        text = new JTextField();
        getContentPane().add(text);
        text.setBounds(610, 380, 180, 30);
        // End text

        // Start upperMinor
        upperMinor = new JSeparator();
        getContentPane().add(upperMinor);
        upperMinor.setBounds(20, 30, 10, 10);
        // End upperMinor

        // Start leftSide
        leftSide = new JSeparator();
        leftSide.setOrientation(javax.swing.SwingConstants.VERTICAL);
        getContentPane().add(leftSide);
        leftSide.setBounds(20, 30, 10, 330);
        // End leftSide

        // Start upper
        upper = new JSeparator();
        getContentPane().add(upper);
        upper.setBounds(100, 30, 750, 10);
        // End upper

        // Start rightSide
        rightSide = new JSeparator();
        rightSide.setOrientation(javax.swing.SwingConstants.VERTICAL);
        getContentPane().add(rightSide);
        rightSide.setBounds(850, 30, 10, 330);
        // End rightSide

        // Start bottom
        bottom = new JSeparator();
        getContentPane().add(bottom);
        bottom.setBounds(20, 360, 830, 20);
        // End bottom

        // Start title
        title = new JLabel();
        title.setText("SETORES");
        getContentPane().add(title);
        title.setBounds(40, 20, 60, 20);
        // End

        String[] colunas = {"Id", "Nome", "Gerente"};
        
        // Start
        tableSetores = new JTable();
        DefaultTableModel model = new DefaultTableModel(colunas, 0);
        
        for(Setor setor : sl) {
        	model.addRow(new Object[] {setor.getId(), setor.getNome(), setor.getGerente_setor().getNome()});
        }
        
        tableSetores.setModel(model);
        getContentPane().add(tableSetores);
        
        // End

        // Start scrollPainel
        scrollPainel = new JScrollPane();
        scrollPainel.setViewportView(tableSetores);
        getContentPane().add(scrollPainel);
        scrollPainel.setBounds(60, 60, 750, 280);
        // End scrollPainel

        // Start Logo
        Logo = new JLabel();
        Logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/TelaPrincipal.jpeg"))); // NOI18N
        Logo.setIconTextGap(5);
        getContentPane().add(Logo);
        Logo.setBounds(0, -30, 900, 470);
        //End Logo

    }
    
    private void addActionPerformed(java.awt.event.ActionEvent evt) {  
    	AddSetor adp = new AddSetor();
    	adp.setVisible(true);
        adp.setSize(620, 476);
        adp.setLocation(227,126);
    }
    
    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {

		Integer id;
		id = Integer.parseInt(JOptionPane.showInputDialog(null, "Id do Setor a ser removido:", "Remover",
				JOptionPane.OK_CANCEL_OPTION));

		SetorDao s = DaoFactory.createSetorDao();

		JOptionPane.showMessageDialog(null, "Setor removido");

	}
}