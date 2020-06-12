/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ai.nprog.mavenClient.ui.component.table.model;

import rs.ac.bg.fon.ai.nprog.mavenCommonLib.domain.Showtime;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Ivona
 */
public class ShowtimeTableModel extends AbstractTableModel {

    List<Showtime> showtimes;
    String[] columnNames = {"Film", "Datum", "Vreme", "Naziv sale"};

    public ShowtimeTableModel(List<Showtime> s) {
        showtimes = s;
    }

    public ShowtimeTableModel() {
        showtimes = new ArrayList<>();
    }

    @Override
    public int getRowCount() {
        return showtimes.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int row, int column) {
        Showtime showtime = showtimes.get(row);
        switch (column) {
            case 0: {
                return showtime.getMovie().getName();
            }
            case 1: {
                return showtime.getDate();
            }
            case 2:
                return showtime.getTime();
            case 3:
                return showtime.getHall().getName();
            default:
                return "n/a";
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    public Showtime getShowtime(int row) {
        return showtimes.get(row);
    }

    public void addShowtime(Showtime showtime) {
        showtimes.add(showtime);
        fireTableDataChanged();
    }

    public void removeShowtime(int row) {
        showtimes.remove(row);
        fireTableDataChanged();
    }

    public List<Showtime> getAllShowtimes() {
        return showtimes;
    }
}
