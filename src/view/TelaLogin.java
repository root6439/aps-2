package view;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;

public class TelaLogin extends JFrame {
	public TelaLogin() {
        initComponents();
    }
	
	 // Start variables  
	private javax.swing.JLabel jLabelLogoLogin;
    private JButton close;
    private JButton access;
    private JLabel user;
    private JLabel password;
    private JLabel text;
    private JPasswordField userPassword;
    private JTextField userName;
    private JSeparator bottom;
    private JSeparator rightSide;
    private JSeparator leftSide;
    private JSeparator upperMinor;
    private JSeparator upper;    
    // End variables                 


    @SuppressWarnings("unchecked")
    private void initComponents() {
    	
    	// Layout null for background image
        getContentPane().setLayout(null);
    	// End background 

    	// Start access
        access = new JButton();
        access.setText("ACESSAR");
        access.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accessActionPerformed(evt);
            }
        });
        getContentPane().add(access);
        access.setBounds(130, 190, 90, 30);
        // End access
        
        // Start close
        close = new JButton();
        close.setText("SAIR");
        close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeActionPerformed(evt);
            }
        });
        getContentPane().add(close);
        close.setBounds(230, 190, 90, 30);
        // End close 
        
        // Start user
        user = new JLabel();
        user.setText("Usuário:");
        getContentPane().add(user);
        user.setBounds(120, 60, 60, 20);
        // End user
        
        // Start password
        password = new JLabel();
        password.setText("Senha:");
        getContentPane().add(password);
        password.setBounds(120, 90, 40, 14);
        // End password
        
        // Start text
        text = new JLabel();
        text.setText("Tela de Login");
        getContentPane().add(text);
        text.setBounds(100, 20, 90, 20);
        // End text
        
        // Start userPassword
        userPassword = new JPasswordField();
//        userPassword.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                userPasswordActionPerformed(evt);
//            }
//        });
        getContentPane().add(userPassword);
        userPassword.setBounds(180, 90, 150, 20);
        // End userPassword
        
        // Start userName
        userName = new JTextField();
        getContentPane().add(userName);
        userName.setBounds(180, 60, 150, 20);
        // End userName
        
        // Start bottom
        bottom = new JSeparator();
        getContentPane().add(bottom);
        bottom.setBounds(70, 160, 290, 10);
        // End bottom
        
        // Start rightSide
        rightSide = new JSeparator();
        rightSide.setOrientation(javax.swing.SwingConstants.VERTICAL);
        getContentPane().add(rightSide);
        rightSide.setBounds(360, 30, 10, 130);
        // End rightSide
        
        // Start leftSide
        leftSide = new JSeparator();
        leftSide.setOrientation(javax.swing.SwingConstants.VERTICAL);
        getContentPane().add(leftSide);
        leftSide.setBounds(70, 30, 20, 130);
        // End leftSide
        
        // Start upperMinor
        upperMinor = new JSeparator();
        getContentPane().add(upperMinor);
        upperMinor.setBounds(70, 30, 30, 10);
        // End upperMinor
        
        // Start upper
        upper = new JSeparator();
        getContentPane().add(upper);
        upper.setBounds(180, 30, 180, 10);
        // End upper 

        // Start LogoLogin
        jLabelLogoLogin = new JLabel();
        jLabelLogoLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/LogoLogin.PNG"))); // NOI18N
        getContentPane().add(jLabelLogoLogin);
        jLabelLogoLogin.setBounds(0, 0, 460, 289);
        // End LogoLogin

        setLocationRelativeTo(null);
    }

    private void closeActionPerformed(java.awt.event.ActionEvent evt) {                                         
    }                                                                                          

    private void accessActionPerformed(java.awt.event.ActionEvent evt) {                                               
    	TelaPrincipal tp = new TelaPrincipal();
    	tp.setVisible(true);
	tp.setResizable(false);
    }                                             
}
