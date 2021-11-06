package hexlet.code;

import java.util.Scanner;

public class Cli {

    public static void greetUser() {
        System.out.println("May I have your name?");
        Scanner sc = new Scanner(System.in);
        String userName = sc.nextLine();
        System.out.println("Hello, " + userName + "!");
        sc.close();
    }

}
