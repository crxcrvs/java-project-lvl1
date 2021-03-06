package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;


public final class Progression {

    public static final int LOWER_SEQ_LENGTH = 5;
    public static final int UPPER_SEQ_LENGTH = 10;
    public static final int LOWER_SEQ_STEP = 2;
    public static final int UPPER_SEQ_STEP = 4;

    private static final String GAMERULE = "What number is missing in the progression?";

    public static void startGame() {

        String[] questions = new String[Engine.NUMBER_OF_SUCCSESFUL_ANSWERS];
        String[] answers = new String[Engine.NUMBER_OF_SUCCSESFUL_ANSWERS];

        for (int round = 0; round < Engine.NUMBER_OF_SUCCSESFUL_ANSWERS; round++) {

            int seqStep = Utils.randomNumberFromInterval(LOWER_SEQ_STEP, UPPER_SEQ_STEP);
            int seqLength = Utils.randomNumberFromInterval(LOWER_SEQ_LENGTH, UPPER_SEQ_LENGTH);
            int seqStart = Utils.randomNumberFromInterval(Utils.LOWER_BOUNDARY, Utils.UPPER_BOUNDARY);

            int[] seq = buildSequence(seqStep, seqLength, seqStart);

            int hiddenElmIndex = Utils.randomNumberFromInterval(1, seq.length) - 1;

            questions[round] = buildQuestion(seq, hiddenElmIndex);
            answers[round] = Integer.toString(seq[hiddenElmIndex]);
        }

        Engine.startGame(questions, answers, GAMERULE);
    }
    private static String buildQuestion(int[] sequence, int hiddenElmIndex) {
        String result = "";
        for (int i = 0; i < sequence.length; i++) {
            String tmp = hiddenElmIndex == i ? ".." : Integer.toString(sequence[i]);
            if (i == 0) {
                result = tmp;
            } else {
                result = result + " " + tmp;
            }
        }
        return result;

    }

    private static int[] buildSequence(int seqStep, int seqLength, int seqStart) {

        int[] seq = new int[seqLength];

        seq[0] = seqStart;
        for (int i = 1; i < seqLength; i++) {
            seq[i] = seqStart + i * seqStep;
        }
        return seq;
    }
}

