/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ai.nprog.mavenServer.so;

import rs.ac.bg.fon.ai.nprog.mavenCommonLib.domain.DomainObject;
import rs.ac.bg.fon.ai.nprog.mavenCommonLib.domain.Showtime;
import rs.ac.bg.fon.ai.nprog.mavenCommonLib.exception.ValidationException;
import rs.ac.bg.fon.ai.nprog.mavenServer.validator.showtime.SaveShowtimeValidator;
import rs.ac.bg.fon.ai.nprog.mavenServer.validator.showtime.UpdateShowtimeValidator;

import java.util.List;

/**
 *
 * @author Ivona
 * 
 * @version 1.0
 * 
 *          Klasa IzmeniProjekciju predstavlja sistemsku operaciju koja omogucava izmenu podataka o projekciji
 *          u bazi. Nasledjuje AbstractSystemOperation.
 */
public class IzmeniProjekciju extends AbstractSystemOperation {
	/**
	 * Projekcija koju zelimo da izmenimo u bazi.
	 */
	Showtime showtime;

	/**
	 * Parametrizovani konstruktor metode izmeni projekciju.
	 * 
	 * @param object koji zelimo da izmenimo
	 * @throws Exception 
	 * <ul>
	 * <li>ako primljeni objekat nije instanca klase Showtime </li>
	 * <li> ako je sala zauzeta u tom terminu</li>
	 * <li> ako je nova sala premalog kapaciteta 
	 * (postoji vise rezervacija nego sto je kapacitet nove sale)</li>
	 * </ul>
	 */
	public IzmeniProjekciju(Object object) throws Exception {
		validate(object);
		this.showtime = (Showtime) object;
		validateShowtimeDetails();
	}

	/**
	 * Metoda kojom se azurira projekciju u bazi.
	 * 
	 * @throws Exception ako dodje do greske prilikom azuriranja projekcije.
	 */
	@Override
	protected void executeSpecificOperation() throws Exception {
		dbb.updateDomainObject(showtime);
	}

	/**
	 * Metoda koja vrsi validaciju da li je objekat instanca klase Showtime.
	 * 
	 * @param object Objekat za koji zelimo da proverimo da li je instanca klase
	 *               Showtime.
	 * @throws ValidationException ako objekat nije instanca klase Showtime.
	 * 
	 */
	protected void validate(Object object) throws Exception {
		if (!(object instanceof Showtime)) {
			throw new Exception("Objekat nije instanca klase Projekcija!");
		}
	}
	
	/**
	 * Metoda koja vrsi proveru da li je moguce sacuvati projekciju.
	 * @throws ValidationException moze da se dogodi u sledecim slucajevima:<ul>
	 * <li>Ako je sala zauzeta u tom terminu </li>
	 * <li>Ukoliko ima vise rezervacija nego sto je kapacitet nove sale koju pokusava da postavi </li>
	 *  </ul>
	 */
    protected void validateShowtimeDetails() throws ValidationException {
        try {
            SaveShowtimeValidator.validateShowtime(showtime);
            UpdateShowtimeValidator.checkNewHallCapacity(showtime);
        } catch (Exception ex) {
            throw new ValidationException(ex.getMessage());
        }
      
    }
}
