/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ai.nprog.mavenClient.ui.component.table.model;

import rs.ac.bg.fon.ai.nprog.mavenCommonLib.domain.MovieMarathon;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Ivona
 */
public class MovieMarathonTableModel extends AbstractTableModel {

    String columns[] = {"Id", "Ime"};
    List<MovieMarathon> movieMarathons;

    public MovieMarathonTableModel(List<MovieMarathon> movieMarathons) {
        this.movieMarathons = movieMarathons;
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }

    @Override
    public int getRowCount() {
        return movieMarathons.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int row, int column) {
        MovieMarathon marathon = movieMarathons.get(row);
        switch (column) {
            case 0:
                return marathon.getMarathonId();
            case 1:
                return marathon.getName();
            default:
                return "N/A";
        }
    }

    public MovieMarathon getSelectedMarathon(int row) {
        return movieMarathons.get(row);
    }
}
