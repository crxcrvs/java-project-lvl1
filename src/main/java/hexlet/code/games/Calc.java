package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public final class Calc {

    private static final String[] OPERATIONS = {"+", "-", "*"};
    private static final String GAMERULE = "What is the result of the expression?";

    public static void startGame() {

        String[] questions = new String[Engine.NUMBER_OF_SUCCSESFUL_ANSWERS];
        String[] answers = new String[Engine.NUMBER_OF_SUCCSESFUL_ANSWERS];

        for (int round = 0; round < Engine.NUMBER_OF_SUCCSESFUL_ANSWERS; round++) {
            int numberA = Utils.randomNumberFromInterval(Utils.LOWER_BOUNDARY, Utils.UPPER_BOUNDARY);
            int numberB = Utils.randomNumberFromInterval(Utils.LOWER_BOUNDARY, Utils.UPPER_BOUNDARY);
            int operationIndex = Utils.randomNumberFromInterval(0, OPERATIONS.length);

            questions[round] = buildQuestion(numberA, numberB, OPERATIONS[operationIndex]);
            answers[round] = findAnswer(numberA, numberB, OPERATIONS[operationIndex]);
        }

        Engine.startGame(questions, answers, GAMERULE);

    }
    private static String findAnswer(int numberA, int numberB, String operation) {
        switch (operation) {
            case "+":
                return Integer.toString(numberA + numberB);
            case "-":
                return Integer.toString(numberA - numberB);
            case "*":
                return Integer.toString(numberA * numberB);
            default:
                return "";
        }
    }
    private static String buildQuestion(int numberA, int numberB, String operation) {
        return numberA + " " + operation + " " + numberB;
    }

}
