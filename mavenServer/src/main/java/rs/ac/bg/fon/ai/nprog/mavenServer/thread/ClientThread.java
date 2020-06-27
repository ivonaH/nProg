/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ai.nprog.mavenServer.thread;

import rs.ac.bg.fon.ai.nprog.mavenServer.controller.Controller;
import rs.ac.bg.fon.ai.nprog.mavenServer.history.History;
import rs.ac.bg.fon.ai.nprog.mavenCommonLib.domain.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;
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
				History.getInstance().saveToHistory(loginUser, requestObject, responseObject, new Date());

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
			System.out.println("primio zahtev za nadji");
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
			System.out.println("PRIMIO ZAHTEV ZA PRIKAZ rezervacija PO KRITERIJUMU");
			return getReservationsWithCriteria(requestObject.getColumns(), requestObject.getValues(), operation);
		}
		case Operation.OPERATION_KREIRAJ_FILM: {
			System.out.println("PRIMIO ZAHTEV ZA cuvanje filma");
			return saveMovie(requestObject.getData(), operation);
		}
		case Operation.OPERATION_VRATI_FILM_SA_ID: {
			return getMovieWithId(requestObject.getData(), operation);
		}
		case Operation.OPERATION_VRATI_REZERVACIJU_SA_ID: {
			System.out.println("PRIMIO ZAHTEV da nadje rezerv sa idijem");
			return getReservationWithId(requestObject.getData(), operation);
		}
		case Operation.OPERATION_VRATI_PROJEKCIJU_SA_ID: {
			System.out.println("PRIMIO ZAHTEV da nadje projek sa idijem");
			return getShowtimeWithId(requestObject.getData(), operation);
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
			System.out.println("USAO U CLIENT THREAD");
			user = Controller.getInstance().login(checkUser);
			if (user != null) {
	

				if (!Controller.getInstance().getOnlineUsers().contains(user)) {
					System.out.println(Controller.getInstance().getOnlineUsers());
					loginUser = user;
//                        Controller.getInstance().addOnlineUser(user);
					System.out.println("POSTAVLJAM LOGIN USERA");
					responseObject.setStatus(ResponseStatus.SUCCESS);
					responseObject.setData(user);
				} else {
					responseObject.setStatus(ResponseStatus.ERROR);
					responseObject.setErrorMessage("Korisnik sa tim podacima je vec ulogovan.");
				}

			}else {
				responseObject.setStatus(ResponseStatus.ERROR);
				responseObject.setErrorMessage("Neispravan username/password.");

			}
		} catch (Exception ex) {
			responseObject.setStatus(ResponseStatus.ERROR);
			responseObject.setErrorMessage(ex.getMessage());
			System.out.println(ex.getMessage());

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
				System.out.println("USPESNO");
				responseObject.setData(halls);
				responseObject.setStatus(ResponseStatus.SUCCESS);
			}
		} catch (Exception ex) {
			System.out.println("JESTE NULL");
			responseObject.setStatus(ResponseStatus.ERROR);
			responseObject.setErrorMessage(ex.getMessage());
			System.out.println(ex.getMessage());

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
				System.out.println("USPESNO MOVIE");
				responseObject.setData(movies);
				responseObject.setStatus(ResponseStatus.SUCCESS);
			}
		} catch (Exception ex) {
			System.out.println("JESTE NULL MOVIE");
			responseObject.setStatus(ResponseStatus.ERROR);
			responseObject.setErrorMessage(ex.getMessage());
			System.out.println(ex.getMessage());

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
				System.out.println("USPESNO MOVIE");
				responseObject.setData(movieMarathons);
				responseObject.setStatus(ResponseStatus.SUCCESS);
			}
		} catch (Exception ex) {
			System.out.println("JESTE NULL MOVIE MARATHON");
			responseObject.setStatus(ResponseStatus.ERROR);
			responseObject.setErrorMessage(ex.getMessage());
			System.out.println(ex.getMessage());

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
				System.out.println("USPESNO RES");
				responseObject.setData(reservations);
				responseObject.setStatus(ResponseStatus.SUCCESS);
			}
		} catch (Exception ex) {
			System.out.println("JESTE NULL RES");
			responseObject.setStatus(ResponseStatus.ERROR);
			responseObject.setErrorMessage(ex.getMessage());
			System.out.println(ex.getMessage());

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
			System.out.println("JESTE NULL MOVIE WITH WHERE");
			responseObject.setStatus(ResponseStatus.ERROR);
			responseObject.setErrorMessage(ex.getMessage());
			System.out.println(ex.getMessage());

		}
		return responseObject;
	}

	private ResponseObject getShowtimesWithCriteria(List<String> columns, List<String> values, int operation) {
		ResponseObject responseObject = new ResponseObject();
		responseObject.setOperation(operation);
		List<Showtime> showtimes;
		try {
			showtimes = Controller.getInstance().getShowtimesWithCriteria(columns, values);
			if (showtimes != null) {
				responseObject.setData(showtimes);
				responseObject.setStatus(ResponseStatus.SUCCESS);
			}
		} catch (Exception ex) {
			System.out.println("JESTE NULL showtime WITH WHERE");
			responseObject.setStatus(ResponseStatus.ERROR);
			responseObject.setErrorMessage(ex.getMessage());
			System.out.println(ex.getMessage());

		}
		return responseObject;
	}

	private ResponseObject getMarathonsWithCriteria(ArrayList<String> columns, ArrayList<String> values,
			int operation) {
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
			System.out.println(ex.getMessage());

		}
		return responseObject;
	}

	private ResponseObject getReservationsWithCriteria(ArrayList<String> columns, ArrayList<String> values,
			int operation) {
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
			System.out.println(ex.getMessage());

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
			System.out.println(ex.getMessage());

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
			System.out.println(ex.getMessage());

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
			System.out.println(ex.getMessage());

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
			System.out.println(ex.getMessage());

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
			System.out.println(ex.getMessage());

		}
		return responseObject;
	}

	private ResponseObject removeShowtime(Object data, int operation) {
		ResponseObject responseObject = new ResponseObject();
		responseObject.setOperation(operation);
		try {
			Controller.getInstance().removeShowtime(data);
			responseObject.setStatus(ResponseStatus.SUCCESS);
			System.out.println("USPESNO BRISANJE");
		} catch (Exception ex) {
			responseObject.setErrorMessage(ex.getMessage());
			responseObject.setStatus(ResponseStatus.ERROR);
			System.out.println("NEUSPESNO BRISANJE");
			System.out.println(ex.getMessage());

		}
		return responseObject;
	}

	private ResponseObject updateShowtime(Object data, int operation) {
		ResponseObject responseObject = new ResponseObject();
		responseObject.setOperation(operation);
		try {
			Controller.getInstance().updateShowtime(data);
			responseObject.setStatus(ResponseStatus.SUCCESS);
			System.out.println("USPESNO IZMENJENO");
		} catch (Exception ex) {
			responseObject.setErrorMessage(ex.getMessage());
			responseObject.setStatus(ResponseStatus.ERROR);
			System.out.println("NEUSPESNO IZMENJENO");
			System.out.println(ex.getMessage());

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

	private ResponseObject getMovieWithId(Object data, int operation) {
		ResponseObject responseObject = new ResponseObject();
		responseObject.setOperation(operation);
		Movie movie;
		try {
			movie = Controller.getInstance().getMovieWithId((int) data);
			if (movie != null) {
				responseObject.setData(movie);
				responseObject.setStatus(ResponseStatus.SUCCESS);
			}
		} catch (Exception ex) {
			System.out.println("Greska prilikom nalazenja filma");
			responseObject.setStatus(ResponseStatus.ERROR);
			responseObject.setErrorMessage(ex.getMessage());
			System.out.println(ex.getMessage());

		}
		return responseObject;
	}

	private ResponseObject getReservationWithId(Object data, int operation) {
		ResponseObject responseObject = new ResponseObject();
		responseObject.setOperation(operation);
		Reservation reservation;
		try {

			reservation = Controller.getInstance().getReservationWithId((int) data);
			if (reservation != null) {
				responseObject.setData(reservation);
				responseObject.setStatus(ResponseStatus.SUCCESS);
			}
		} catch (Exception ex) {
			System.out.println("Greska prilikom nalazenja rezervacije");
			responseObject.setStatus(ResponseStatus.ERROR);
			responseObject.setErrorMessage(ex.getMessage());
			System.out.println(ex.getMessage());

		}
		return responseObject;
	}

	private ResponseObject getShowtimeWithId(Object data, int operation) {
		ResponseObject responseObject = new ResponseObject();
		responseObject.setOperation(operation);
		Showtime showtime;
		try {

			showtime = Controller.getInstance().getShowtimeWithId((int) data);
			if (showtime != null) {
				responseObject.setData(showtime);
				responseObject.setStatus(ResponseStatus.SUCCESS);
			}
		} catch (Exception ex) {
			System.out.println("Greska prilikom nalazenja projekcije");
			responseObject.setStatus(ResponseStatus.ERROR);
			responseObject.setErrorMessage(ex.getMessage());
			System.out.println(ex.getMessage());

		}
		return responseObject;
	}
}
