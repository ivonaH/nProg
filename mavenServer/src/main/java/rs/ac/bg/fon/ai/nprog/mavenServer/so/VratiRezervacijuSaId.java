package rs.ac.bg.fon.ai.nprog.mavenServer.so;

import rs.ac.bg.fon.ai.nprog.mavenCommonLib.domain.Reservation;

/**
 *
 * @author Ivona
 *
 * @version 1.0
 *
 *          Klasa VratiRezervacijuSaId predstavlja sistemsku operaciju koja
 *          vraca rezervaciju sa zadatim id-ijem. Nasledjuje
 *          AbstractSystemOperation.
 */
public class VratiRezervacijuSaId extends AbstractSystemOperation {

	/**
	 * Rezervacija
	 */
	Reservation reservation;
	/**
	 * Id rezervacije koju trazimo
	 */
	int id;
	/**
	 * Parametrizovani konstruktor klase VratiRezervacijuSaId.
	 * @param id koji zelimo da pronadjemo
	 */
	public VratiRezervacijuSaId(int id) {
		this.id = id;
	}

	/**
	 * Metoda koja pronalazi rezervaciju u bazi.
	 *
	 * @throws Exception ako dodje do greske prilikom trazenja rezervacije.
	 */
	@Override
	protected void executeSpecificOperation() throws Exception {
		reservation = (Reservation) (Object) dbb.getDomainObjectByPrimaryKey(new Reservation(), id);

	}

	/**
	 * Metoda koja vraca rezervaciju.
	 *
	 * @return trazena rezervacija
	 */
	public Reservation getReservation() {
		return reservation;
	}

}
