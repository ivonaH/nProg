/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ai.nprog.mavenServer.thread;

import rs.ac.bg.fon.ai.nprog.mavenServer.controller.Controller;
import rs.ac.bg.fon.ai.nprog.mavenCommonLib.domain.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import rs.ac.bg.fon.ai.nprog.mavenCommonLib.transfer.RequestObject;
import rs.ac.bg.fon.ai.nprog.mavenCommonLib.transfer.ResponseObject;
import rs.ac.bg.fon.ai.nprog.mavenCommonLib.util.Operation;
import rs.ac.bg.fon.ai.nprog.mavenCommonLib.util.ResponseStatus;

/**
 *
 * @author Ivona
 */
public class ClientThread extends Thread {

    private final Socket socket;
    private final ObjectInputStream objectInputStream;
    private final ObjectOutputStream objectOutputStream;

    private User loginUser;

    ClientThread(Socket socket) throws IOException {
        this.socket = socket;
        objectInputStream = new ObjectInputStream(socket.getInputStream());
        objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
    }

    @Override
    public void run() {
        try {
            while (!isInterrupted()) {

                RequestObject requestObject = (RequestObject) objectInputStream.readObject();
                ResponseObject responseObject = handleRequest(requestObject);
                responseObject.setOperation(requestObject.getOperation());
                sendResponse(responseObject);

            }
        } catch (IOException | ClassNotFoundException ex) {
            Controller.getInstance().removeClient(this);
            this.interrupt();
        }
    }

    public Socket getSocket() {
        return socket;
    }

    public User getLoginUser() {
        return loginUser;
    }

    private ResponseObject handleRequest(RequestObject requestObject) {
        int operation = requestObject.getOperation();
        switch (operation) {
            case Operation.OPERATION_NADJI_RADNIKA: {
                System.out.println("PRIMIO ZAHTEV ZA NADJI RADNIKA");
                User user = (User) requestObject.getData();
                ResponseObject ro = login(user, operation);

                return ro;
            }
            case Operation.OPERATION_VRATI_SALE: {
                return getAllHalls(operation);
            }
            case Operation.OPERATION_VRATI_FILMOVE: {
                System.out.println("PRIMIO ZAHTEV ZA PRIKAZ FILMOVA");
                return getAllMovies(operation);
            }
            case Operation.OPERATION_VRATI_FILMSKE_MARATONE: {
                System.out.println("PRIMIO ZAHTEV ZA PRIKAZ MARATONA");
                return getAllMovieMarathons(operation);
            }
            case Operation.OPERATION_VRATI_REZERVACIJE: {
                System.out.println("PRIMIO ZAHTEV ZA PRIKAZ REZERVACIJA");
                return getAllReservations(operation);
            }
            case Operation.OPERATION_VRATI_FILMOVE_PO_KRITERIJUMU: {
                System.out.println("PRIMIO ZAHTEV ZA PRIKAZ FILMOVA PO KRITERIJUMU");
                return getMoviesWithCriteria(requestObject.getColumns(), requestObject.getValues(), operation);
            }
            case Operation.OPERATION_VRATI_PROJEKCIJE_PO_KRITERIJUMU: {
                System.out.println("PRIMIO ZAHTEV ZA PRIKAZ SHOWTIME PO KRITERIJUMU");
                return getShowtimesWithCriteria(requestObject.getColumns(), requestObject.getValues(), operation);
            }
            case Operation.OPERATION_VRATI_FILMSKE_MARATONE_PO_KRITERIJUMU: {
                System.out.println("PRIMIO ZAHTEV ZA PRIKAZ maratona PO KRITERIJUMU");
                return getMarathonsWithCriteria(requestObject.getColumns(), requestObject.getValues(), operation);
            }
            case Operation.OPERATION_VRATI_REZERVACIJE_PO_KRITERIJUMU: {
                System.out.println("PRIMIO ZAHTEV ZA PRIKAZ maratona PO KRITERIJUMU");
                return getReservationsWithCriteria(requestObject.getColumns(), requestObject.getValues(), operation);
            }
            case Operation.OPERATION_KREIRAJ_FILM: {
                System.out.println("PRIMIO ZAHTEV ZA cuvanje filma");
                return saveMovie(requestObject.getData(), operation);
            }
            case Operation.OPERATION_KREIRAJ_REZERVACIJU: {
                System.out.println("PRIMIO ZAHTEV ZA cuvanje rezervacije");
                return saveReservation(requestObject.getData(), operation);
            }
            case Operation.OPERATION_OBRISI_REZERVACIJU: {
                System.out.println("PRIMIO ZAHTEV ZA brisanje rezervacije");
                return removeReservation(requestObject.getData(), operation);
            }
            case Operation.OPERATION_KREIRAJ_PROJEKCIJU: {
                System.out.println("PRIMIO ZAHTEV ZA cuvanje projekcije");
                return saveShowtime(requestObject.getData(), operation);
            }
            case Operation.OPERATION_OBRISI_PROJEKCIJU: {
                System.out.println("PRIMIO ZAHTEV ZA brisanje projekcije");
                return removeShowtime(requestObject.getData(), operation);
            }
            case Operation.OPERATION_IZMENI_PROJEKCIJU: {
                System.out.println("PRIMIO ZAHTEV ZA izmenu projekcije");
                return updateShowtime(requestObject.getData(), operation);
            }
            case Operation.OPERATION_KREIRAJ_MARATON: {
                System.out.println("PRIMIO ZAHTEV ZA kreiranje mm ");
                return saveMovieMarathon(requestObject.getData(), operation);
            }
        }
        return null;
    }

    private ResponseObject login(User checkUser, int operation) {
        ResponseObject responseObject = new ResponseObject();
        responseObject.setOperation(operation);
        User user;
        try {
            user = Controller.getInstance().login(checkUser);
            if (user != null) {
              
                    if (!Controller.getInstance().getOnlineUsers().contains(user)) {
                        System.out.println(Controller.getInstance().getOnlineUsers());
                        loginUser = user;
                        responseObject.setStatus(ResponseStatus.SUCCESS);
                        responseObject.setData(user);
                    } else {
                        responseObject.setStatus(ResponseStatus.ERROR);
                        responseObject.setErrorMessage("Korisnik sa tim podacima je vec ulogovan.");
                    }

            }
        } catch (Exception ex) {
            responseObject.setStatus(ResponseStatus.ERROR);
            responseObject.setErrorMessage(ex.getMessage());
        }
        return responseObject;
    }

    private ResponseObject getAllHalls(int operation) {
        ResponseObject responseObject = new ResponseObject();
        responseObject.setOperation(operation);

        List<Hall> halls;
        try {
            halls = Controller.getInstance().getAllHalls();
            if (halls != null) {
                responseObject.setData(halls);
                responseObject.setStatus(ResponseStatus.SUCCESS);
            }
        } catch (Exception ex) {
            responseObject.setStatus(ResponseStatus.ERROR);
            responseObject.setErrorMessage(ex.getMessage());
        }
        return responseObject;
    }

    private ResponseObject getAllMovies(int operation) {
        ResponseObject responseObject = new ResponseObject();
        responseObject.setOperation(operation);
        List<Movie> movies;
        try {
            movies = Controller.getInstance().getAllMovies();
            if (movies != null) {
                responseObject.setData(movies);
                responseObject.setStatus(ResponseStatus.SUCCESS);
            }
        } catch (Exception ex) {
            responseObject.setStatus(ResponseStatus.ERROR);
            responseObject.setErrorMessage(ex.getMessage());
        }
        return responseObject;
    }

    private ResponseObject getAllMovieMarathons(int operation) {
        ResponseObject responseObject = new ResponseObject();
        responseObject.setOperation(operation);
        List<MovieMarathon> movieMarathons;
        try {
            movieMarathons = Controller.getInstance().getAllMovieMarathons();
            if (movieMarathons != null) {
                responseObject.setData(movieMarathons);
                responseObject.setStatus(ResponseStatus.SUCCESS);
            }
        } catch (Exception ex) {
            responseObject.setStatus(ResponseStatus.ERROR);
            responseObject.setErrorMessage(ex.getMessage());
        }
        return responseObject;
    }

    private ResponseObject getAllReservations(int operation) {
        ResponseObject responseObject = new ResponseObject();
        responseObject.setOperation(operation);
        List<Reservation> reservations;
        try {
            reservations = Controller.getInstance().getAllReservations();
            if (reservations != null) {
                responseObject.setData(reservations);
                responseObject.setStatus(ResponseStatus.SUCCESS);
            }
        } catch (Exception ex) {
            responseObject.setStatus(ResponseStatus.ERROR);
            responseObject.setErrorMessage(ex.getMessage());
        }
        return responseObject;
    }

    private ResponseObject getMoviesWithCriteria(List<String> columns, List<String> values, int operation) {
        ResponseObject responseObject = new ResponseObject();
        responseObject.setOperation(operation);
        List<Movie> movies;
        try {
            movies = Controller.getInstance().getMoviesWithCriteria(columns, values);
            if (movies != null) {
                responseObject.setData(movies);
                responseObject.setStatus(ResponseStatus.SUCCESS);
            }
        } catch (Exception ex) {
            responseObject.setStatus(ResponseStatus.ERROR);
            responseObject.setErrorMessage(ex.getMessage());
        }
        return responseObject;
    }

    private ResponseObject getShowtimesWithCriteria(List<String> columns, List<String> values, int operation) {
        ResponseObject responseObject = new ResponseObject();
        responseObject.setOperation(operation);
        List<Showtime> showtimes;
        try {
            showtimes =Controller.getInstance().getShowtimesWithCriteria(columns, values);
            if (showtimes != null) {
                responseObject.setData(showtimes);
                responseObject.setStatus(ResponseStatus.SUCCESS);
            }
        } catch (Exception ex) {
            responseObject.setStatus(ResponseStatus.ERROR);
            responseObject.setErrorMessage(ex.getMessage());
        }
        return responseObject;
    }

    private ResponseObject getMarathonsWithCriteria(ArrayList<String> columns, ArrayList<String> values, int operation) {
        ResponseObject responseObject = new ResponseObject();
        responseObject.setOperation(operation);
        List<MovieMarathon> marathons;
        try {
            marathons = Controller.getInstance().getMovieMarathonWithCriteria(columns, values);
            if (marathons != null) {
                responseObject.setData(marathons);
                responseObject.setStatus(ResponseStatus.SUCCESS);
            }
        } catch (Exception ex) {
            responseObject.setStatus(ResponseStatus.ERROR);
            responseObject.setErrorMessage(ex.getMessage());
        }
        return responseObject;
    }

    private ResponseObject getReservationsWithCriteria(ArrayList<String> columns, ArrayList<String> values, int operation) {
        ResponseObject responseObject = new ResponseObject();
        responseObject.setOperation(operation);
        List<Reservation> reservations;
        try {
            reservations = Controller.getInstance().getReservationsWithCriteria(columns, values);
            if (reservations != null) {
                responseObject.setData(reservations);
                responseObject.setStatus(ResponseStatus.SUCCESS);
            }
        } catch (Exception ex) {
            responseObject.setStatus(ResponseStatus.ERROR);
            responseObject.setErrorMessage(ex.getMessage());
        }
        return responseObject;
    }

    private ResponseObject saveMovie(Object data, int operation) {
        ResponseObject responseObject = new ResponseObject();
        responseObject.setOperation(operation);
        try {
            Controller.getInstance().saveMovie(data);
            responseObject.setStatus(ResponseStatus.SUCCESS);
        } catch (Exception ex) {
            responseObject.setErrorMessage(ex.getMessage());
            responseObject.setStatus(ResponseStatus.ERROR);
        }
        return responseObject;
    }

    private ResponseObject saveMovieMarathon(Object data, int operation) {
        ResponseObject responseObject = new ResponseObject();
        responseObject.setOperation(operation);
        try {
            Controller.getInstance().saveMovieMarathon(data);
            responseObject.setStatus(ResponseStatus.SUCCESS);
        } catch (Exception ex) {
            responseObject.setErrorMessage(ex.getMessage());
            responseObject.setStatus(ResponseStatus.ERROR);
        }
        return responseObject;
    }

    private ResponseObject saveReservation(Object data, int operation) {
        ResponseObject responseObject = new ResponseObject();
        responseObject.setOperation(operation);
        try {
            Controller.getInstance().saveReservation(data);
            responseObject.setStatus(ResponseStatus.SUCCESS);
        } catch (Exception ex) {
            responseObject.setErrorMessage(ex.getMessage());
            responseObject.setStatus(ResponseStatus.ERROR);
        }
        return responseObject;
    }

    private ResponseObject removeReservation(Object data, int operation) {
        ResponseObject responseObject = new ResponseObject();
        responseObject.setOperation(operation);
        try {
            Controller.getInstance().removeReservation(data);
            responseObject.setStatus(ResponseStatus.SUCCESS);
        } catch (Exception ex) {
            responseObject.setErrorMessage(ex.getMessage());
            responseObject.setStatus(ResponseStatus.ERROR);
        }
        return responseObject;
    }

    private ResponseObject saveShowtime(Object data, int operation) {
        ResponseObject responseObject = new ResponseObject();
        responseObject.setOperation(operation);
        try {
            Controller.getInstance().saveShowtime(data);
            responseObject.setStatus(ResponseStatus.SUCCESS);
        } catch (Exception ex) {
            responseObject.setErrorMessage(ex.getMessage());
            responseObject.setStatus(ResponseStatus.ERROR);
        }
        return responseObject;
    }

    private ResponseObject removeShowtime(Object data, int operation) {
        ResponseObject responseObject = new ResponseObject();
        responseObject.setOperation(operation);
        try {
            Controller.getInstance().removeShowtime(data);
            responseObject.setStatus(ResponseStatus.SUCCESS);
        } catch (Exception ex) {
            responseObject.setErrorMessage(ex.getMessage());
            responseObject.setStatus(ResponseStatus.ERROR);

        }
        return responseObject;
    }

    private ResponseObject updateShowtime(Object data, int operation) {
        ResponseObject responseObject = new ResponseObject();
        responseObject.setOperation(operation);
        try {
            Controller.getInstance().updateShowtime(data);
            responseObject.setStatus(ResponseStatus.SUCCESS);
        } catch (Exception ex) {
            responseObject.setErrorMessage(ex.getMessage());
            responseObject.setStatus(ResponseStatus.ERROR);

        }
        return responseObject;
    }

    public void sendResponse(ResponseObject responseObject) throws IOException {
        objectOutputStream.writeObject(responseObject);
        objectOutputStream.flush();
    }

    private void logout() {
        Controller.getInstance().logout(this);
    }

    public void setLoginUser(User loginUser) {
        this.loginUser = loginUser;
    }

}
