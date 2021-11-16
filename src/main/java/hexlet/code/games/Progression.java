package hexlet.code.games;

import java.util.Scanner;

import hexlet.code.Engine;
import hexlet.code.Utils;


public final class Progression {

    public static final int LOWER_SEQ_LENGTH = 5;
    public static final int UPPER_SEQ_LENGTH = 10;
    public static final int LOWER_SEQ_STEP = 2;
    public static final int UPPER_SEQ_STEP = 4;

    public static void startGame(Scanner sc, String userName) {
        int round = 0;

        System.out.println("What number is missing in the progression?");

        String[] operations = {"+", "+", "+"};
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

        int[] seq = buildSequence(operations);

        int hiddenElmIndex = Utils.randomNumberFromInterval(1, seq.length) - 1;
        for (int i = 0; i < seq.length; i++) {
            String tmp = hiddenElmIndex == i ? ".." : Integer.toString(seq[i]);
            if (i == 0) {
                result[0] = tmp;
            } else {
                result[0] = result[0] + " " + tmp;
            }
        }
        result[1] = Integer.toString(seq[hiddenElmIndex]);
        return result;
    }


    private static int[] buildSequence(String[] operations) {

        int seqOper = Utils.randomNumberFromInterval(0, operations.length);
        int seqStep = Utils.randomNumberFromInterval(LOWER_SEQ_STEP, UPPER_SEQ_STEP);
        int seqLength = Utils.randomNumberFromInterval(LOWER_SEQ_LENGTH, UPPER_SEQ_LENGTH);
        int seqStart = Utils.randomNumberFromInterval(Utils.LOWER_BOUNDARY, Utils.UPPER_BOUNDARY);

        int[] seq = new int[seqLength];

        seq[0] = seqStart;
        for (int i = 1; i < seqLength; i++) {
            switch (operations[seqOper]) {
                case "+":
                    seq[i] = seqStart + i * seqStep;
                    break;
                case "-":
                    seq[i] = seqStart - i * seqStep;
                    break;
                case "*":
                    seq[i] = seqStart * (int) Math.pow(seqStep, i);
                    break;
                default:
                    break;
            }
        }
        return seq;
    }
}

