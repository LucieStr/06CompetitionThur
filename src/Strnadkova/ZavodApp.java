package Strnadkova;

import java.time.LocalDate;
import java.util.Scanner;

public class ZavodApp {

    public static Scanner sc = new Scanner(System.in);
    private static Zavod zavod;

    public static void main(String[] args) {
        System.out.println("Zadej jmeno zavodu");
        zavod = new Zavod(sc.next());
        boolean end = false;
        do {
            displayMenu();
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    addCompetion();
                    break;
                case 2:
                    addCompetitors();
                    break;
                case 3:
                    setStartTime();
                    break;
                case 4:
                    setFinishTime();
                    break;
                case 5:
                    displayCompetitors();
                    break;
                case 6:
                    result();
                    break;
                case 0:
                    System.out.println("konec");
                    end = true;
                    break;
                default:
                    System.out.println("Neplatna volba");
            }
        } while (!end);
    }

    private static void displayMenu() {
        System.out.println("1 - Vytvorit novy zavod");
        System.out.println("2 - Registrace zavodnika");
        System.out.println("3 - Startovaci cas");
        System.out.println("4 - Cas v cili");
        System.out.println("5 - Startovaci listina");
        System.out.println("6 - Vysledky");
        System.out.println("0 - konec");
    }

    public static void addCompetitors() {
        LocalDate current_date = LocalDate.now();
        String name;
        String surname;
        int year;
        char gender;
        String club;
        while (true) {
            System.out.println("Jmeno:");
            name = sc.next();
            System.out.println("Prijmeni");
            surname = sc.next();
            System.out.println("Rocnik");
            year = sc.nextInt();
            if(year > current_date.getYear()){
                throw new IllegalArgumentException("tento rok jeste nebyl");
            }
            System.out.println("Pohlavi");            
            gender = sc.next().toUpperCase().charAt(0);
            if(gender != 'Z' || gender != 'M'){
                throw new IllegalArgumentException("pohlavi zadano spatne");
            }
            System.out.println("Klub");
            club = sc.next();
            zavod.addCompetitor(name, surname, year, gender, club);
            System.out.println("Chcete pokracovat? a/n");
            if (sc.next().toLowerCase().charAt(0) == 'n') {
                break;
            }
        }
    }

    private static void addCompetion() {
        System.out.println("Zadejte jmeno zavodu");
        zavod = new Zavod(sc.next());
        System.out.println("Zavod byl vytvoren");
    }

    private static void setStartTime() {
        System.out.println("Zadejte cas rozestupu mezi zavodniky");
        int offSetTime = sc.nextInt();
        System.out.println("Zadejte cas startu zavodu v hodinach, minutach a sekundach");
        zavod.setStartTimeAll(sc.nextInt(), sc.nextInt(), sc.nextInt(), offSetTime);
    }

    private static void setFinishTime() {
        while (true) {
            System.out.println("Zadejte registracni cislo zavodnika");
            int registrationNumber = sc.nextInt();
            System.out.println("Zadejte cilovy cas");
            zavod.setFinishTimeOf(registrationNumber, sc.nextInt(), sc.nextInt(), sc.nextInt());
            System.out.println("Chcete pokracovat a/n");
            if (sc.next().toLowerCase().charAt(0) == 'n') {
                break;
            }
        }
    }

    private static void displayCompetitors() {
        System.out.println(zavod);
    }

    private static void result() {
        zavod.sortByTime();
        System.out.println(zavod);
    }
}
