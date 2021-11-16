package hexlet.code.games;

import java.util.Scanner;

import hexlet.code.Engine;
import hexlet.code.Utils;

public final class Gcd {

    public static void startGame(Scanner sc, String userName) {
        int round = 0;

        System.out.println("Find the greatest common divisor of given numbers.");

        String[] questions = new String[Engine.NUMBER_OF_SUCCSESFUL_ANSWERS];
        String[] answers = new String[Engine.NUMBER_OF_SUCCSESFUL_ANSWERS];

        do {
            String[] pairQA = buildQAPair();
            questions[round] = pairQA[0];
            answers[round] = pairQA[1];
            round += 1;
        } while (round < Engine.NUMBER_OF_SUCCSESFUL_ANSWERS);

        Engine.startGame(questions, answers, userName, sc);
    }

    private static String[] buildQAPair() {
        String[] result = new String[2];

        int randomNumberA = Utils.randomNumberFromInterval(Utils.LOWER_BOUNDARY, Utils.UPPER_BOUNDARY);
        int randomNumberB = Utils.randomNumberFromInterval(Utils.LOWER_BOUNDARY, Utils.UPPER_BOUNDARY);
        result[0] = randomNumberA + " " + randomNumberB;
        result[1] = calcGCD(randomNumberA, randomNumberB);
        return result;
    }

    private static String calcGCD(int randomNumberA, int randomNumberB) {
        int result = 1;

        for (int i = 1; i <= randomNumberA && i <= randomNumberB; i++) {
            if (randomNumberA % i == 0  && randomNumberB % i == 0) {
                result = i;
            }
        }
        return Integer.toString(result);
    }

}

