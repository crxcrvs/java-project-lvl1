package hexlet.code.games;

import java.util.Scanner;

import hexlet.code.Engine;
import hexlet.code.Utils;

public final class Calc {

    public static void startGame(Scanner sc, String userName) {
        int round = 0;
        String[] operations = {"+", "-", "*"};

        System.out.println("What is the result of the expression?");

        String[] questions = new String[Engine.NUMBER_OF_SUCCSESFUL_ANSWERS];
        String[] answers = new String[Engine.NUMBER_OF_SUCCSESFUL_ANSWERS];

        do {
            String[] pairQA = buildQAPair(operations);
            questions[round] = pairQA[0];
            answers[round] = pairQA[1];
            round += 1;
        } while (round < Engine.NUMBER_OF_SUCCSESFUL_ANSWERS);

        Engine.startGame(questions, answers, userName, sc);

    }

    private static String[] buildQAPair(String[] operations) {
        String[] result = new String[2];

        int randomNumberA = Utils.randomNumberFromInterval(Utils.LOWER_BOUNDARY, Utils.UPPER_BOUNDARY);
        int randomNumberB = Utils.randomNumberFromInterval(Utils.LOWER_BOUNDARY, Utils.UPPER_BOUNDARY);
        int operation = Utils.randomNumberFromInterval(0, operations.length);

        result[0] = randomNumberA + " " + operations[operation] + " " + randomNumberB;

        switch (operations[operation]) {
            case "+":
                result[1] = Integer.toString(randomNumberA + randomNumberB);
                break;
            case "-":
                result[1] = Integer.toString(randomNumberA - randomNumberB);
                break;
            case "*":
                result[1] = Integer.toString(randomNumberA * randomNumberB);
                break;
            default:
                break;
        }
        return result;
    }
}
