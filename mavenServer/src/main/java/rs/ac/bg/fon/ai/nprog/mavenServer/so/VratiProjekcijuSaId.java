package rs.ac.bg.fon.ai.nprog.mavenServer.so;

import rs.ac.bg.fon.ai.nprog.mavenCommonLib.domain.Showtime;

/**
 *
 * @author Ivona
 *
 * @version 1.0
 *
 *          Klasa VratiProjekcijuSaId predstavlja sistemsku operaciju koja vraca
 *          projekciju sa zadatim id-ijem. Nasledjuje AbstractSystemOperation.
 */
public class VratiProjekcijuSaId extends AbstractSystemOperation {

	/**
	 * Projekcija
	 */
	Showtime showtime;
	/**
	 * Id projekcije koju trazimo
	 */
	int id;
/**
 * Parametrizovani konstruktor klase VratiProjekcijuSaId.
 * @param id koji zelimo da pronadjemo
 */
	public VratiProjekcijuSaId(int id) {
		this.id = id;
	}

	/**
	 * Metoda koja ucitava projekciju iz baze.
	 *
	 * @throws Exception ako dodje do greske prilikom trazenja projekcije.
	 */
	@Override
	protected void executeSpecificOperation() throws Exception {
		showtime = (Showtime) (Object) dbb.getDomainObjectByPrimaryKey(new Showtime(), id);

	}

	/**
	 * Metoda koja vraca projekciju.
	 *
	 * @return trazena projekcija
	 */
	public Showtime getShowtime() {
		return showtime;
	}

}
