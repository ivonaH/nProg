package rs.ac.bg.fon.ai.nprog.mavenServer.so;

import rs.ac.bg.fon.ai.nprog.mavenCommonLib.domain.Showtime;

/**
*
* @author Ivona
*
* @version 1.0
*
* Klasa VratiProjekcijuSaId predstavlja sistemsku operaciju koja vraca projekciju sa
* zadatim id-ijem. Nasledjuje AbstractSystemOperation.
*/
public class VratiProjekcijuSaId extends AbstractSystemOperation {

   /**
    * Projekcija
    */
Showtime showtime;    /**
    * Id projekcije koju trazimo
    */
   int id;

   public VratiProjekcijuSaId(int id) {
       System.out.println("USAO U KONSTRUKTOR GET MOVIE WITH ID");
       this.id = id;
   }

   /**
    * Metoda koja ucitava projekciju iz baze.
    *
    * @throws Exception ako dodje do greske prilikom trazenja projekcije.
    */
   @Override
   protected void executeSpecificOperation() throws Exception {
       System.out.println("USAO U SO");
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

