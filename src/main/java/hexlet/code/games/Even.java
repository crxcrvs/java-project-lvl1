package hexlet.code.games;

import java.util.Scanner;

import hexlet.code.Engine;
import hexlet.code.Utils;

public final class Even {


    public static void startGame(Scanner sc, String userName) {
        int round = 0;

        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

        String[] questions = new String[Engine.NUMBER_OF_SUCCSESFUL_ANSWERS];
        String[] answers = new String[Engine.NUMBER_OF_SUCCSESFUL_ANSWERS];

        do {
            int random = Utils.randomNumberFromInterval(Utils.LOWER_BOUNDARY, Utils.UPPER_BOUNDARY);
            questions[round] = Integer.toString(random);
            answers[round] = isEven(questions[round]) ? "yes" : "no";
            round += 1;
        } while (round < Engine.NUMBER_OF_SUCCSESFUL_ANSWERS);

        Engine.startGame(questions, answers, userName, sc);
    }
    private static boolean isEven(String number) {
        return Integer.parseInt(number) % 2 == 0 ? true : false;
    }
}
