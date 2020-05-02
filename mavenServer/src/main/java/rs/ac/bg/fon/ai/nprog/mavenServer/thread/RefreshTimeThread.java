/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ai.nprog.mavenServer.thread;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 * @author Ivona
 */
public class RefreshTimeThread extends Thread {

    JLabel label;
    SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

    public RefreshTimeThread(JLabel label) {
        this.label = label;
    }

    
    @Override
    public void run() {
        while (!isInterrupted()) {
            label.setText(sdf.format(new Date()));
            try {
                sleep(200);
            } catch (InterruptedException ex) {
                Logger.getLogger(RefreshTimeThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
