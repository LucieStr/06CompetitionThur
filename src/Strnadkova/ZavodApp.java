package Strnadkova;

import java.util.Scanner;

public class ZavodApp {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Zavod zavod = new Zavod("Jizerska 50");
        boolean end = false;
        do {
            displayMenu();
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    addCompetitors();
                    break;
                case 2:
                    zavod.displayComp();
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
        System.out.println("1 - pridani zavodnika");
        System.out.println("2 - zobrazit zavodniky");
        System.out.println("0 - konec");
    }

    public void addCompetitors(int number) {
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
    }
}
