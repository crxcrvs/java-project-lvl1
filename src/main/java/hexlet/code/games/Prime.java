package hexlet.code.games;

import hexlet.code.Cli;
import hexlet.code.Engine;

public final class Prime {

    public static void startGame(Cli cli, String userName) {
        int round = 0;

        System.out.println("Answer yes if given number is prime. Otherwise answer 'no'.");

        String[] questions = new String[Engine.NUMBER_OF_SUCCSESFUL_ANSWERS];
        String[] answers = new String[Engine.NUMBER_OF_SUCCSESFUL_ANSWERS];

        do {
            int tmp = Engine.randomNumberFromInterval(Engine.LOWER_BOUNDARY, Engine.UPPER_BOUNDARY);
            questions[round] = Integer.toString(tmp);
            answers[round] = isPrime(tmp) ? "yes" : "no";
            round += 1;
        } while (round < Engine.NUMBER_OF_SUCCSESFUL_ANSWERS);

        Engine.startGame(questions, answers, userName, cli);
    }
    private static boolean isPrime(int number) {
        for (int i = 2; i < number / 2; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
