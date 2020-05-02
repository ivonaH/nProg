/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ai.nprog.mavenCommonLib.util;

import java.io.Serializable;

/**
 *
 * @author Ivona
 */
public interface Operation extends Serializable {

    public static final int OPERATION_NADJI_RADNIKA = 1;
    public static final int OPERATION_VRATI_SALE = 2;
    public static final int OPERATION_VRATI_FILMOVE = 3;
    public static final int OPERATION_VRATI_FILMSKE_MARATONE = 4;
    public static final int OPERATION_VRATI_REZERVACIJE = 5;
    public static final int OPERATION_VRATI_FILMOVE_PO_KRITERIJUMU = 6;
    public static final int OPERATION_VRATI_PROJEKCIJE_PO_KRITERIJUMU = 7;
    public static final int OPERATION_VRATI_FILMSKE_MARATONE_PO_KRITERIJUMU = 8;
    public static final int OPERATION_VRATI_REZERVACIJE_PO_KRITERIJUMU = 9;
    public static final int OPERATION_KREIRAJ_FILM = 10;
    public static final int OPERATION_KREIRAJ_REZERVACIJU = 11;
    public static final int OPERATION_KREIRAJ_PROJEKCIJU = 12;
    public static final int OPERATION_OBRISI_REZERVACIJU = 13;
    public static final int OPERATION_OBRISI_PROJEKCIJU = 14;
    public static final int OPERATION_IZMENI_PROJEKCIJU = 15;
    public static final int OPERATION_KREIRAJ_MARATON = 16;
    public static final int OPERATION_LOGOUT=17;

}
