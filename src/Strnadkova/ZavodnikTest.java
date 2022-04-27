/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Strnadkova;

import javax.security.auth.kerberos.EncryptionKey;

/**
 *
 * @author lucka
 */
public class ZavodnikTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Zavodnik zavodnik = new Zavodnik("Lucie", "Strnadkova", 2002, 'F', "nemam");
        //System.out.println(zavodnik.getStavZavodnika());
        //zavodnik.setStartTime(0, 1, 20);
        //zavodnik.setFinishTime(1, 0, 0);
        //zavodnik.setStartTime("0:01:20");
        //zavodnik.setFinishTime("1:0:0");
        //zavodnik.getTime();
        //System.out.println(zavodnik.toString());
        
        //odchyceni vyjimky
        try {
            Zavod jiz50 = new Zavod("jiz50");
            jiz50.addCompetitor("Alice", "Mala", 1980, 'F', "SK Liberec");
            jiz50.addCompetitor("Bob", "Hruby", 1969, 'M', "SK Liberec");
            jiz50.addCompetitor("Cyril", "Drahy", 1991, 'F', "SK Jablonec");
            System.out.println(jiz50);
            //jiz50.setStartTimeAll(9, 0, 0, 2);
            System.out.println(jiz50);
            jiz50.setFinishTimeOf(1, 10, 0, 0);
            jiz50.setFinishTimeOf(2, 10, 10, 0);
            jiz50.setFinishTimeOf(3, 10, 1, 0);
            System.out.println(jiz50);
        } catch (StartTimeNotSet e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Chyba");
        }

    }

}
