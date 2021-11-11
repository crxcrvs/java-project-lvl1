package hexlet.code;

import java.util.Scanner;

public final class Cli {
    private final Scanner sc = new Scanner(System.in);

    public String getUserInputStr() {
        return sc.nextLine();
    }
}
