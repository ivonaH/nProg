/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ai.nprog.mavenClient.ui.form;

import rs.ac.bg.fon.ai.nprog.mavenClient.controller.Controller;
import rs.ac.bg.fon.ai.nprog.mavenCommonLib.domain.Genre;
import rs.ac.bg.fon.ai.nprog.mavenCommonLib.domain.Movie;
import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Ivona
 */
public class FMovie extends javax.swing.JDialog {

    /**
     * Creates new form FFilm
     */
    public FMovie(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        fillGenreCombo();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jtxtMovieName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jcomboGenre = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jtxtDirector = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jtxtYear = new javax.swing.JTextField();
        jbtnSave = new javax.swing.JButton();
        jbtnCancel = new javax.swing.JButton();
        jtxtMovieId = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jtxtDuration = new javax.swing.JTextField();
        jLabNameEr = new javax.swing.JLabel();
        jLabGenreEr = new javax.swing.JLabel();
        jLabDirectorEr = new javax.swing.JLabel();
        jLabYearEr = new javax.swing.JLabel();
        jLabDurationEr = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Movie");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Movie information", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14), new java.awt.Color(0, 0, 102))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 102));
        jLabel1.setText("Naziv filma:");

        jtxtMovieName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtxtMovieName.setForeground(new java.awt.Color(0, 0, 102));
        jtxtMovieName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtMovieNameActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 102));
        jLabel2.setText("Žanr:");

        jcomboGenre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jcomboGenre.setForeground(new java.awt.Color(0, 0, 102));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 102));
        jLabel3.setText("Producent:");

        jtxtDirector.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtxtDirector.setForeground(new java.awt.Color(0, 0, 102));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 102));
        jLabel4.setText("Godina:");

        jtxtYear.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtxtYear.setForeground(new java.awt.Color(0, 0, 102));

        jbtnSave.setBackground(new java.awt.Color(0, 0, 102));
        jbtnSave.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jbtnSave.setForeground(new java.awt.Color(255, 255, 255));
        jbtnSave.setText("Save");
        jbtnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSaveActionPerformed(evt);
            }
        });

        jbtnCancel.setBackground(new java.awt.Color(0, 0, 102));
        jbtnCancel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jbtnCancel.setForeground(new java.awt.Color(255, 255, 255));
        jbtnCancel.setText("Cancel");
        jbtnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCancelActionPerformed(evt);
            }
        });

        jtxtMovieId.setEditable(false);
        jtxtMovieId.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtxtMovieId.setForeground(new java.awt.Color(0, 0, 102));
        jtxtMovieId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtMovieIdActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 102));
        jLabel5.setText(" Id:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 102));
        jLabel6.setText("Trajanje:");

        jtxtDuration.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtxtDuration.setForeground(new java.awt.Color(0, 0, 102));

        jLabNameEr.setText(" *");

        jLabGenreEr.setText(" *");

        jLabDirectorEr.setText(" *");

        jLabYearEr.setText(" *");

        jLabDurationEr.setText(" *");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addComponent(jbtnCancel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbtnSave)
                .addContainerGap(125, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabDurationEr))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabYearEr))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabDirectorEr))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabGenreEr))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabNameEr))
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtxtDirector, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtxtYear, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcomboGenre, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtxtMovieName, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtxtMovieId, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtxtDuration, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jtxtMovieId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtxtMovieName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabNameEr))
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jcomboGenre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabGenreEr))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtxtDirector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabDirectorEr))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jtxtYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabYearEr))
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jtxtDuration, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabDurationEr))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnCancel)
                    .addComponent(jbtnSave))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtxtMovieNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtMovieNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtMovieNameActionPerformed

    private void jbtnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSaveActionPerformed
        if (checkTxtFields()) {
            Movie movie;
            movie = new Movie(jtxtMovieName.getText(), (Genre) jcomboGenre.getSelectedItem(), jtxtDirector.getText(), Integer.parseInt(jtxtYear.getText()), Integer.parseInt(jtxtDuration.getText()), Controller.getInstance().getCurrentUser());
            try {
               Controller.getInstance().saveMovie(movie, this);
            } catch (Exception ex) {
                Logger.getLogger(FMovie.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_jbtnSaveActionPerformed

    private void jbtnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCancelActionPerformed
        dispose();
    }//GEN-LAST:event_jbtnCancelActionPerformed

    private void jtxtMovieIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtMovieIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtMovieIdActionPerformed

    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabDirectorEr;
    private javax.swing.JLabel jLabDurationEr;
    private javax.swing.JLabel jLabGenreEr;
    private javax.swing.JLabel jLabNameEr;
    private javax.swing.JLabel jLabYearEr;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbtnCancel;
    private javax.swing.JButton jbtnSave;
    private javax.swing.JComboBox<Genre> jcomboGenre;
    private javax.swing.JTextField jtxtDirector;
    private javax.swing.JTextField jtxtDuration;
    private javax.swing.JTextField jtxtMovieId;
    private javax.swing.JTextField jtxtMovieName;
    private javax.swing.JTextField jtxtYear;
    // End of variables declaration//GEN-END:variables

    private void fillGenreCombo() {
        jcomboGenre.removeAllItems();
        for (Genre zanr : Genre.values()) {
            jcomboGenre.addItem(zanr);
        }
        jcomboGenre.setSelectedIndex(-1);
    }

    private boolean checkTxtFields() {
        boolean ok = true;
        if (jtxtDuration.getText().equals("")) {
            jLabDurationEr.setForeground(Color.red);
            ok = false;
        } else {
            jLabDurationEr.setForeground(Color.green);
        }
        if (jcomboGenre.getSelectedIndex() == -1) {
            jLabGenreEr.setForeground(Color.red);
            ok = false;
        } else {
            jLabGenreEr.setForeground(Color.green);

        }
        if (jtxtDirector.getText().equals("")) {
            jLabDirectorEr.setForeground(Color.red);
            ok = false;
        } else {
            jLabDirectorEr.setForeground(Color.green);

        }
        if (jtxtYear.getText().equals("")) {
            jLabYearEr.setForeground(Color.red);
            ok = false;
        } else {
            jLabYearEr.setForeground(Color.green);

        }
        if (jtxtMovieName.getText().equals("")) {
            jLabNameEr.setForeground(Color.red);
            ok = false;
        } else {
            jLabNameEr.setForeground(Color.green);

        }

        if (ok == false) {
            JOptionPane.showMessageDialog(this, "Sva polja su obaveznas.");
        }

        return ok;
    }

    public void movieIsNotSaved() {
        JOptionPane.showMessageDialog(this, "Sistem ne moze da zapamti film.");
    }

    public void movieIsSaved() {
        JOptionPane.showMessageDialog(this, "Sistem je zapamtio film.");
        dispose();
    }

}