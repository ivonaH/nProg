/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ai.nprog.mavenClient.ui.component.table.model;

import rs.ac.bg.fon.ai.nprog.mavenCommonLib.domain.Reservation;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Ivona
 */
public class ReservationTableModel extends AbstractTableModel{
String[] columns={"Id","Ime i prezime","Email","Film","Vreme i datum","Sala"};
List<Reservation> reservations;

    public ReservationTableModel(List<Reservation> r) {
        reservations=r;
    }

    @Override
    public int getRowCount() {
       return reservations.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int row, int column) {
        Reservation reservation=reservations.get(row);
        switch(column){
            case 0: return reservation.getReservationId();
            case 1: return reservation.getNameLastname();
            case 2: return reservation.getEmail();
            case 3: return reservation.getShowtime().getMovie();
            case 4: return reservation.getShowtime().getDate()+" "+reservation.getShowtime().getTime();
            case 5: return reservation.getShowtime().getHall().getName();
            default: return "n/a";
        }
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }
    
   public Reservation getReservation(int row){
       return reservations.get(row);
   }
    
}
