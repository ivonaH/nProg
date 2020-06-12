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

   public VratiFilmSaId(int id) {
       System.out.println("USAO U KONSTRUKTOR GET MOVIE WITH ID");
       this.id = id;
   }

   /**
    * Metoda koja ucitava film iz baze.
    *
    * @throws Exception ako dodje do greske prilikom trazenja filma.
    */
   @Override
   protected void executeSpecificOperation() throws Exception {
       System.out.println("USAO U SO");
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

