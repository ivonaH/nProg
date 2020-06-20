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
import java.awt.Font;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.JTableHeader;
import rs.ac.bg.fon.ai.nprog.mavenClient.ui.component.table.model.MovieTableModel;

/**
 *
 * @author Ivona
 */
public class FMovieSearch extends javax.swing.JDialog {

	Movie movie = null;

	/**
	 * Creates new form FMovieSearch
	 */
	public FMovieSearch(java.awt.Frame parent, boolean modal, FormMode formMode) {
		super(parent, modal);
		initComponents();
		setLocationRelativeTo(null);
		prepareTable();
		try {
			fillForm(formMode);
		} catch (Exception ex) {
			Logger.getLogger(FMovieSearch.class.getName()).log(Level.SEVERE, null, ex);
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

		SortByButtonGroup = new javax.swing.ButtonGroup();
		jPanelMovieSearch = new javax.swing.JPanel();
		jtxtMovieName = new javax.swing.JTextField();
		jLabel2 = new javax.swing.JLabel();
		jBtnSearch = new javax.swing.JButton();
		jLabel3 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		jComboGenre = new javax.swing.JComboBox<>();
		jtxtYear = new javax.swing.JTextField();
		jLblPonistiParametrePretrage = new javax.swing.JLabel();
		jPanelAllMovies = new javax.swing.JPanel();
		jScrollPaneAllMovies = new javax.swing.JScrollPane();
		jTableAllMovies = new javax.swing.JTable();
		jBtnSelectMovie = new javax.swing.JButton();
		jBtnDetails = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		setTitle("Pretraga filmova");

		jPanelMovieSearch.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pretraga filma",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION,
				new java.awt.Font("Tahoma", 0, 14), new java.awt.Color(0, 0, 102))); // NOI18N

		jtxtMovieName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		jtxtMovieName.setForeground(new java.awt.Color(0, 0, 102));
		jtxtMovieName.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jtxtMovieNameActionPerformed(evt);
			}
		});

		jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		jLabel2.setForeground(new java.awt.Color(0, 0, 102));
		jLabel2.setText("Naziv:");

		jBtnSearch.setBackground(new java.awt.Color(0, 0, 102));
		jBtnSearch.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		jBtnSearch.setForeground(new java.awt.Color(255, 255, 255));
		jBtnSearch.setText("Pronađi");
		jBtnSearch.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jBtnSearchActionPerformed(evt);
			}
		});

		jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		jLabel3.setForeground(new java.awt.Color(0, 0, 102));
		jLabel3.setText("Žanr:");

		jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		jLabel4.setForeground(new java.awt.Color(0, 0, 102));
		jLabel4.setText("Godina:");

		jComboGenre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		jComboGenre.setForeground(new java.awt.Color(0, 0, 102));
		jComboGenre.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jComboGenreActionPerformed(evt);
			}
		});

		jtxtYear.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		jtxtYear.setForeground(new java.awt.Color(0, 0, 102));

		jLblPonistiParametrePretrage.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		jLblPonistiParametrePretrage.setForeground(new java.awt.Color(153, 0, 0));
		jLblPonistiParametrePretrage.setText("X Ponisti parametre pretraga");
		jLblPonistiParametrePretrage.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jLblPonistiParametrePretrageMouseClicked(evt);
			}
		});
		jLblPonistiParametrePretrage.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyPressed(java.awt.event.KeyEvent evt) {
				jLblPonistiParametrePretrageKeyPressed(evt);
			}
		});

		javax.swing.GroupLayout jPanelMovieSearchLayout = new javax.swing.GroupLayout(jPanelMovieSearch);
		jPanelMovieSearch.setLayout(jPanelMovieSearchLayout);
		jPanelMovieSearchLayout.setHorizontalGroup(jPanelMovieSearchLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanelMovieSearchLayout.createSequentialGroup().addContainerGap()
						.addGroup(jPanelMovieSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jLabel2)
								.addGroup(jPanelMovieSearchLayout.createSequentialGroup().addGap(82, 82, 82)
										.addComponent(jtxtMovieName, javax.swing.GroupLayout.PREFERRED_SIZE, 123,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGroup(jPanelMovieSearchLayout.createSequentialGroup()
										.addGroup(jPanelMovieSearchLayout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(jLabel3).addComponent(jLabel4))
										.addGap(35, 35, 35)
										.addGroup(jPanelMovieSearchLayout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(jComboGenre, javax.swing.GroupLayout.PREFERRED_SIZE, 93,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGroup(jPanelMovieSearchLayout.createSequentialGroup()
														.addComponent(jtxtYear, javax.swing.GroupLayout.PREFERRED_SIZE,
																94, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.RELATED, 165,
																Short.MAX_VALUE)
														.addComponent(jBtnSearch)))))
						.addGap(53, 53, 53))
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
						jPanelMovieSearchLayout.createSequentialGroup()
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jLblPonistiParametrePretrage).addGap(119, 119, 119)));
		jPanelMovieSearchLayout.setVerticalGroup(jPanelMovieSearchLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanelMovieSearchLayout.createSequentialGroup()
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(jPanelMovieSearchLayout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel2)
								.addComponent(jtxtMovieName, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(jPanelMovieSearchLayout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel3)
								.addComponent(jComboGenre, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGroup(jPanelMovieSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(jPanelMovieSearchLayout.createSequentialGroup().addGap(20, 20, 20)
										.addGroup(jPanelMovieSearchLayout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jLabel4).addComponent(jtxtYear,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(jLblPonistiParametrePretrage))
								.addGroup(jPanelMovieSearchLayout.createSequentialGroup()
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(jBtnSearch)))
						.addGap(58, 58, 58)));

		jPanelAllMovies.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Svi filmovi",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION,
				new java.awt.Font("Tahoma", 0, 12), new java.awt.Color(0, 0, 102))); // NOI18N

		jTableAllMovies.setBackground(new java.awt.Color(204, 204, 255));
		jTableAllMovies.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
		jTableAllMovies.setForeground(new java.awt.Color(0, 0, 102));
		jTableAllMovies.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {

		}, new String[] {

		}));
		jTableAllMovies.getTableHeader().setReorderingAllowed(false);
		jScrollPaneAllMovies.setViewportView(jTableAllMovies);

		javax.swing.GroupLayout jPanelAllMoviesLayout = new javax.swing.GroupLayout(jPanelAllMovies);
		jPanelAllMovies.setLayout(jPanelAllMoviesLayout);
		jPanelAllMoviesLayout.setHorizontalGroup(
				jPanelAllMoviesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
						jScrollPaneAllMovies, javax.swing.GroupLayout.DEFAULT_SIZE, 491, Short.MAX_VALUE));
		jPanelAllMoviesLayout
				.setVerticalGroup(jPanelAllMoviesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
								jPanelAllMoviesLayout.createSequentialGroup().addContainerGap().addComponent(
										jScrollPaneAllMovies, javax.swing.GroupLayout.DEFAULT_SIZE, 164,
										Short.MAX_VALUE)));

		jBtnSelectMovie.setBackground(new java.awt.Color(0, 0, 102));
		jBtnSelectMovie.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		jBtnSelectMovie.setForeground(new java.awt.Color(255, 255, 255));
		jBtnSelectMovie.setText("Izaberi film");
		jBtnSelectMovie.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jBtnSelectMovieActionPerformed(evt);
			}
		});

		jBtnDetails.setBackground(new java.awt.Color(0, 0, 102));
		jBtnDetails.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		jBtnDetails.setForeground(new java.awt.Color(255, 255, 255));
		jBtnDetails.setText("Detalji");
		jBtnDetails.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jBtnDetailsActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup()
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
								layout.createSequentialGroup().addGap(93, 93, 93).addComponent(jBtnDetails)
										.addGap(62, 62, 62).addComponent(jBtnSelectMovie).addGap(200, 200, 200))
						.addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jPanelAllMovies, javax.swing.GroupLayout.Alignment.TRAILING,
										javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jPanelMovieSearch, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
				.addContainerGap(29, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap()
						.addComponent(jPanelMovieSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 181, Short.MAX_VALUE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jBtnDetails).addComponent(jBtnSelectMovie))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(jPanelAllMovies, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));

		pack();
	}// </editor-fold>

	private void jBtnSearchActionPerformed(java.awt.event.ActionEvent evt) {
		ArrayList<String> columns = new ArrayList<>();
		ArrayList<String> values = new ArrayList<>();
		if (!jtxtMovieName.getText().equals("")) {
			columns.add("Name");
			values.add(jtxtMovieName.getText());
		}
		if (jComboGenre.getSelectedIndex() != -1) {
			columns.add("Genre");
			values.add(jComboGenre.getSelectedItem().toString());
		} else {
		}
		if (!jtxtYear.getText().equals("")) {
			columns.add("Year");
			values.add(jtxtYear.getText());
		}
		if (columns.size() == 0) {
			JOptionPane.showMessageDialog(this, "Unesite bar jedan parametar pretrage.");
			return;
		}

		try {
			Controller.getInstance().getMoviesWithCriteria(columns, values, this);
		} catch (Exception ex) {
			Logger.getLogger(FMovieSearch.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

	private void jtxtMovieNameActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void jBtnSelectMovieActionPerformed(java.awt.event.ActionEvent evt) {
		if (jTableAllMovies.getSelectedRow() != -1) {
			MovieTableModel mtm = (MovieTableModel) jTableAllMovies.getModel();
			movie = mtm.getMovie(jTableAllMovies.getSelectedRow());
			dispose();
		} else {
			JOptionPane.showMessageDialog(this, "You must select movie.");
		}
	}

	private void jComboGenreActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void jLblPonistiParametrePretrageMouseClicked(java.awt.event.MouseEvent evt) {

		try {
			jtxtMovieName.setText("");
			jtxtYear.setText("");
			jComboGenre.setSelectedIndex(-1);
			Controller.getInstance().getAllMovies(this);

		} catch (Exception ex) {
			Logger.getLogger(FMovieSearch.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	private void jLblPonistiParametrePretrageKeyPressed(java.awt.event.KeyEvent evt) {

	}

	private void jBtnDetailsActionPerformed(java.awt.event.ActionEvent evt) {
		if (jTableAllMovies.getSelectedRow() != -1) {
			MovieTableModel mtm = (MovieTableModel) jTableAllMovies.getModel();
			movie = mtm.getMovie(jTableAllMovies.getSelectedRow());
			FMovie fMovie = new FMovie(null, true, FormMode.FORM_VIEW, movie.getMovieId());
			fMovie.setVisible(true);
		} else {
			JOptionPane.showMessageDialog(this, "You must select movie.");
		}
	}

	/**
	 * @param args the command line arguments
	 */

	// Variables declaration - do not modify
	private javax.swing.ButtonGroup SortByButtonGroup;
	private javax.swing.JButton jBtnDetails;
	private javax.swing.JButton jBtnSearch;
	private javax.swing.JButton jBtnSelectMovie;
	private javax.swing.JComboBox<Genre> jComboGenre;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLblPonistiParametrePretrage;
	private javax.swing.JPanel jPanelAllMovies;
	private javax.swing.JPanel jPanelMovieSearch;
	private javax.swing.JScrollPane jScrollPaneAllMovies;
	private javax.swing.JTable jTableAllMovies;
	private javax.swing.JTextField jtxtMovieName;
	private javax.swing.JTextField jtxtYear;
	// End of variables declaration

	private void fillForm(FormMode formMode) throws Exception {
		if (!formMode.equals(FormMode.FORM_SELECT)) {
			jBtnSelectMovie.setVisible(false);
		}
		fillComboGenre();
		Controller.getInstance().getAllMovies(this);
	}

	public void setMovies(List<Movie> movies) {
		if (movies.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Sistem ne može da nađe filmove po zadatoj vrednosti.");
			return;
		}
		fillAllMoviesTable(movies);

	}

	private void fillComboGenre() {
		jComboGenre.removeAllItems();
		for (Genre genre : Genre.values()) {
			jComboGenre.addItem(genre);
		}
		jComboGenre.setSelectedIndex(-1);

	}

	private void fillAllMoviesTable(List<Movie> movies) {
		JOptionPane.showMessageDialog(this, "Pretraga je završena.");

		MovieTableModel mtm = new MovieTableModel(movies);
		jTableAllMovies.setModel(mtm);
//        jTableAllMovies.getColumnModel().getColumn(0).setPreferredWidth(10);
		jTableAllMovies.getColumnModel().getColumn(1).setPreferredWidth(20);
		jTableAllMovies.getColumnModel().getColumn(3).setPreferredWidth(10);
	}

	public Movie getMovie() {
		return movie;
	}

	public void moviesLoadingFailed() {
		JOptionPane.showMessageDialog(this, "Ucitavanje filmova nije uspelo.");
	}

	private void prepareTable() {
		JTableHeader header = jTableAllMovies.getTableHeader();
		header.setFont(new Font("Tahoma", Font.PLAIN, 16));
		header.setForeground(Color.decode("#12207B"));
		header.setBackground(Color.decode("#C0E2F0"));
	}

}
