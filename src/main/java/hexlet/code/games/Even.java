package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public final class Even {

    private static final String GAMERULE = "Answer 'yes' if the number is even, otherwise answer 'no'.";

    public static void startGame() {

        String[] questions = new String[Engine.NUMBER_OF_SUCCSESFUL_ANSWERS];
        String[] answers = new String[Engine.NUMBER_OF_SUCCSESFUL_ANSWERS];

        for (int round = 0; round < Engine.NUMBER_OF_SUCCSESFUL_ANSWERS; round++) {
            int random = Utils.randomNumberFromInterval(Utils.LOWER_BOUNDARY, Utils.UPPER_BOUNDARY);
            questions[round] = Integer.toString(random);
            answers[round] = isEven(random) ? "yes" : "no";
        }

        Engine.startGame(questions, answers, GAMERULE);
    }
    private static boolean isEven(int number) {
        return number % 2 == 0;
    }
}
