package hexlet.code.games;

import hexlet.code.Cli;
import hexlet.code.Engine;

public final class Even {


    public static void startGame(Cli cli, String userName) {
        int round = 0;

        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

        String[] questions = new String[Engine.NUMBER_OF_SUCCSESFUL_ANSWERS];
        String[] answers = new String[Engine.NUMBER_OF_SUCCSESFUL_ANSWERS];

        do {
            int random = Engine.randomNumberFromInterval(Engine.LOWER_BOUNDARY, Engine.UPPER_BOUNDARY);
            questions[round] = Integer.toString(random);
            answers[round] = isEven(questions[round]) ? "yes" : "no";
            round += 1;
        } while (round < Engine.NUMBER_OF_SUCCSESFUL_ANSWERS);

        Engine.startGame(questions, answers, userName, cli);
    }
    private static boolean isEven(String number) {
        return Integer.parseInt(number) % 2 == 0 ? true : false;
    }
}
