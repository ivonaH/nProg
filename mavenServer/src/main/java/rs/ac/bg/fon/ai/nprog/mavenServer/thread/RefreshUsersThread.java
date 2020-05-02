/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ai.nprog.mavenServer.thread;

import rs.ac.bg.fon.ai.nprog.mavenCommonLib.domain.User;
import rs.ac.bg.fon.ai.nprog.mavenServer.controller.Controller;
import rs.ac.bg.fon.ai.nprog.mavenServer.form.model.UserTableModel;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;

/**
 *
 * @author Ivona
 */
public class RefreshUsersThread extends Thread {

    JTable jTblOnlineUsers;
    SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

    public RefreshUsersThread(JTable usersTable) {
        this.jTblOnlineUsers = usersTable;
        System.out.println("POKRENUT");
    }

    @Override
    public void run() {
        while (!isInterrupted()) {
            List<User> users = Controller.getInstance().getOnlineUsers();
            fillTable(users);
            try {
                sleep(300);
            } catch (InterruptedException ex) {
                Logger.getLogger(RefreshUsersThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void fillTable(List<User> users) {
        UserTableModel model = (UserTableModel) jTblOnlineUsers.getModel();
        model.setUsers(users);
        
    }

}
