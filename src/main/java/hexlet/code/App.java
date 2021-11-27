package hexlet.code;

import java.util.Scanner;

import hexlet.code.games.Calc;
import hexlet.code.games.Even;
import hexlet.code.games.Gcd;
import hexlet.code.games.Prime;
import hexlet.code.games.Progression;

public class App {
    public static final String EXIT = "0";
    public static final String GREET_USER = "1";
    public static final String EVEN = "2";
    public static final String CALC = "3";
    public static final String GCD = "4";
    public static final String PROG = "5";
    public static final String PRIME = "6";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        App.showInitialMenu();

        System.out.print("Your choice: ");
        String choice = sc.nextLine();

        switch (choice) {
            case App.GREET_USER:
                Cli.greetUser();
                break;
            case App.EXIT:
                break;
            case App.EVEN:
                Even.startGame();
                break;
            case App.CALC:
                Calc.startGame();
                break;
            case App.GCD:
                Gcd.startGame();
                break;
            case App.PROG:
                Progression.startGame();
                break;
            case App.PRIME:
                Prime.startGame();
                break;
            default:
                break;
        }

        sc.close();
    }

    public static void showInitialMenu() {
        System.out.println("Please enter the game number and press Enter.");
        System.out.println(GREET_USER + " - " + "Greet");
        System.out.println(EVEN + " - " + "Even");
        System.out.println(CALC + " - " + "Calculator");
        System.out.println(GCD + " - " + "Greatest Comon Divisor");
        System.out.println(PROG + " - " + "Progression");
        System.out.println(PRIME + " - " + "Prime");
        System.out.println(EXIT + " - " + "Exit");
    }
}
