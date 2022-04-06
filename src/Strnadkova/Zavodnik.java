/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Strnadkova;

import java.time.LocalDate;

public class Zavodnik {

    private String jmeno;
    private String prijmeni;
    private int rocnik;
    private int registracniCislo;
    private int startTime;
    private int finishTime;
    private int time;
    private char pohlavi;
    private static int pocitadlo = 1;
    private String stavZavodnika;
    private int vek;
    private String klub;

    public Zavodnik(String jmeno, String prijmeni, int rocnik, char pohlavi, String klub) {
        this.jmeno = jmeno;
        this.prijmeni = prijmeni;
        this.rocnik = rocnik;
        this.pohlavi = pohlavi;
        this.klub = klub;
        this.registracniCislo = pocitadlo;
        Zavodnik.pocitadlo++;
    }

    public String getKlub() {
        return klub;
    }

    public int getVek() {
        LocalDate current_date = LocalDate.now();
        int year = current_date.getYear();
        return vek = year - rocnik;
    }

    public int getRegistracniCislo() {
        return registracniCislo;
    }

    public String getJmeno() {
        return jmeno;
    }

    public String getPrijmeni() {
        return prijmeni;
    }

    public int getRocnik() {
        return rocnik;
    }

    public int getStartTime() {
        return startTime;
    }

    public int getFinishTime() {
        return finishTime;
    }

    public int getTime() {
        return time = TimeTools.timeCompare(startTime, finishTime);
    }

    public char getPohlavi() {
        return pohlavi;
    }

    public static int getPocitadlo() {
        return pocitadlo;
    }

    public String getStringTime() {
        return TimeTools.secondsToTime(time);
    }

    public String getStavZavodnika() {
        if (this.startTime == 0) {
            return this.stavZavodnika = "zavod nezahajen";
        } else if (this.startTime != 0 && this.finishTime == 0) {
            return this.stavZavodnika = "zavod neukoncen";
        } else {
            return this.stavZavodnika = "zavod ukoncen";
        }
    }

    public static Zavodnik getInstance(String jmeno, String prijmeni, int rocnik, char pohlavi, String klub) {
        return new Zavodnik(jmeno, prijmeni, rocnik, pohlavi, klub);
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public void setFinishTime(int finishTime) {
        this.finishTime = finishTime;
    }

    public void setStartTime(int hodiny, int minuty, int sekundy) {
        this.startTime = TimeTools.timeToSeconds(hodiny, minuty, sekundy);
    }

    public void setFinishTime(int hodiny, int minuty, int sekundy) {
        this.finishTime = TimeTools.timeToSeconds(hodiny, minuty, sekundy);
    }

    public void setStartTime(String time) {
        this.startTime = TimeTools.timeToSeconds(time);
    }

    public void setFinishTime(String time) {
        this.finishTime = TimeTools.timeToSeconds(time);
    }

}
