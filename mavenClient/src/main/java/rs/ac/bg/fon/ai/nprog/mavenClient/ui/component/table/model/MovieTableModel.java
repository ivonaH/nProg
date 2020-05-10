/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ai.nprog.mavenClient.ui.component.table.model;

import rs.ac.bg.fon.ai.nprog.mavenCommonLib.domain.Movie;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Ivona
 */
public class MovieTableModel extends AbstractTableModel{
    String[] columns={"Id","Ime","Žanr","Producent","Godina"};
    List<Movie> movies;

    public MovieTableModel(List<Movie> movies) {
        this.movies = movies;
    }
    
    @Override
    public int getRowCount() {
        return movies.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int row, int column) {
        Movie movie=movies.get(row);
        switch(column){
            case 0: return movie.getMovieId();
            case 1: return movie.getName();
            case 2: return movie.getGenre();
            case 3: return movie.getDirector();
            case 4: return movie.getYear();
            default: return "n/a";
        }
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
    
    public Movie getMovie(int row){
        return movies.get(row);
    }
    
    
}
