/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ai.nprog.mavenClient.controller;

import rs.ac.bg.fon.ai.nprog.mavenCommonLib.domain.Hall;
import rs.ac.bg.fon.ai.nprog.mavenCommonLib.domain.Movie;
import rs.ac.bg.fon.ai.nprog.mavenCommonLib.domain.MovieMarathon;
import rs.ac.bg.fon.ai.nprog.mavenCommonLib.domain.Reservation;
import rs.ac.bg.fon.ai.nprog.mavenCommonLib.domain.Showtime;
import rs.ac.bg.fon.ai.nprog.mavenCommonLib.domain.User;
import rs.ac.bg.fon.ai.nprog.mavenCommonLib.exception.ValidationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

import rs.ac.bg.fon.ai.nprog.mavenClient.thread.CommunicationWithServer;
import rs.ac.bg.fon.ai.nprog.mavenCommonLib.transfer.RequestObject;
import rs.ac.bg.fon.ai.nprog.mavenClient.ui.form.FLogin;
import rs.ac.bg.fon.ai.nprog.mavenClient.ui.form.FMain;
import rs.ac.bg.fon.ai.nprog.mavenClient.ui.form.FMovie;
import rs.ac.bg.fon.ai.nprog.mavenClient.ui.form.FMovieMarathon;
import rs.ac.bg.fon.ai.nprog.mavenClient.ui.form.FMovieMarathonSearch;
import rs.ac.bg.fon.ai.nprog.mavenClient.ui.form.FMovieSearch;
import rs.ac.bg.fon.ai.nprog.mavenClient.ui.form.FReservation;
import rs.ac.bg.fon.ai.nprog.mavenClient.ui.form.FReservationSearch;
import rs.ac.bg.fon.ai.nprog.mavenClient.ui.form.FShowtime;
import rs.ac.bg.fon.ai.nprog.mavenClient.ui.form.FShowtimeSearch;
import rs.ac.bg.fon.ai.nprog.mavenCommonLib.util.Operation;
import rs.ac.bg.fon.ai.nprog.mavenClient.validation.EmailValidator;
import rs.ac.bg.fon.ai.nprog.mavenClient.validation.LoginValidator;
import rs.ac.bg.fon.ai.nprog.mavenClient.validation.SaveMovieMarathonValidator;
import rs.ac.bg.fon.ai.nprog.mavenClient.validation.ShowtimeValidation;

/**
 *
 * @author Ivona
 */
public class Controller {

    private static Controller instance;
    private User currentUser;
    private FMain fMain;
    private FShowtime fShowtime;
    private FMovieSearch fMovieSearch;
    private FLogin fLogin;
    private FMovie fMovie;
    private FReservationSearch fReservationSearch;
    CommunicationWithServer communicationWithServer;
    private FReservation fReservation;
    private FMovieMarathon fMovieMarathon;
    private JDialog dialog;

    private Controller() {
        currentUser = new User();

    }

    public void connect(int portNumber) {
        try {
            communicationWithServer = new CommunicationWithServer();
            communicationWithServer.connect(portNumber);
            communicationWithServer.start();

        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    public static Controller getInstance() {
        if (instance == null) {
            instance = new Controller();

        }

        return instance;
    }

    public void login(String username, String password) throws IOException, ClassNotFoundException, Exception {
        try {
            LoginValidator.validateUsernameAndPassword(username, password);
            RequestObject requestObject = new RequestObject();
            requestObject.setData(new User(username, password));
            requestObject.setOperation(Operation.OPERATION_NADJI_RADNIKA);
            communicationWithServer.sendClientRequest(requestObject);
        } catch (ValidationException validationException) {
            fLogin.fieldsEmpty();
        }
    }

    public void getAllHalls(FShowtime fShowtime) throws Exception {
        this.fShowtime = fShowtime;
        RequestObject requestObject = new RequestObject();
        requestObject.setOperation(Operation.OPERATION_VRATI_SALE);
        communicationWithServer.sendClientRequest(requestObject);
    }

    public void getAllMovies(FMovieSearch fMovieSearch) throws Exception {
        this.fMovieSearch = fMovieSearch;
        RequestObject requestObject = new RequestObject();
        requestObject.setOperation(Operation.OPERATION_VRATI_FILMOVE);
        communicationWithServer.sendClientRequest(requestObject);
    }

    public List<Movie> getAllMoviesFAILED(JDialog dialog) throws Exception {
        return null;
    }

    public void getAllReservations(FReservationSearch fReservationSearch) throws Exception {
        this.fReservationSearch = fReservationSearch;
        RequestObject requestObject = new RequestObject();
        requestObject.setOperation(Operation.OPERATION_VRATI_REZERVACIJE);
        communicationWithServer.sendClientRequest(requestObject);

    }

    public void getAllMovieMarathons(FMovieMarathonSearch fMovieMarathonSearch) throws Exception {
        dialog = fMovieMarathonSearch;
        RequestObject requestObject = new RequestObject();
        requestObject.setOperation(Operation.OPERATION_VRATI_FILMSKE_MARATONE);
        communicationWithServer.sendClientRequest(requestObject);
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void getMoviesWithCriteria(ArrayList<String> columns, ArrayList<String> values, FMovieSearch fMovieSearch) throws Exception {
        this.fMovieSearch = fMovieSearch;
        RequestObject requestObject = new RequestObject();
        requestObject.setOperation(Operation.OPERATION_VRATI_FILMOVE_PO_KRITERIJUMU);
        requestObject.setColumns(columns);
        requestObject.setValues(values);
        communicationWithServer.sendClientRequest(requestObject);
    }

    public void getShowtimesWithCriteria(ArrayList<String> columns, ArrayList<String> values, JDialog dialog) throws Exception {//
        this.dialog = dialog;
        RequestObject requestObject = new RequestObject();
        requestObject.setOperation(Operation.OPERATION_VRATI_PROJEKCIJE_PO_KRITERIJUMU);
        requestObject.setColumns(columns);
        requestObject.setValues(values);
        communicationWithServer.sendClientRequest(requestObject);
    }

    public void getMovieMarathonWithCriteria(ArrayList<String> columns, ArrayList<String> values, FMovieMarathonSearch fMovieMarathonSearch) throws Exception {
        RequestObject requestObject = new RequestObject();
        requestObject.setOperation(Operation.OPERATION_VRATI_FILMSKE_MARATONE_PO_KRITERIJUMU);
        requestObject.setColumns(columns);
        requestObject.setValues(values);
        communicationWithServer.sendClientRequest(requestObject);

    }

    public void getReservationsWithCriteria(ArrayList<String> columns, ArrayList<String> values, FReservationSearch fReservationSearch) throws Exception {
        this.fReservationSearch = fReservationSearch;
        RequestObject requestObject = new RequestObject();
        requestObject.setOperation(Operation.OPERATION_VRATI_REZERVACIJE_PO_KRITERIJUMU);
        requestObject.setColumns(columns);
        requestObject.setValues(values);
        communicationWithServer.sendClientRequest(requestObject);
    }

    public void saveMovie(Movie movie, FMovie fMovie) throws Exception {
        this.fMovie = fMovie;
        RequestObject requestObject = new RequestObject();
        requestObject.setOperation(Operation.OPERATION_KREIRAJ_FILM);
        requestObject.setData(movie);
        communicationWithServer.sendClientRequest(requestObject);

    }

    public void saveReservation(Reservation reservation, FReservation fReservation) throws Exception {
        this.fReservation = fReservation;
        try {
            EmailValidator.validateEmail(reservation.getEmail());

            RequestObject requestObject = new RequestObject();
            requestObject.setOperation(Operation.OPERATION_KREIRAJ_REZERVACIJU);
            requestObject.setData(reservation);
            communicationWithServer.sendClientRequest(requestObject);
        } catch (ValidationException validationException) {
            fReservation.invalidEmail();
            System.out.println(validationException.getMessage());

        }
    }

    public void saveShowtime(Showtime showtime, FShowtime fShowtime) throws Exception {
        this.fShowtime = fShowtime;
        try {
        	ShowtimeValidation.validateShowtimeDate(showtime);
            RequestObject requestObject = new RequestObject();
            requestObject.setOperation(Operation.OPERATION_KREIRAJ_PROJEKCIJU);
            requestObject.setData(showtime);
            communicationWithServer.sendClientRequest(requestObject);
        } catch (ValidationException validationException) {
            fShowtime.invalidDateAndTime();
            System.out.println(validationException.getMessage());
        }

    }

    public void removeShowtime(Showtime showtime, FShowtimeSearch fShowtimeSearch) throws Exception {
        dialog = fShowtimeSearch;
        RequestObject requestObject = new RequestObject();
        requestObject.setOperation(Operation.OPERATION_OBRISI_PROJEKCIJU);
        requestObject.setData(showtime);
        communicationWithServer.sendClientRequest(requestObject);
    }

    public void removeReservation(Reservation reservation, FReservationSearch fReservationSearch) throws Exception {
        RequestObject requestObject = new RequestObject();
        requestObject.setOperation(Operation.OPERATION_OBRISI_REZERVACIJU);
        requestObject.setData(reservation);
        communicationWithServer.sendClientRequest(requestObject);
    }

    public void updateShowtime(Showtime showtime, Hall hall, FShowtime fShowtime) throws Exception {
        RequestObject requestObject = new RequestObject();
        requestObject.setOperation(Operation.OPERATION_IZMENI_PROJEKCIJU);
        showtime.setHall(hall);
        System.out.println("POSTAVALJENA SALA: " + showtime.getHall().getName());
        requestObject.setData(showtime);
        communicationWithServer.sendClientRequest(requestObject);

    }

    public void saveMovieMarathon(MovieMarathon movieMarathon, List<Showtime> showtimes, FMovieMarathon fMovieMarathon) throws Exception {
        this.fMovieMarathon = fMovieMarathon;
        try {
        	SaveMovieMarathonValidator.validateShowtimes(showtimes);
            RequestObject requestObject = new RequestObject();
            requestObject.setOperation(Operation.OPERATION_KREIRAJ_MARATON);
            ArrayList<Object> objectsToAdd = new ArrayList<>();
            objectsToAdd.add(movieMarathon);
            objectsToAdd.add(showtimes);
            requestObject.setData(objectsToAdd);
            communicationWithServer.sendClientRequest(requestObject);
        } catch (ValidationException ve) {
            fMovieMarathon.mmNotCreated();
            System.out.println(ve.getMessage());
        }

    }

    public void setfMain(FMain fMain) {
        this.fMain = fMain;
    }

    public void loginSuccess(User user) {
        currentUser = user;
        fLogin.loginSuccess();
    }

    public void loginFailed() {
        fLogin.loginFailed();
    }

    public void hallLoadingSuccess(List<Hall> halls) throws Exception {
        fShowtime.setHallsForShowtime(halls);
    }

    public void hallLoadingFailed() {
        fShowtime.hallLoadingFailed();

    }

    public void movieLoadingSuccess(List<Movie> movies) throws Exception {
        fMovieSearch.setMovies(movies);
    }

    public void movieLoadingFailed() {
        fMovieSearch.moviesLoadingFailed();
    }

    public void movieSaved() {
        fMovie.movieIsSaved();
    }

    public void movieIsNotSaved() {
        fMovie.movieIsNotSaved();

    }

    public void reservationSaved() {
        fReservation.reservationIsSaved();
    }

    public void reservationIsNotSaved() {
        fReservation.reservationIsNotSaved();

    }

    public void showtimeSaved() {
        fShowtime.showtimeIsSaved();
    }

    public void showtimeIsNotSaved() {
        fShowtime.showtimeIsNotSaved();

    }

    public void movieMarathonSaved() {
        fMovieMarathon.mmCreated();
    }

    public void movieMarathtonIsNotSaved() {
        fMovieMarathon.mmNotCreated();

    }

    public void reservationLoadingSuccess(List<Reservation> reservations) throws Exception {
        fReservationSearch.fillTableReservation(reservations);
    }

    public void reservationLoadingFailed() {
        fReservationSearch.reservationLoadingFailed();
    }

    public void movieMarathonLoadingSuccess(List<MovieMarathon> movieMarathons) {
        FMovieMarathonSearch fMovieMarathonSearch = (FMovieMarathonSearch) dialog;
        fMovieMarathonSearch.fillTable(movieMarathons);
    }

    public void movieMarathonLoadingFailed() {
        FMovieMarathonSearch fMovieMarathonSearch = (FMovieMarathonSearch) dialog;
        fMovieMarathonSearch.marathonLoadingFailed();
    }

    public void showtimeLoadingSuccess(List<Showtime> showtimes) throws Exception {
        if (dialog instanceof FShowtimeSearch) {
            FShowtimeSearch fShowtimeSearch = (FShowtimeSearch) dialog;
            fShowtimeSearch.setShowtimes(showtimes);
        } else if (dialog instanceof FMovieMarathonSearch) {
            FMovieMarathonSearch fMovieMarathonSearch = (FMovieMarathonSearch) dialog;
            fMovieMarathonSearch.setShowtimes(showtimes);
        }
    }

    public void showtimeLoadingFailed() {

        if (dialog instanceof FShowtimeSearch) {
            FShowtimeSearch fShowtimeSearch = (FShowtimeSearch) dialog;
            fShowtimeSearch.showtimesLoadingFailed();

        } else if (dialog instanceof FMovieMarathonSearch) {
            FMovieMarathonSearch fMovieMarathonSearch = (FMovieMarathonSearch) dialog;
            fMovieMarathonSearch.showtimesLoadingFailed();
        }
    }

    public void showtimeDeleted() {
        FShowtimeSearch fShowtimeSearch = (FShowtimeSearch) dialog;
        fShowtimeSearch.showtimeIsDeleted();
    }

    public void showtimeNotDeleted() {
        FShowtimeSearch fShowtimeSearch = (FShowtimeSearch) dialog;
        fShowtimeSearch.showtimeIsNotDeleted();
    }

    public void showtimeUpdated() {
        fShowtime.showtimeIsUpdated();
    }

    public void showtimeNotUpdated() {
        fShowtime.showtimeIsNotUpdated();
    }

    public void reservationDeleted() {
        FShowtimeSearch fShowtimeSearch = (FShowtimeSearch) dialog;
        fReservationSearch.reservationIsDeleted();
    }

    public void reservationNotDeleted() {
        fReservationSearch.reservationIsNotDeleted();
    }

    public void startLoginForm() {
        fLogin = new FLogin();
        fLogin.setVisible(true);
    }

    public void serverIsNotActive() {
        JOptionPane.showMessageDialog(null, "Server is not active.");
    }

    public void getMovieWithId(int movieId, FMovie fMovie) {
        this.fMovie = fMovie;
        RequestObject requestObject = new RequestObject();
        requestObject.setData(movieId);
        requestObject.setOperation(Operation.OPERATION_VRATI_FILM_SA_ID);
        communicationWithServer.sendClientRequest(requestObject);
    }

    public void getReservationWithId(int reservationId, FReservation fReservation) {
        this.fReservation = fReservation;
        RequestObject requestObject = new RequestObject();
        requestObject.setData(reservationId);
        requestObject.setOperation(Operation.OPERATION_VRATI_REZERVACIJU_SA_ID);
        communicationWithServer.sendClientRequest(requestObject);
    }

    public void getShowtimeWithId(int showtimeId, FShowtime fShowtime) {
        this.fShowtime = fShowtime;
        RequestObject requestObject = new RequestObject();
        requestObject.setData(showtimeId);
        requestObject.setOperation(Operation.OPERATION_VRATI_PROJEKCIJU_SA_ID);
        communicationWithServer.sendClientRequest(requestObject);
    }

    public void movieLoaded(Movie movie) {
        fMovie.movieLoaded(movie);
    }

    public void movieNotLoaded() {
        fMovie.movieNotLoaded();
    }

    public void showtimeLoaded(Showtime showtime) {
        try {
            fShowtime.showtimeLoaded(showtime);
        } catch (Exception ex) {
        	System.out.println(ex);
        }
    }

    public void showtimeNotLoaded() {
        fShowtime.showtimeNotLoaded();
    }

    public void reservationLoaded(Reservation reservation) {
        fReservation.reservationLoaded(reservation);
    }

    public void reservationNotLoaded() {
        fReservation.reservationNotLoaded();
    }

}
