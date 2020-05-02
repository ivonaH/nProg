package rs.ac.bg.fon.ai.nprog.mavenServer.controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.sun.javafx.scene.control.skin.VirtualFlow;
import rs.ac.bg.fon.ai.nprog.mavenServer.thread.ClientThread;
import rs.ac.bg.fon.ai.nprog.mavenServer.database.*;
import rs.ac.bg.fon.ai.nprog.mavenServer.form.config.database.FDatabaseConfig;
import rs.ac.bg.fon.ai.nprog.mavenServer.form.config.server.FServerConfig;
import rs.ac.bg.fon.ai.nprog.mavenServer.form.config.database.FDatabaseConfig;
import rs.ac.bg.fon.ai.nprog.mavenServer.thread.*;
import rs.ac.bg.fon.ai.nprog.mavenServer.configuration.*;

import rs.ac.bg.fon.ai.nprog.mavenCommonLib.domain.*;
import rs.ac.bg.fon.ai.nprog.mavenCommonLib.util.*;
import rs.ac.bg.fon.ai.nprog.mavenCommonLib.transfer.*;

import rs.ac.bg.fon.ai.nprog.mavenServer.so.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/**
 *
 * @author Ivona
 */
public class Controller {

//    private static User currentUser;
    private final List<ClientThread> clientThreads;
    private static Controller instance;

    private DBBroker dbb;

    private Controller() {
        dbb = new DBBroker();
        clientThreads = new LinkedList<>();
    }

    public static Controller getInstance() {
        if (instance == null) {
            instance = new Controller();
        }

        return instance;
    }

    public void removeClient(ClientThread client) {
        try {
            client.interrupt();
            client.getSocket().close();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Greska prilikom zatvaranja soketa");
        }
        clientThreads.remove(client);

    }

    public List<ClientThread> getClientThreads() {
        return clientThreads;
    }

    public List<User> getOnlineUsers() {
    List<User> onlineUsers = new ArrayList<>();
    for(ClientThread client:clientThreads){
        onlineUsers.add(client.getLoginUser());
    }
    return onlineUsers ;
}

public void addClient(ClientThread client) {
        clientThreads.add(client);
    }

    public void logout(ClientThread clientThread) {
        removeClient(clientThread);
    }

    public void logoutClients() {
        for (ClientThread clientThread : clientThreads) {
            try {
                clientThread.sendResponse(new ResponseObject(ResponseStatus.ERROR, null, "Server nije dostupan. Dovidjenja.", Operation.OPERATION_LOGOUT));
            

} catch (IOException ex) {
                Logger.getLogger(Controller.class
.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public User login(User user) throws Exception {
        AbstractSystemOperation so = new NadjiRadnika();
        ArrayList<String> columns = new ArrayList<>();
       
                columns.add("username");
                columns.add("password");
        
        ArrayList<String> values = new ArrayList<>();
                values.add(user.getUsername());
                values.add(user.getPassword());
         
        so.executeOperation(user, columns, values);
        return ((NadjiRadnika) so).getUser();

    }

    public List<Hall> getAllHalls() throws Exception {
        AbstractSystemOperation so = new VratiListuSala();
        so.executeOperation(null, null, null);
        return ((VratiListuSala) so).getHalls();

    }

    public List<Movie> getAllMovies() throws Exception {
        AbstractSystemOperation so = new VratiListuFilmova();
        so.executeOperation(null, null, null);
        return ((VratiListuFilmova) so).getMovies();

    }

    public List<Reservation> getAllReservations() throws Exception {
        AbstractSystemOperation so = new VratiListuRezervacija();
        so.executeOperation(null, null, null);
        return ((VratiListuRezervacija) so).getReservations();

    }

    public List<MovieMarathon> getAllMovieMarathons() throws Exception {
        AbstractSystemOperation so = new VratiListuFilmskihMaratona();
        so.executeOperation(null, null, null);
        return ((VratiListuFilmskihMaratona) so).getMovieMarathons();

    }

    public List<Movie> getMoviesWithCriteria(List<String> columns, List<String> values) throws Exception {
        AbstractSystemOperation so = new VratiListuFilmovaPoKriterijumu();
        so.executeOperation(null, columns, values);
        return ((VratiListuFilmovaPoKriterijumu) so).getMovies();

    }

    public List<Showtime> getShowtimesWithCriteria(List<String> columns, List<String> values) throws Exception {
        AbstractSystemOperation so = new VratiListuProjekcijaPoKriterijumu();
        so.executeOperation(null, columns, values);
        return ((VratiListuProjekcijaPoKriterijumu) so).getShowtimes();
    }

    public List<Reservation> getReservationsWithCriteria(List<String> columns, List<String> values) throws Exception {
        AbstractSystemOperation so = new VratiListuRezervacijaPoKriterijumu();
        so.executeOperation(null, columns, values);
        return ((VratiListuRezervacijaPoKriterijumu) so).getReservations();
    }

    public List<MovieMarathon> getMovieMarathonWithCriteria(List<String> columns, List<String> values) throws Exception {
        AbstractSystemOperation so = new VratiListuMaratonaPoKriterijumu();
        so.executeOperation(null, columns, values);
        return ((VratiListuMaratonaPoKriterijumu) so).getMarathons();
    }

    public void saveMovie(Object movie) throws Exception {
        AbstractSystemOperation so = new KreirajFilm();
        so.executeOperation(movie, null, null);
    }

    public void saveMovieMarathon(Object object) throws Exception {
        AbstractSystemOperation so = new KreirajFilmskiMaraton();
        System.out.println("U KONTROLERU JE SALJE DA SE IZVRSI");
        so.executeOperation(object, null, null);
    }

    public void saveReservation(Object reservation) throws Exception {
        AbstractSystemOperation so = new KreirajRezervaciju();
        so.executeOperation(reservation, null, null);
    }

    public void saveShowtime(Object showtime) throws Exception {
        AbstractSystemOperation so = new KreirajProjekciju();
        so.executeOperation(showtime, null, null);
    }

    public void updateShowtime(Object showtime) throws Exception {
        AbstractSystemOperation so = new IzmeniProjekciju();
        so.executeOperation(showtime, null, null);
    }

    public void removeShowtime(Object showtime) throws Exception {
        AbstractSystemOperation so = new ObrisiProjekciju();
        so.executeOperation(showtime, null, null);
    }

    public void removeReservation(Object reservation) throws Exception {
        AbstractSystemOperation so = new ObrisiRezervaciju();
        so.executeOperation(reservation, null, null);
    }
//
//    public User getCurrentUser() {
//        return currentUser;
//    }

//    public void addOnlineUser(User user) {
//        onlineUsers.add(user);
//    }
//
//    public void removeUser(User loginUser) {
//        onlineUsers.remove(loginUser);
//    }

    public void changePortNumber(int port, FServerConfig fsc) {
        try {
            Configuration.getInstance().setPort(port);
        } catch (Exception ex) {
            fsc.notChanged();
        }
    }

    public void changeDatabaseConfig(String url, String username, String password, FDatabaseConfig fdc) {
        try {
            Configuration.getInstance().setDbConfig(username, password, url);
        } catch (Exception ex) {
            fdc.notChanged();
        }
    }

}
