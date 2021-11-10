package hexlet.code.games;

import hexlet.code.Cli;
import hexlet.code.Engine;


public final class Progression {

    public static void startGame(Cli cli, String userName) {
        int round = 0;

        System.out.println("What number is missing in the progression?");

        String[] operations = {"+", "-", "*"};
        String[] questions = new String[Engine.NUMBER_OF_SUCCSESFUL_ANSWERS];
        String[] answers = new String[Engine.NUMBER_OF_SUCCSESFUL_ANSWERS];

        do {
            String[] pairQA = buildQAPair(operations);
            questions[round] = pairQA[0];
            answers[round] = pairQA[1];
            round += 1;
        } while (round < Engine.NUMBER_OF_SUCCSESFUL_ANSWERS);

        Engine.startGame(questions, answers, userName, cli);
    }

    private static String[] buildQAPair(String[] operations) {
        String[] result = new String[2];

        int[] seq = buildSequence(operations);

        int hiddenElmIndex = Engine.randomNumberFromInterval(1, seq.length) - 1;
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

        int seqOper = Engine.randomNumberFromInterval(0, Engine.NUMBER_OF_OPERATIONS);
        int seqStep = Engine.randomNumberFromInterval(Engine.LOWER_SEQ_STEP, Engine.UPPER_SEQ_STEP);
        int seqLength = Engine.randomNumberFromInterval(Engine.LOWER_SEQ_LENGTH, Engine.UPPER_SEQ_LENGTH);
        int seqStart = Engine.randomNumberFromInterval(Engine.LOWER_BOUNDARY, Engine.UPPER_BOUNDARY);

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

