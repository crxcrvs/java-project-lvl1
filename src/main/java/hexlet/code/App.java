package hexlet.code;

import hexlet.code.games.Calc;
import hexlet.code.games.Even;
import hexlet.code.games.Gcd;
import hexlet.code.games.Prime;
import hexlet.code.games.Progression;

public class App {
    public static final int EXIT = 0;
    public static final int GREET_USER = 1;
    public static final int EVEN = 2;
    public static final int CALC = 3;
    public static final int GCD = 4;
    public static final int PROG = 5;
    public static final int PRIME = 6;

    public static void main(String[] args) {
        Cli cli = new Cli();
        String userName = "";

        showInitialMenu();
        try {
            int choice = Integer.parseInt(cli.getUserInputStr());
            switch (choice) {
                case GREET_USER:
                    userName = greetUser(cli);
                    break;
                case EXIT:
                    break;
                case App.EVEN:
                    if (userName == "") {
                        userName = greetUser(cli);
                    }
                    Even.startGame(cli, userName);
                    break;
                case App.CALC:
                    if (userName == "") {
                        userName = greetUser(cli);
                    }
                    Calc.startGame(cli, userName);
                    break;
                case App.GCD:
                    if (userName == "") {
                        userName = greetUser(cli);
                    }
                    Gcd.startGame(cli, userName);
                    break;
                case App.PROG:
                    if (userName == "") {
                        userName = greetUser(cli);
                    }
                    Progression.startGame(cli, userName);
                    break;
                case App.PRIME:
                    if (userName == "") {
                        userName = greetUser(cli);
                    }
                    Prime.startGame(cli, userName);
                    break;
                default:
                    break;
            }
        } catch (Exception e) {
            System.out.println(informOnIncorrectInput());
        }
    }
    public static String informOnIncorrectInput() {
        return "Please enter valid number!";
    }
    public static String greetUser(Cli cli) {
        System.out.println("Welcome to the Brain Games!");
        System.out.println("May I have your name?");
        String userName = cli.getUserInputStr();
        System.out.println("Hello, " + userName + "!");
        return userName;
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
        System.out.print("Your choice: ");
    }
}
