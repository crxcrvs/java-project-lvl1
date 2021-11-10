package hexlet.code;

import java.util.Scanner;

public final class Cli {
    private final Scanner sc = new Scanner(System.in);

    public String getUserInputStr() {
        return sc.nextLine();
    }
    public void finalize() {
        sc.close();
    }
    public void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
