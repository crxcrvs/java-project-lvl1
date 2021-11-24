package hexlet.code.games;

import java.util.Scanner;

import hexlet.code.Engine;
import hexlet.code.Utils;

public final class Even {


    public static void startGame(Scanner sc, String userName) {

        String gameRule = "Answer 'yes' if the number is even, otherwise answer 'no'.";

        String[] questions = new String[Engine.NUMBER_OF_SUCCSESFUL_ANSWERS];
        String[] answers = new String[Engine.NUMBER_OF_SUCCSESFUL_ANSWERS];

        for (int round = 0; round < Engine.NUMBER_OF_SUCCSESFUL_ANSWERS; round++) {
            int random = Utils.randomNumberFromInterval(Utils.LOWER_BOUNDARY, Utils.UPPER_BOUNDARY);
            questions[round] = Integer.toString(random);
            answers[round] = isEven(random) ? "yes" : "no";
        }

        Engine.startGame(questions, answers, userName, gameRule, sc);
    }
    private static boolean isEven(int number) {
        return number % 2 == 0;
    }
}
