
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ai.nprog.mavenClient.ui.form;

import rs.ac.bg.fon.ai.nprog.mavenClient.controller.Controller;
import rs.ac.bg.fon.ai.nprog.mavenCommonLib.domain.Hall;
import rs.ac.bg.fon.ai.nprog.mavenCommonLib.domain.Movie;
import rs.ac.bg.fon.ai.nprog.mavenCommonLib.domain.Showtime;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Ivona
 */
public class FShowtime extends javax.swing.JDialog {

    Showtime showtime = null;
    FormMode formMode = null;

    /**
     * Creates new form FShowtime
     */
    public FShowtime(java.awt.Frame parent, boolean modal, FormMode formMode, int showtimeId) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        this.formMode = formMode;
        try {
            prepareForm(showtimeId);
        } catch (Exception ex) {
            Logger.getLogger(FShowtime.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jComboHall = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jtxtTime = new javax.swing.JTextField();
        jbtnSave = new javax.swing.JButton();
        jComboDate = new javax.swing.JComboBox<>();
        jBtnUpdateShowtime = new javax.swing.JButton();
        jLblId = new javax.swing.JLabel();
        jTxtShowtimeId = new javax.swing.JTextField();
        jBttnFindMovie = new javax.swing.JButton();
        jTxtMovieInfo = new javax.swing.JTextField();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Projekcija");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Informacije o projekciji", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14), new java.awt.Color(0, 0, 102))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 102));
        jLabel1.setText("Datum:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 102));
        jLabel2.setText("Sala:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 102));
        jLabel3.setText("Film:");

        jComboHall.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jComboHall.setForeground(new java.awt.Color(0, 0, 102));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 102));
        jLabel4.setText("Vreme:");

        jtxtTime.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtxtTime.setForeground(new java.awt.Color(0, 0, 102));

        jbtnSave.setBackground(new java.awt.Color(0, 0, 102));
        jbtnSave.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jbtnSave.setForeground(new java.awt.Color(255, 255, 255));
        jbtnSave.setText("Sačuvaj");
        jbtnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSaveActionPerformed(evt);
            }
        });

        jComboDate.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jComboDate.setForeground(new java.awt.Color(0, 0, 102));

        jBtnUpdateShowtime.setBackground(new java.awt.Color(0, 0, 102));
        jBtnUpdateShowtime.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jBtnUpdateShowtime.setForeground(new java.awt.Color(255, 255, 255));
        jBtnUpdateShowtime.setText("Izmeni");
        jBtnUpdateShowtime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnUpdateShowtimeActionPerformed(evt);
            }
        });

        jLblId.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLblId.setForeground(new java.awt.Color(0, 0, 102));
        jLblId.setText("ID:");

        jTxtShowtimeId.setEditable(false);
        jTxtShowtimeId.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTxtShowtimeId.setForeground(new java.awt.Color(0, 0, 102));

        jBttnFindMovie.setBackground(new java.awt.Color(0, 0, 102));
        jBttnFindMovie.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jBttnFindMovie.setForeground(new java.awt.Color(255, 255, 255));
        jBttnFindMovie.setText("...");
        jBttnFindMovie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBttnFindMovieActionPerformed(evt);
            }
        });

        jTxtMovieInfo.setEditable(false);
        jTxtMovieInfo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTxtMovieInfo.setForeground(new java.awt.Color(0, 0, 102));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLblId))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboHall, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jtxtTime)
                            .addComponent(jComboDate, 0, 116, Short.MAX_VALUE)
                            .addComponent(jTxtShowtimeId, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTxtMovieInfo)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(jbtnSave)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                        .addComponent(jBtnUpdateShowtime)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBttnFindMovie, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLblId)
                    .addComponent(jTxtShowtimeId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtxtTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboHall, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jBttnFindMovie)
                    .addComponent(jTxtMovieInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnSave)
                    .addComponent(jBtnUpdateShowtime))
                .addGap(28, 28, 28))
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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>                        

    private void jbtnSaveActionPerformed(java.awt.event.ActionEvent evt) {                                         
        SimpleDateFormat stf = new SimpleDateFormat("HH:mm");
        String t = jtxtTime.getText().trim();
        Date time;

        if (movie == null || jComboDate.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(this, "Sva polja su obavezna.");
            return;
        }
        try {
            time = stf.parse(t);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(this, "Pogresan format datuma..");
            return;
        }
        try {
            saveShowtime(time);
        } catch (Exception ex) {
            Logger.getLogger(FShowtime.class.getName()).log(Level.SEVERE, null, ex);
        }

    }                                        

    private void jBtnUpdateShowtimeActionPerformed(java.awt.event.ActionEvent evt) {                                                   
        if (jComboHall.getSelectedIndex() != -1) {
            Hall selectedHall = (Hall) jComboHall.getSelectedItem();
            try {
                Controller.getInstance().updateShowtime(showtime, selectedHall, this);
            } catch (Exception ex) {
                Logger.getLogger(FShowtime.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        dispose();
    }                                                  
    Movie movie;
    private void jBttnFindMovieActionPerformed(java.awt.event.ActionEvent evt) {                                               
        FMovieSearch fMovieSearch = new FMovieSearch(null, true, FormMode.FORM_SELECT);
        fMovieSearch.setVisible(true);
        movie = fMovieSearch.getMovie();
        if (movie == null) {
            return;
        }
        jTxtMovieInfo.setText(fMovieSearch.getMovie().getName());
    }                                              
    public void showtimeIsUpdated() {
        JOptionPane.showMessageDialog(this, "Sistem je zapamtio projekciju.");

    }

    public void showtimeIsNotUpdated() {
        JOptionPane.showMessageDialog(this, "Sistem nije zapamtio projekciju.");

    }
    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify                     
    private javax.swing.JButton jBtnUpdateShowtime;
    private javax.swing.JButton jBttnFindMovie;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboDate;
    private javax.swing.JComboBox<Hall> jComboHall;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLblId;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTxtMovieInfo;
    private javax.swing.JTextField jTxtShowtimeId;
    private javax.swing.JButton jbtnSave;
    private javax.swing.JTextField jtxtTime;
    // End of variables declaration                   

    private void prepareForm(int id) throws Exception {
        if (formMode == FormMode.FORM_ADD) {
            fillComboHall();

            jBtnUpdateShowtime.setVisible(false);
            jTxtShowtimeId.setVisible(false);
            jLblId.setVisible(false);
            fillComboDate();
        } else if (formMode == FormMode.FORM_VIEW || formMode == FormMode.FORM_UPDATE) {
            Controller.getInstance().getShowtimeWithId(id, this);
        }

    }

    private void setSelectedMovie(Movie selectedMovie) throws Exception {

        jTxtMovieInfo.setText(selectedMovie.toString());

    }

    private void fillComboHall() throws Exception {
        jComboHall.removeAllItems();
        Controller.getInstance().getAllHalls(this);

    }

    public void setHallsForShowtime(List<Hall> halls) {
        for (Hall hall : halls) {
            jComboHall.addItem(hall);
            if (formMode.equals(FormMode.FORM_UPDATE)) {
                if (hall.equals(showtime.getHall())) {
                    jComboHall.setSelectedItem(showtime.getHall());
                }
            }
        }

    }

    private void saveShowtime(Date time) throws Exception {
        Showtime showtime;

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Hall hall = (Hall) jComboHall.getSelectedItem();
        try {
            showtime = new Showtime(sdf.parse((String) jComboDate.getSelectedItem()), time, Controller.getInstance().getCurrentUser(), hall, movie);
            this.showtime = showtime;
            Controller.getInstance().saveShowtime(showtime, this);
        } catch (ParseException ex) {
            Logger.getLogger(FShowtime.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    Showtime getNewShowtime() {
        return showtime;
    }

    private void fillComboDate() {
        jComboDate.removeAllItems();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        jComboDate.addItem(sdf.format(calendar.getTime()));

        for (int i = 0; i < 10; i++) {
            calendar.add(Calendar.DAY_OF_MONTH, 1);
            jComboDate.addItem(sdf.format(calendar.getTime()));
        }
    }

    private void fillComboDate(Date date) {
        jComboDate.removeAllItems();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        jComboDate.addItem(sdf.format(calendar.getTime()));

        if (sdf.format(date).equals(sdf.format(calendar.getTime()))) {
            jComboDate.setSelectedItem(sdf.format(calendar.getTime()));
        }
        for (int i = 0; i < 10; i++) {
            calendar.add(Calendar.DAY_OF_MONTH, 1);
            jComboDate.addItem(sdf.format(calendar.getTime()));
            if (sdf.format(date).equals(sdf.format(calendar.getTime()))) {
                jComboDate.setSelectedItem(sdf.format(calendar.getTime()));
            }
        }
    }

    public void hallLoadingFailed() {
        JOptionPane.showMessageDialog(this, "Sale nisu uspesno ucitane.");
    }

    public void moviesLoadingFailed() {
        JOptionPane.showMessageDialog(this, "Filmovi nisu uspesno ucitani.");
    }

    public void showtimeIsSaved() {
        JOptionPane.showMessageDialog(this, "Sistem je zapamtio projekciju.");
        dispose();
    }

    public void showtimeIsNotSaved() {
        JOptionPane.showMessageDialog(this, "Sistem ne može da zapamti projekciju.");
    }

    public void showtimeLoaded(Showtime sh) throws Exception {
        this.showtime = sh;
        if (formMode == FormMode.FORM_UPDATE) {
            fillComboHall();
            fillComboDate(showtime.getDate());

        } else if (formMode == FormMode.FORM_VIEW) {
            jBtnUpdateShowtime.setVisible(false);
            jComboHall.setEditable(false);
            jComboDate.addItem(showtime.getDate().toString());
            jComboHall.addItem(showtime.getHall());
            jComboDate.setSelectedItem(showtime.getDate().toString());
            jComboHall.setSelectedItem(showtime.getHall());

        }
        jbtnSave.setVisible(false);
        jBttnFindMovie.setVisible(false);

        jTxtShowtimeId.setText(showtime.getShowtimeId() + "");
        jTxtMovieInfo.setText(showtime.getMovie().toString());
        jtxtTime.setText(showtime.getTime().toString());
        jtxtTime.setEditable(false);
        jComboDate.setEnabled(false);

    }

    public void showtimeNotLoaded() {
        JOptionPane.showMessageDialog(this, "Projekcija nije ucitana.");
    }
    
    
    public void invalidDateAndTime(){
        JOptionPane.showMessageDialog(this, "Nije moguce kreirati projekciju, datum i vreme projekcije su u proslosti.");
    }
}
