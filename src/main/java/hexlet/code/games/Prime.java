package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public final class Prime {
    private static final String GAMERULE = "Answer yes if given number is prime. Otherwise answer 'no'.";

    public static void startGame() {


        String[] questions = new String[Engine.NUMBER_OF_SUCCSESFUL_ANSWERS];
        String[] answers = new String[Engine.NUMBER_OF_SUCCSESFUL_ANSWERS];

        for (int round = 0; round < Engine.NUMBER_OF_SUCCSESFUL_ANSWERS; round++) {
            int tmp = Utils.randomNumberFromInterval(Utils.LOWER_BOUNDARY, Utils.UPPER_BOUNDARY);
            questions[round] = Integer.toString(tmp);
            answers[round] = isPrime(tmp) ? "yes" : "no";
        }

        Engine.startGame(questions, answers, GAMERULE);
    }
    private static boolean isPrime(int number) {
        if (number == 1) {
            return false;
        }
        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
