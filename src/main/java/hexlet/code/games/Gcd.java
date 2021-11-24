package hexlet.code.games;

import java.util.Scanner;

import hexlet.code.Engine;
import hexlet.code.Utils;

public final class Gcd {

    public static void startGame(Scanner sc, String userName) {

        String gameRule = "Find the greatest common divisor of given numbers.";

        String[] questions = new String[Engine.NUMBER_OF_SUCCSESFUL_ANSWERS];
        String[] answers = new String[Engine.NUMBER_OF_SUCCSESFUL_ANSWERS];

        for (int round = 0; round < Engine.NUMBER_OF_SUCCSESFUL_ANSWERS; round++) {

            int numberA = Utils.randomNumberFromInterval(Utils.LOWER_BOUNDARY, Utils.UPPER_BOUNDARY);
            int numberB = Utils.randomNumberFromInterval(Utils.LOWER_BOUNDARY, Utils.UPPER_BOUNDARY);

            questions[round] = numberA + " " + numberB;
            answers[round] = calcGCD(numberA, numberB);
        }

        Engine.startGame(questions, answers, userName, gameRule, sc);
    }

    private static String calcGCD(int numberA, int numberB) {
        int result = 1;

        for (int i = 1; i <= numberA && i <= numberB; i++) {
            if (numberA % i == 0  && numberB % i == 0) {
                result = i;
            }
        }
        return Integer.toString(result);
    }

}

