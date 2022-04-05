/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Strnadkova;

/**
 *
 * @author lucka
 */
public class ZavodnikTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Zavodnik zavodnik = new Zavodnik("Lucie", "Strnadkova", 2002, 'z');
        System.out.println(zavodnik.getJmeno()+" " + zavodnik.getPrijmeni()+" " + zavodnik.getRocnik()+" " + zavodnik.getPohlavi());
        System.out.println(zavodnik.getStavZavodnika());
        zavodnik.setStartTime(0, 1, 20);
        System.out.println(zavodnik.getStartTime());
        System.out.println(zavodnik.getStavZavodnika());
        zavodnik.setFinishTime(1, 0, 0);
        System.out.println(zavodnik.getFinishTime());
        System.out.println(zavodnik.getTime());
        zavodnik.setStartTime("0:01:20");
        zavodnik.setFinishTime("1:0:0");
        zavodnik.getTime();
        System.out.println("Celkovy cas zavodnika je: "+ zavodnik.getStringTime());
        System.out.println(zavodnik.getStavZavodnika());
        
    }
    
}
