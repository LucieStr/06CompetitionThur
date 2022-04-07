package Strnadkova;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.NoSuchElementException;

public class Zavod {

    //data
    private String name;
    private ArrayList<Zavodnik> competitors; //
    //private int nCompetitors = 0;

    //konstruktor
    public Zavod(String name) {
        this.name = name;
        this.competitors = new ArrayList<>();
    }

    //gettery
    public String getName() {
        return name;
    }

    public ArrayList<Zavodnik> getCompetitors() { // defensive deep copy
        ArrayList<Zavodnik> copy = new ArrayList<>();
        for (Zavodnik zavodnik : competitors) { // musime prochazet puvodni pole
            //copy.add(zavodnik); // vyrobilo by nove pole, ale ukozovalo na stejne objekty
            copy.add(new Zavodnik(zavodnik));
        }
        return copy;
    }

    public int getnCompetitors() {
        return competitors.size();
    }

    //methods
    public void addCompetitor(String name, String surname, int year, char gender, String club) {
        competitors.add(Zavodnik.getInstance(name, surname, year, gender, club));
    }

    public Zavodnik findFastest() {
        int fastestTime = Integer.MAX_VALUE;
        int fastesIndex = -1;
        for (int i = 0; i < competitors.size(); i++) {
            if (competitors.get(i).getTime() < fastestTime) {
                fastestTime = competitors.get(i).getTime();
                fastesIndex = i;
            }
        }
        return new Zavodnik(competitors.get(fastesIndex)); // posilam spravne data, ale data nejsou navazane
    }

    public int findFastestNumber() {
        int fastestTime = Integer.MAX_VALUE;
        int fastest = -1;
        for (int i = 0; i < competitors.size(); i++) {
            if (competitors.get(i).getTime() < fastestTime) {
                fastestTime = competitors.get(i).getTime();
                fastest = competitors.get(i).getRegistracniCislo();
            }
        }
        return fastest;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Zavodnik competitor : competitors) {
            sb.append(competitor).append("\n");
        }
        return sb.toString();
    }

    //metody ktere nastavy cas
    public void setStartTimeAll(int hours, int minutes, int seconds) {
        for (Zavodnik competitor : competitors) {
            competitor.setStartTime(hours, minutes, seconds);
        }
    }

    public void setStartTimeAll(int hours, int minutes, int seconds, int offsetInMinutes) {
        for (int i = 0; i < competitors.size(); i++) {
            competitors.get(i).setStartTime(hours, minutes + i * offsetInMinutes, seconds);

        }
    }

    public void setFinishTimeOf(int registrationNumber, int hours, int minutes, int seconds) {
        Zavodnik z = findByRegistrationNumber(registrationNumber);
        z.setFinishTime(hours, minutes, seconds);
    }

    private Zavodnik findByRegistrationNumber(int registrationNumber) {
        for (Zavodnik competitor : competitors) {
            if (competitor.getRegistracniCislo() == registrationNumber) {
                return competitor;
            }
        }
        throw new NoSuchElementException("Zavodnik s cislem " + registrationNumber + " neexistuje.");
    }

    public void sortByTime() { //aby arrayList setridil podle toho jak rychle bezci bezeli
        Collections.sort(competitors);
    }

    public void sortBySurname() {
        Comparator cbp = new ComparatorZavodnikBySurname(); 
        Collections.sort(competitors, cbp);
    }
}
