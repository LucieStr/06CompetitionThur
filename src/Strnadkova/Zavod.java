/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Strnadkova;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author lucka
 */
public class Zavod {

    private Scanner sc = new Scanner(System.in);

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
    /*public void addCompetitors(int number) { // bude spise v uzivatelskem rozhrani
        String name;
        String surname;
        int year;
        char gender;
        String club;
        int prevComp = nCompetitors;
        for (int i = prevComp; i < number; i++) {
            if (i == competitors.length) {
                extendArray();
            }
            System.out.println("Jmeno:");
            name = sc.next();
            System.out.println("Prijmeni");
            surname = sc.next();
            System.out.println("Rocnik");
            year = sc.nextInt();
            System.out.println("Pohlavi");
            gender = sc.next().charAt(0);
            System.out.println("Klub");
            club = sc.next();
            this.competitors[i] = Zavodnik.getInstance(name, surname, year, gender, club);
            nCompetitors++;
        }
    }*/

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
    
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (Zavodnik competitor : competitors) {
            sb.append(competitor).append("/n");
        }
        return sb.toString();
    }
    
    
}
