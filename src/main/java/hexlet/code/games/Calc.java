package hexlet.code.games;

import java.util.Scanner;

import hexlet.code.Engine;
import hexlet.code.Utils;

public final class Calc {

    private static final String[] OPERATIONS = {"+", "-", "*"};

    public static void startGame(Scanner sc, String userName) {

        String gameRule = "What is the result of the expression?";

        String[] questions = new String[Engine.NUMBER_OF_SUCCSESFUL_ANSWERS];
        String[] answers = new String[Engine.NUMBER_OF_SUCCSESFUL_ANSWERS];

        for (int round = 0; round < Engine.NUMBER_OF_SUCCSESFUL_ANSWERS; round++) {
            int numberA = Utils.randomNumberFromInterval(Utils.LOWER_BOUNDARY, Utils.UPPER_BOUNDARY);
            int numberB = Utils.randomNumberFromInterval(Utils.LOWER_BOUNDARY, Utils.UPPER_BOUNDARY);
            int operationIndex = Utils.randomNumberFromInterval(0, OPERATIONS.length);

            questions[round] = buildQuestion(numberA, numberB, OPERATIONS[operationIndex]);
            answers[round] = findAnswer(numberA, numberB, OPERATIONS[operationIndex]);
        }

        Engine.startGame(questions, answers, userName, gameRule, sc);

    }
    private static String findAnswer(int numberA, int numberB, String operation) {
        String result = "";
        switch (operation) {
            case "+":
                result = Integer.toString(numberA + numberB);
                break;
            case "-":
                result = Integer.toString(numberA - numberB);
                break;
            case "*":
                result = Integer.toString(numberA * numberB);
                break;
            default:
                break;
        }
        return result;

    }
    private static String buildQuestion(int numberA, int numberB, String operation) {
        return numberA + " " + operation + " " + numberB;
    }

}
