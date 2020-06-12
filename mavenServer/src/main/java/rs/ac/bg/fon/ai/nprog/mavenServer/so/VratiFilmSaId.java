package rs.ac.bg.fon.ai.nprog.mavenServer.so;

import rs.ac.bg.fon.ai.nprog.mavenCommonLib.domain.Movie;

/**
*
* @author Ivona
*
* @version 1.0
*
* Klasa VratiFilmSaId predstavlja sistemsku operaciju koja vraca film sa
* zadatim id-ijem. Nasledjuje AbstractSystemOperation.
*/
public class VratiFilmSaId extends AbstractSystemOperation {

   /**
    * Film
    */
   Movie movie;
   /**
    * Id filma koji trazimo
    */
   int id;
   /**
    * Parametrizovani konstruktor klase VratiFilmSaId.
    * @param id koji zelimo da pronadjemo
    */
   public VratiFilmSaId(int id) {
       this.id = id;
   }

   /**
    * Metoda koja ucitava film iz baze.
    *
    * @throws Exception ako dodje do greske prilikom trazenja filma.
    */
   @Override
   protected void executeSpecificOperation() throws Exception {
       movie = (Movie) (Object) dbb.getDomainObjectByPrimaryKey(new Movie(), id);

   }

   /**
    * Metoda koja vraca film.
    *
    * @return trazeni film
    */
   public Movie getMovie() {
       return movie;
   }

}

