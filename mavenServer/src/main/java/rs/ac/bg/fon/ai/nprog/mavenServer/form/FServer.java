/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ai.nprog.mavenServer.form;

import rs.ac.bg.fon.ai.nprog.mavenCommonLib.domain.User;
import rs.ac.bg.fon.ai.nprog.mavenServer.controller.Controller;
import rs.ac.bg.fon.ai.nprog.mavenServer.form.config.database.FDatabaseConfig;
import rs.ac.bg.fon.ai.nprog.mavenServer.form.config.server.FServerConfig;
import rs.ac.bg.fon.ai.nprog.mavenServer.history.History;
import rs.ac.bg.fon.ai.nprog.mavenServer.controller.Controller;

import java.awt.Color;
import java.io.IOException;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import rs.ac.bg.fon.ai.nprog.mavenServer.thread.RefreshTimeThread;
import rs.ac.bg.fon.ai.nprog.mavenServer.thread.ServerThread;

/**
 *
 * @author Ivona
 */
public class FServer extends javax.swing.JFrame {
    
	  private ServerThread serverThread;

	    /**
	     * Creates new form FServer
	     */
	    public FServer() {
	        initComponents();
	        jMenuItemServerStop.setEnabled(false);
//	        setExtendedState(MAXIMIZED_BOTH);
	        startTime();
	        jLblServerStatus.setText("Server nije pokrenut");
	        setLocationRelativeTo(null);
	        
	    }

	    /**
	     * This method is called from within the constructor to initialize the form.
	     * WARNING: Do NOT modify this code. The content of this method is always
	     * regenerated by the Form Editor.
	     */
	    @SuppressWarnings("unchecked")
	    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
	    private void initComponents() {

	        jLabel1 = new javax.swing.JLabel();
	        jLblServerStatus = new javax.swing.JLabel();
	        jPanel1 = new javax.swing.JPanel();
	        jPanel2 = new javax.swing.JPanel();
	        jlblTime = new javax.swing.JLabel();
	        jMenuBar1 = new javax.swing.JMenuBar();
	        jMenuServer = new javax.swing.JMenu();
	        jMenuItemServerStart = new javax.swing.JMenuItem();
	        jMenuItemServerStop = new javax.swing.JMenuItem();
	        jMenuItemCurrentUser = new javax.swing.JMenuItem();
	        jMenu1 = new javax.swing.JMenu();
	        jMenuItemServerConf = new javax.swing.JMenuItem();
	        jMenuItem1 = new javax.swing.JMenuItem();
	        jMenu2 = new javax.swing.JMenu();
	        jMenuItem2 = new javax.swing.JMenuItem();

	        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

	        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
	        jLabel1.setForeground(new java.awt.Color(0, 0, 102));
	        jLabel1.setText("Server status:");

	        jLblServerStatus.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
	        jLblServerStatus.setForeground(Color.decode("#610C15"));
	        jLblServerStatus.setText(" ");

	        jPanel1.setBackground(new java.awt.Color(0, 0, 102));

	        jPanel2.setBackground(new java.awt.Color(204, 204, 255));
	        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datum i vreme:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 0, 102))); // NOI18N

	        jlblTime.setBackground(new java.awt.Color(255, 255, 255));
	        jlblTime.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
	        jlblTime.setForeground(new java.awt.Color(0, 0, 102));
	        jlblTime.setText("jLabel2");

	        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
	        jPanel2.setLayout(jPanel2Layout);
	        jPanel2Layout.setHorizontalGroup(
	            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
	                .addContainerGap()
	                .addComponent(jlblTime, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
	                .addContainerGap())
	        );
	        jPanel2Layout.setVerticalGroup(
	            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addComponent(jlblTime, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
	        );

	        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
	        jPanel1.setLayout(jPanel1Layout);
	        jPanel1Layout.setHorizontalGroup(
	            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(jPanel1Layout.createSequentialGroup()
	                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                .addGap(1, 1, 1))
	        );
	        jPanel1Layout.setVerticalGroup(
	            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(jPanel1Layout.createSequentialGroup()
	                .addGap(38, 38, 38)
	                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addContainerGap(184, Short.MAX_VALUE))
	        );

	        jMenuServer.setForeground(new java.awt.Color(0, 0, 102));
	        jMenuServer.setText("Server");
	        jMenuServer.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

	        jMenuItemServerStart.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
	        jMenuItemServerStart.setForeground(new java.awt.Color(0, 0, 102));
	        jMenuItemServerStart.setText("Start");
	        jMenuItemServerStart.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jMenuItemServerStartActionPerformed(evt);
	            }
	        });
	        jMenuServer.add(jMenuItemServerStart);

	        jMenuItemServerStop.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
	        jMenuItemServerStop.setForeground(new java.awt.Color(0, 0, 102));
	        jMenuItemServerStop.setText("Stop");
	        jMenuItemServerStop.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jMenuItemServerStopActionPerformed(evt);
	            }
	        });
	        jMenuServer.add(jMenuItemServerStop);

	        jMenuItemCurrentUser.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
	        jMenuItemCurrentUser.setForeground(new java.awt.Color(0, 0, 102));
	        jMenuItemCurrentUser.setText("CurrentUsers");
	        jMenuItemCurrentUser.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jMenuItemCurrentUserActionPerformed(evt);
	            }
	        });
	        jMenuServer.add(jMenuItemCurrentUser);

	        jMenuBar1.add(jMenuServer);

	        jMenu1.setBackground(new java.awt.Color(204, 204, 255));
	        jMenu1.setForeground(new java.awt.Color(0, 0, 102));
	        jMenu1.setText("Configuration");
	        jMenu1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

	        jMenuItemServerConf.setBackground(new java.awt.Color(204, 204, 255));
	        jMenuItemServerConf.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
	        jMenuItemServerConf.setForeground(new java.awt.Color(0, 0, 102));
	        jMenuItemServerConf.setText("Server");
	        jMenuItemServerConf.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jMenuItemServerConfActionPerformed(evt);
	            }
	        });
	        jMenu1.add(jMenuItemServerConf);

	        jMenuItem1.setBackground(new java.awt.Color(204, 204, 255));
	        jMenuItem1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
	        jMenuItem1.setForeground(new java.awt.Color(0, 0, 102));
	        jMenuItem1.setText("Database");
	        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jMenuItem1ActionPerformed(evt);
	            }
	        });
	        jMenu1.add(jMenuItem1);

	        jMenuBar1.add(jMenu1);

	        jMenu2.setText("History");
	        jMenu2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

	        jMenuItem2.setText("View");
	        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jMenuItem2ActionPerformed(evt);
	            }
	        });
	        jMenu2.add(jMenuItem2);

	        jMenuBar1.add(jMenu2);

	        setJMenuBar(jMenuBar1);

	        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
	        getContentPane().setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addGap(18, 18, 18)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addGroup(layout.createSequentialGroup()
	                        .addGap(0, 0, Short.MAX_VALUE)
	                        .addComponent(jLblServerStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE))
	                    .addGroup(layout.createSequentialGroup()
	                        .addComponent(jLabel1)
	                        .addGap(0, 0, Short.MAX_VALUE))))
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addGap(17, 17, 17)
	                .addComponent(jLabel1)
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                .addComponent(jLblServerStatus)
	                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	        );

	        pack();
	    }// </editor-fold>                        

	    private void jMenuItemServerStartActionPerformed(java.awt.event.ActionEvent evt) {                                                     
	        if (serverThread == null || !serverThread.isAlive()) {
	            try {
	                serverThread = new ServerThread();
	                serverThread.start();
	                
	                jMenuItemServerStart.setEnabled(false);
	                jMenuItemServerStop.setEnabled(true);
	                jLblServerStatus.setText("Server je pokrenut");
	                jLblServerStatus.setForeground(Color.decode("#31A030"));
	            } catch (IOException ex) {
	                System.out.println(ex.getMessage());
	            }
	        } else {
	            System.err.println("Server thread is started.");
	        }
	    }                                                    

	    private void jMenuItemServerStopActionPerformed(java.awt.event.ActionEvent evt) {                                                    
	        try {
	            if (serverThread.getServerSocket() != null && serverThread.getServerSocket().isBound()) {
//	                serverThread.getServerSocket().close();
//	                serverThread.interrupt();
	                serverThread.stopServerThread();
	                jMenuItemServerStart.setEnabled(true);
	                jMenuItemServerStop.setEnabled(false);
	                jLblServerStatus.setText("Server nije pokrenut");
	                jLblServerStatus.setForeground(Color.decode("#610C15"));
	            }
	        } catch (IOException ex) {
	            System.out.println(ex.getMessage());
	        }
	    }                                                   

	    private void jMenuItemCurrentUserActionPerformed(java.awt.event.ActionEvent evt) {                                                     
	        if (serverThread != null && serverThread.isAlive()) {
	            List<User> users = Controller.getInstance().getOnlineUsers();
	            FOnlineUsers fOnlineUsers = new FOnlineUsers(this, true, users);
	            fOnlineUsers.setVisible(true);
	        } else {
	            JOptionPane.showMessageDialog(this, "Server nije pokrenut.");
	        }
	    }                                                    

	    private void jMenuItemServerConfActionPerformed(java.awt.event.ActionEvent evt) {                                                    
	        FServerConfig serverConfig = new FServerConfig();
	        serverConfig.setVisible(true);
	    }                                                   

	    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {                                           
	        FDatabaseConfig fdc = new FDatabaseConfig();
	        fdc.setVisible(true);
	    }                                          

	    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {                                           
	           FHistory fHistory=new FHistory(History.getInstance().getAllHistory());
	           fHistory.setVisible(true);
	    }                                          

	    // Variables declaration - do not modify                     
	    private javax.swing.JLabel jLabel1;
	    private javax.swing.JLabel jLblServerStatus;
	    private javax.swing.JMenu jMenu1;
	    private javax.swing.JMenu jMenu2;
	    private javax.swing.JMenuBar jMenuBar1;
	    private javax.swing.JMenuItem jMenuItem1;
	    private javax.swing.JMenuItem jMenuItem2;
	    private javax.swing.JMenuItem jMenuItemCurrentUser;
	    private javax.swing.JMenuItem jMenuItemServerConf;
	    private javax.swing.JMenuItem jMenuItemServerStart;
	    private javax.swing.JMenuItem jMenuItemServerStop;
	    private javax.swing.JMenu jMenuServer;
	    private javax.swing.JPanel jPanel1;
	    private javax.swing.JPanel jPanel2;
	    private javax.swing.JLabel jlblTime;
	    // End of variables declaration                   

	    private void startTime() {
	        RefreshTimeThread refreshTimeThread = new RefreshTimeThread(jlblTime);
	        refreshTimeThread.start();
	    }
}
