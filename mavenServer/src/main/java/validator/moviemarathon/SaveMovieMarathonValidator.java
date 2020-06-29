package validator.moviemarathon;

import java.util.ArrayList;

import rs.ac.bg.fon.ai.nprog.mavenCommonLib.domain.Showtime;
import rs.ac.bg.fon.ai.nprog.mavenCommonLib.exception.ValidationException;

public class SaveMovieMarathonValidator {
	public static void validateShowtimes(ArrayList<Showtime> showtimes) throws ValidationException {
		System.out.println("Showtimes size: "+showtimes.size());
	

		for (Showtime s : showtimes) {
			System.out.println("Usao u for petlju");
			if(s.getShowtimeId()==0)System.out.println("ID je 0");
			if(s.getMovieMarathon()==null) return;
			if (s.getMovieMarathon().getMarathonId() != 0) {
				System.out.println("Vec ima maraton");
				throw new ValidationException(
						"Odabrana projekcija se vec nalazi na nekom od sacuvanih filmskih maratona.");
			}
		}
	}
}
