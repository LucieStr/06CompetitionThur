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
    //private String stavZavodnika; meni se to, neni potreba davat do promenne
    //private int vek; //muze byt atribut, ale musi byt nekde metoda, ktera ho bude pocitat
    private String klub;

    public Zavodnik(String jmeno, String prijmeni, int rocnik, char pohlavi, String klub) { //klub muze byt jako setter, aby se pripadne dal nastavit
        this.jmeno = jmeno;
        this.prijmeni = prijmeni;
        this.rocnik = rocnik;
        this.pohlavi = pohlavi;
        this.klub = klub;
        this.registracniCislo = pocitadlo;
        Zavodnik.pocitadlo++;
    }

    //kopie zavodnika, muzeme taky pouzit metodu clone()
    public Zavodnik(Zavodnik z) {
        this.jmeno = z.jmeno;
        this.prijmeni = z.prijmeni;
        this.rocnik = z.rocnik;
        this.pohlavi = z.pohlavi;
        this.klub = z.klub;
        this.registracniCislo = z.registracniCislo;
    }

    public String getKlub() {
        return klub;
    }

    public int getVek() {
        LocalDate current_date = LocalDate.now(); // tovarni metoda, vytvoreni dnesniho datumu
        int year = current_date.getYear();    // getYear, vrati rok z datumu
        return year - rocnik; //bez vek, neni to potreba prirazovat do promenne vek
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
        if (getStavZavodnika() == StavZavodnika.UKONCEN) {
            time = TimeTools.timeCompare(startTime, finishTime);
        }
        return time;
    }

    public char getPohlavi() {
        return pohlavi;
    }

    public String getStringTime() {
        return TimeTools.secondsToTime(time);
    }

    public StavZavodnika getStavZavodnika() { // enum 
        if (this.startTime == 0) {
            return StavZavodnika.NEZAHAJEN; //"zavod nezahajen"
        } else if (this.startTime != 0 && this.finishTime == 0) {
            return StavZavodnika.NEUKONCEN; //"zavod neukoncen"
        } else {
            return StavZavodnika.UKONCEN; //"zavod ukoncen" 
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

    public String toString() {
        return String.format("%5d %10s %10s %5d %4s %10s %10s %10s", this.registracniCislo, this.jmeno, this.prijmeni, this.getVek(), this.pohlavi, TimeTools.secondsToTime(this.startTime), TimeTools.secondsToTime(this.finishTime), TimeTools.secondsToTime(this.getTime()));
    }
}
