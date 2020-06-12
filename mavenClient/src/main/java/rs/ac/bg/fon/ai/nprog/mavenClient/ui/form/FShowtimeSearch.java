/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ai.nprog.mavenClient.ui.form;

import rs.ac.bg.fon.ai.nprog.mavenClient.controller.Controller;
import rs.ac.bg.fon.ai.nprog.mavenCommonLib.domain.Movie;
import rs.ac.bg.fon.ai.nprog.mavenCommonLib.domain.Showtime;
import java.awt.Color;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.JTableHeader;
import rs.ac.bg.fon.ai.nprog.mavenClient.ui.component.table.model.ShowtimeTableModel;

/**
 *
 * @author Ivona
 */
public class FShowtimeSearch extends javax.swing.JDialog {

    // private List<Showtime> addedShowtimes;
    /**
     * Creates new form FProjekcija
     */
    public FShowtimeSearch(java.awt.Frame parent, boolean modal, FormMode formMode) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        prepareTable();
        try {
            fillForm(formMode);
        } catch (Exception ex) {
            Logger.getLogger(FShowtimeSearch.class.getName()).log(Level.SEVERE, null, ex);
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanelMovie = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtxtGenre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jtxtDirector = new javax.swing.JTextField();
        jtxtYear = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jBtnAllMovies = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jComboDate = new javax.swing.JComboBox<>();
        jBttnSearch = new javax.swing.JButton();
        jTxtMovie = new javax.swing.JTextField();
        jLblPonistiParametrePretrage1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jRadioButtonFuture = new javax.swing.JRadioButton();
        jRadioButtonPast = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableShowtime = new javax.swing.JTable();
        jBtnDeleteShowtime = new javax.swing.JButton();
        jBtnUpdateShowtime = new javax.swing.JButton();
        jBtnAddToMovieMarathon = new javax.swing.JButton();
        jBtnSelectShowtime = new javax.swing.JButton();
        jBtnDetails = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Pretraga projekcija");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Projekcija", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14), new java.awt.Color(0, 0, 102))); // NOI18N

        jPanelMovie.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Izaberite Film", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12), new java.awt.Color(0, 0, 102))); // NOI18N
        jPanelMovie.setForeground(new java.awt.Color(0, 0, 102));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 102));
        jLabel1.setText("Film:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 102));
        jLabel3.setText("Žanr:");

        jtxtGenre.setEditable(false);
        jtxtGenre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtxtGenre.setForeground(new java.awt.Color(0, 0, 102));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 102));
        jLabel4.setText("Producent:");

        jtxtDirector.setEditable(false);
        jtxtDirector.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtxtDirector.setForeground(new java.awt.Color(0, 0, 102));

        jtxtYear.setEditable(false);
        jtxtYear.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtxtYear.setForeground(new java.awt.Color(0, 0, 102));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 102));
        jLabel6.setText("Godina:");

        jBtnAllMovies.setBackground(new java.awt.Color(0, 0, 102));
        jBtnAllMovies.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jBtnAllMovies.setForeground(new java.awt.Color(255, 255, 255));
        jBtnAllMovies.setText("...");
        jBtnAllMovies.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAllMoviesActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 102));
        jLabel2.setText("Datum:");

        jComboDate.setBackground(new java.awt.Color(204, 204, 255));
        jComboDate.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jComboDate.setForeground(new java.awt.Color(0, 0, 102));
        jComboDate.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboDateItemStateChanged(evt);
            }
        });
        jComboDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboDateActionPerformed(evt);
            }
        });

        jBttnSearch.setBackground(new java.awt.Color(0, 0, 102));
        jBttnSearch.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        jBttnSearch.setForeground(new java.awt.Color(255, 255, 255));
        jBttnSearch.setText("Pretraga");
        jBttnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBttnSearchActionPerformed(evt);
            }
        });

        jTxtMovie.setEditable(false);
        jTxtMovie.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTxtMovie.setForeground(new java.awt.Color(0, 0, 102));
        jTxtMovie.setEnabled(false);

        jLblPonistiParametrePretrage1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLblPonistiParametrePretrage1.setForeground(new java.awt.Color(0, 0, 102));
        jLblPonistiParametrePretrage1.setText("X Ponisti parametre pretraga");
        jLblPonistiParametrePretrage1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLblPonistiParametrePretrage1MouseClicked(evt);
            }
        });
        jLblPonistiParametrePretrage1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jLblPonistiParametrePretrage1KeyPressed(evt);
            }
        });

        buttonGroup1.add(jRadioButtonFuture);
        jRadioButtonFuture.setText("Buduce");
        jRadioButtonFuture.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonFutureActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButtonPast);
        jRadioButtonPast.setText("Prosle");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButtonPast)
                    .addComponent(jRadioButtonFuture))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jRadioButtonFuture)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButtonPast)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelMovieLayout = new javax.swing.GroupLayout(jPanelMovie);
        jPanelMovie.setLayout(jPanelMovieLayout);
        jPanelMovieLayout.setHorizontalGroup(
            jPanelMovieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMovieLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelMovieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelMovieLayout.createSequentialGroup()
                        .addGroup(jPanelMovieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelMovieLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanelMovieLayout.createSequentialGroup()
                                .addGroup(jPanelMovieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel3))
                                .addGap(45, 45, 45)
                                .addGroup(jPanelMovieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTxtMovie, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                                    .addGroup(jPanelMovieLayout.createSequentialGroup()
                                        .addComponent(jtxtYear, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(jtxtGenre, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtxtDirector, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanelMovieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanelMovieLayout.createSequentialGroup()
                                        .addComponent(jBtnAllMovies)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel2)
                                        .addGap(18, 18, 18)
                                        .addComponent(jComboDate, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelMovieLayout.createSequentialGroup()
                                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(15, 15, 15))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelMovieLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLblPonistiParametrePretrage1)
                                .addGap(142, 142, 142)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelMovieLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jBttnSearch)
                        .addGap(206, 206, 206))))
        );
        jPanelMovieLayout.setVerticalGroup(
            jPanelMovieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMovieLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelMovieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jBtnAllMovies)
                    .addComponent(jLabel2)
                    .addComponent(jComboDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtMovie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanelMovieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelMovieLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelMovieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtxtGenre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelMovieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jtxtDirector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(jPanelMovieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jtxtYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBttnSearch)
                        .addGap(18, 18, 18)
                        .addComponent(jLblPonistiParametrePretrage1)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelMovieLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(97, 97, 97))))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Sve projekcije za izabrani film", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12), new java.awt.Color(0, 0, 102))); // NOI18N

        jTableShowtime.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTableShowtime.setForeground(new java.awt.Color(0, 0, 102));
        jTableShowtime.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTableShowtime.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jTableShowtime);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 663, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jBtnDeleteShowtime.setBackground(new java.awt.Color(0, 0, 102));
        jBtnDeleteShowtime.setFont(new java.awt.Font("Yu Gothic", 0, 14)); // NOI18N
        jBtnDeleteShowtime.setForeground(new java.awt.Color(255, 255, 255));
        jBtnDeleteShowtime.setText("Obriši projekciju");
        jBtnDeleteShowtime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnDeleteShowtimeActionPerformed(evt);
            }
        });

        jBtnUpdateShowtime.setBackground(new java.awt.Color(0, 0, 102));
        jBtnUpdateShowtime.setFont(new java.awt.Font("Yu Gothic", 0, 14)); // NOI18N
        jBtnUpdateShowtime.setForeground(new java.awt.Color(255, 255, 255));
        jBtnUpdateShowtime.setText("Izmeni projekciju");
        jBtnUpdateShowtime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnUpdateShowtimeActionPerformed(evt);
            }
        });

        jBtnAddToMovieMarathon.setBackground(new java.awt.Color(0, 0, 102));
        jBtnAddToMovieMarathon.setFont(new java.awt.Font("Yu Gothic", 0, 14)); // NOI18N
        jBtnAddToMovieMarathon.setForeground(new java.awt.Color(255, 255, 255));
        jBtnAddToMovieMarathon.setText("Dodaj u filmski maraton");
        jBtnAddToMovieMarathon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAddToMovieMarathonActionPerformed(evt);
            }
        });

        jBtnSelectShowtime.setBackground(new java.awt.Color(0, 0, 102));
        jBtnSelectShowtime.setFont(new java.awt.Font("Yu Gothic", 0, 14)); // NOI18N
        jBtnSelectShowtime.setForeground(new java.awt.Color(255, 255, 255));
        jBtnSelectShowtime.setText("Izaberi");
        jBtnSelectShowtime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSelectShowtimeActionPerformed(evt);
            }
        });

        jBtnDetails.setBackground(new java.awt.Color(0, 0, 102));
        jBtnDetails.setFont(new java.awt.Font("Yu Gothic", 0, 14)); // NOI18N
        jBtnDetails.setForeground(new java.awt.Color(255, 255, 255));
        jBtnDetails.setText("Detalji");
        jBtnDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnDetailsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jBtnDeleteShowtime)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtnUpdateShowtime)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtnAddToMovieMarathon, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtnSelectShowtime)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtnDetails))
                    .addComponent(jPanelMovie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelMovie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnDeleteShowtime)
                    .addComponent(jBtnUpdateShowtime)
                    .addComponent(jBtnSelectShowtime)
                    .addComponent(jBtnAddToMovieMarathon)
                    .addComponent(jBtnDetails))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    private void jComboDateItemStateChanged(java.awt.event.ItemEvent evt) {                                            

    }                                           

    private void jBtnDeleteShowtimeActionPerformed(java.awt.event.ActionEvent evt) {                                                   
        int selectedRow = jTableShowtime.getSelectedRow();
        if (selectedRow != -1) {
            ShowtimeTableModel stm = (ShowtimeTableModel) jTableShowtime.getModel();
            try {
                controller.Controller.getInstance().removeShowtime(stm.getShowtime(selectedRow), this);
            } catch (Exception ex) {
                Logger.getLogger(FShowtimeSearch.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Izaberite projekciju koju zelite da obrisete.");
        }
    }                                                  

    private void jBtnUpdateShowtimeActionPerformed(java.awt.event.ActionEvent evt) {                                                   
        int selectedRow = jTableShowtime.getSelectedRow();

        if (selectedRow != -1) {
            ShowtimeTableModel stm = (ShowtimeTableModel) jTableShowtime.getModel();
            Showtime showtime = stm.getShowtime(jTableShowtime.getSelectedRow());
            FShowtime fShowtime = new FShowtime(null, true, FormMode.FORM_UPDATE, showtime.getShowtimeId());
            fShowtime.setVisible(true);
            loadAllShowtimes();
        } else {
            JOptionPane.showMessageDialog(this, "Izaberite projekciju koju zelite da izmenite.");
        }

    }                                                  
    Movie movie;
    private void jBtnAllMoviesActionPerformed(java.awt.event.ActionEvent evt) {                                              
        FMovieSearch fMovieSearch = new FMovieSearch(null, true, FormMode.FORM_SELECT);
        fMovieSearch.setVisible(true);
        movie = fMovieSearch.getMovie();
        if (movie == null) {
            return;
        }
        jTxtMovie.setText(fMovieSearch.getMovie().getName());
        fillShowtimeInfo();

    }                                             
    private void fillShowtimeInfo() {

        jtxtGenre.setText(movie.getGenre().toString());
        jtxtDirector.setText(movie.getDirector());
        jtxtYear.setText(movie.getYear() + "");
    }
    private void jBtnAddToMovieMarathonActionPerformed(java.awt.event.ActionEvent evt) {                                                       
        FMovieMarathon mm = (FMovieMarathon) getParent();
        List<Showtime> showtimes = mm.getAddedShowtimes();
        int row = jTableShowtime.getSelectedRow();
        try {
            ShowtimeTableModel stm = (ShowtimeTableModel) jTableShowtime.getModel();
            if (row == -1) {
                JOptionPane.showMessageDialog(this, "Morate izabrati projekciju.");
            } else if (checkMovies(showtimes, stm.getShowtime(row))) {
                mm.addShowtimeToMarathon(stm.getShowtime(row));
                JOptionPane.showMessageDialog(this, "Projekcija je dodata.");
                stm.removeShowtime(row);
            } else {
                JOptionPane.showMessageDialog(this, "Projekcija za dati film je vec dodata.");
            }

        } catch (Exception e) {

        }

    }                                                      
    private boolean checkMovies(List<Showtime> showtimes, Showtime sh) {
        for (Showtime s : showtimes) {
            if (s == sh) {
                return false;
            }
            if (s.getMovie().equals(sh.getMovie())) {
                return false;
            }
        }
        return true;
    }
    private void jComboDateActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
    }                                          

    private void jBtnSelectShowtimeActionPerformed(java.awt.event.ActionEvent evt) {                                                   
        int selectedRow = jTableShowtime.getSelectedRow();

        if (selectedRow != -1) {
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Odaberite projekciju!");
        }    }                                                  

    private void jBttnSearchActionPerformed(java.awt.event.ActionEvent evt) {                                            
        ArrayList<String> columns = new ArrayList<>();
        ArrayList<String> values = new ArrayList<>();
        if (buttonGroup1.isSelected(jRadioButtonFuture.getModel())) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            values.add(sdf.format(new Date()));
            columns.add("Date>");
            jBtnDeleteShowtime.setEnabled(true);
            jBtnUpdateShowtime.setEnabled(true);
        } else if (buttonGroup1.isSelected(jRadioButtonPast.getModel())) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            values.add(sdf.format(new Date()));
            columns.add("Date<");
            jBtnDeleteShowtime.setEnabled(false);
            jBtnUpdateShowtime.setEnabled(false);
        }
        try {
            if (movie != null) {
                int id = movie.getMovieId();
                columns.add("m.movieId");
                values.add(id + "");

            }
            if (jComboDate.getSelectedIndex() != -1) {
                columns.add("date");
                values.add((String) jComboDate.getSelectedItem());
            }
            if (columns.size() != 0) {
                Controller.getInstance().getShowtimesWithCriteria(columns, values, this);
            } else {
                JOptionPane.showMessageDialog(this, "Morate uneti parametar pretrage.");
            }
        } catch (Exception ex) {
            Logger.getLogger(FShowtimeSearch.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }                                           

    private void jLblPonistiParametrePretrage1MouseClicked(java.awt.event.MouseEvent evt) {                                                           
        buttonGroup1.clearSelection();
        jComboDate.setSelectedIndex(-1);
        jTxtMovie.setText("");
        jtxtDirector.setText("");
        jtxtGenre.setText("");
        jtxtYear.setText("");
        jComboDate.setSelectedIndex(-1);
        loadAllShowtimes();
    }                                                          

    private void jLblPonistiParametrePretrage1KeyPressed(java.awt.event.KeyEvent evt) {                                                         

    }                                                        

    private void jBtnDetailsActionPerformed(java.awt.event.ActionEvent evt) {                                            
        int selectedRow = jTableShowtime.getSelectedRow();

        if (selectedRow != -1) {
            ShowtimeTableModel stm = (ShowtimeTableModel) jTableShowtime.getModel();
            Showtime showtime = stm.getShowtime(jTableShowtime.getSelectedRow());
            FShowtime fShowtime = new FShowtime(null, true, FormMode.FORM_VIEW, showtime.getShowtimeId());
            fShowtime.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Izaberite projekciju koju zelite da pogledate.");
        }

    }                                           

    private void jRadioButtonFutureActionPerformed(java.awt.event.ActionEvent evt) {                                                   
        // TODO add your handling code here:
    }                                                  

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify                     
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jBtnAddToMovieMarathon;
    private javax.swing.JButton jBtnAllMovies;
    private javax.swing.JButton jBtnDeleteShowtime;
    private javax.swing.JButton jBtnDetails;
    private javax.swing.JButton jBtnSelectShowtime;
    private javax.swing.JButton jBtnUpdateShowtime;
    private javax.swing.JButton jBttnSearch;
    private javax.swing.JComboBox<String> jComboDate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLblPonistiParametrePretrage1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanelMovie;
    private javax.swing.JRadioButton jRadioButtonFuture;
    private javax.swing.JRadioButton jRadioButtonPast;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableShowtime;
    private javax.swing.JTextField jTxtMovie;
    private javax.swing.JTextField jtxtDirector;
    private javax.swing.JTextField jtxtGenre;
    private javax.swing.JTextField jtxtYear;
    // End of variables declaration                   

    private void fillForm(FormMode formMode) throws Exception {
        fillComboDate();
        loadAllShowtimes();
        switch (formMode) {
            case FORM_SELECT: {
                jBtnAddToMovieMarathon.setVisible(false);
                jBtnDeleteShowtime.setVisible(false);
                jBtnUpdateShowtime.setVisible(false);
            }
            break;
            case FORM_SELECT_MULTIPLE: {
                jBtnDeleteShowtime.setVisible(false);
                jBtnUpdateShowtime.setVisible(false);
                jBtnSelectShowtime.setVisible(false);
            }
            break;
            case FORM_VIEW: {
                jBtnAddToMovieMarathon.setVisible(false);
                jBtnSelectShowtime.setVisible(false);
            }
            break;
        }
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
        jComboDate.setSelectedIndex(-1);
    }

    Showtime getShowtime() {
        ShowtimeTableModel stm = (ShowtimeTableModel) jTableShowtime.getModel();
        return stm.getShowtime(jTableShowtime.getSelectedRow());
    }

    public void showtimeIsDeleted() {
        JOptionPane.showMessageDialog(this, "Sistem je obrisao projekciju.");
        dispose();
    }

    public void showtimeIsNotDeleted() {
        JOptionPane.showMessageDialog(this, "Sistem ne može da obriše projekciju.");
    }

    public void setShowtimes(List<Showtime> showtimes) {
        if (showtimes.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Sistem ne može da nađe projekciju po zadatoj vrednosti.");
            jTableShowtime.removeAll();
            return;
        }
        fillAllShowtimesTable(showtimes);
    }

    public void showtimesLoadingFailed() {
        JOptionPane.showMessageDialog(this, "Ucitavanje projekcija nije uspelo.");
    }

    private void fillAllShowtimesTable(List<Showtime> showtimes) {
        JOptionPane.showMessageDialog(this, "Pretraga je završena.");

        ShowtimeTableModel showtimeTableModel = new ShowtimeTableModel(showtimes);
        jTableShowtime.setModel(showtimeTableModel);
        jTableShowtime.getColumnModel().getColumn(0).setPreferredWidth(10);
        jTableShowtime.getColumnModel().getColumn(1).setPreferredWidth(10);
        jTableShowtime.getColumnModel().getColumn(2).setPreferredWidth(10);
    }

    private void loadAllShowtimes() {
        try {
            ArrayList<String> columns = new ArrayList<>();
            ArrayList<String> values = new ArrayList<>();
            columns.add("date>");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date());
            values.add(sdf.format(calendar.getTime()));
            Controller.getInstance().getShowtimesWithCriteria(columns, values, this);
        } catch (Exception ex) {
            Logger.getLogger(FReservationSearch.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void prepareTable() {
        JTableHeader header = jTableShowtime.getTableHeader();
        header.setFont(new Font("Tahoma", Font.PLAIN, 16));
        header.setForeground(Color.decode("#12207B"));
        header.setBackground(Color.decode("#C0E2F0"));
    }

}
