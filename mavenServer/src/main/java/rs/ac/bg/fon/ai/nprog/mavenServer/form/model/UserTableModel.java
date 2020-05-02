/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ai.nprog.mavenServer.form.model;

import rs.ac.bg.fon.ai.nprog.mavenCommonLib.domain.User;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Ivona
 */
public class UserTableModel extends AbstractTableModel {

    String[] columns = {"Korisnicko ime", "Ime", "Prezime"};
    List<User> users;

    public UserTableModel(List<User> users) {
        this.users = users;
    }

    @Override
    public int getRowCount() {
        return users.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int row, int column) {
        User user = users.get(row);
        switch (column) {
            case 0:
                return user.getUsername();
            case 1:
                return user.getName();
            case 2:
                return user.getLastname();

            default:
                return "n/a";
        }
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }

    @Override
    public boolean isCellEditable(int i, int i1) {
        return false;
    }

    public void setUsers(List<User> users) {
        this.users = users;
        fireTableDataChanged();
    }
    
    

}
