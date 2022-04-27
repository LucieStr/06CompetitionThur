/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Strnadkova;

import java.time.LocalDate;

public class Zavodnik implements Comparable<Zavodnik> { //porovnavame zavodnika se zavodnikem

    private String jmeno;
    private String prijmeni;
    private int rocnik;
    private int registracniCislo;
    private Date startTime;
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
        this.klub = checkClub(klub);
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
        this.startTime = z.startTime;
        this.finishTime = z.finishTime;
        this.time = z.time; //  z.getTime()
    }
//regularni vyraz

    private String checkClub(String club) { //Sokol So Sooooo
        if (!club.matches("[A-Z][a-z]+")) { //jeden znak == [] [abs] == a nebo b nebo s 
            throw new IllegalArgumentException("Spatne zadany nazev klubu. Klub zacina velkym pismenem a ma 1 a vice dalsich pismen.");
        }
        return club;
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
        return startTime.getTime();
    }

    public int getFinishTime() {
        return finishTime;
    }

    public int getTime() {
        if (getStavZavodnika() == StavZavodnika.UKONCEN) {
            time = TimeTools.timeCompare(startTime.getTime(), finishTime);
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
        if (startTime == null) {
//if (this.startTime == 0) {
            return StavZavodnika.NEZAHAJEN; //"zavod nezahajen"
        } else if (this.startTime != null && this.finishTime == 0) {
            return StavZavodnika.NEUKONCEN; //"zavod neukoncen"
        } else {
            return StavZavodnika.UKONCEN; //"zavod ukoncen" 
        }
    }

    public static Zavodnik getInstance(String jmeno, String prijmeni, int rocnik, char pohlavi, String klub) {
        return new Zavodnik(jmeno, prijmeni, rocnik, pohlavi, klub);
    }

    public void setStartTime(int startTime) {
        //this.startTime = startTime;
        this.startTime = new Date(startTime);
    }

    public void setFinishTime(int finishTime) {
        if (startTime == null) {
            throw new StartTimeNotSet("Nebyl nastaven cas startu, nelze nastavit cas v cili.");
        }
        this.finishTime = finishTime;
        getTime();
    }

    public void setStartTime(int hodiny, int minuty, int sekundy) {
        startTime.timeToSeconds(hodiny, minuty, sekundy);
    }

    public void setFinishTime(int hodiny, int minuty, int sekundy) {
        if (startTime == null) {
            throw new StartTimeNotSet("Nebyl nastaven cas startu, nelze nastavit cas v cili.");
        }
        this.finishTime = TimeTools.timeToSeconds(hodiny, minuty, sekundy);
        getTime();
    }

    public void setStartTime(String time) {
        startTime.timeToSeconds(time);
    }

    public void setFinishTime(String time) {
        if (startTime == null) {
            throw new StartTimeNotSet("Nebyl nastaven cas startu, nelze nastavit cas v cili.");
        }
        this.finishTime = TimeTools.timeToSeconds(time);
        getTime();
    }

    public String toString() {
        return String.format("%5d %10s %10s %5d %4s %10s %10s %10s", this.registracniCislo, this.jmeno, this.prijmeni, this.getVek(), this.pohlavi, this.startTime.secondsToTime(time), TimeTools.secondsToTime(this.finishTime), TimeTools.secondsToTime(this.getTime()));
    }

    @Override
    public int compareTo(Zavodnik o) {
        if (this.getTime() < o.getTime()) {
            return -1;
        } else if (this.getTime() > o.getTime()) {
            return 1;
        } else {
            return 0;
        }
    }   // nebo jen return this.getTime() - o.getTime() 
}
