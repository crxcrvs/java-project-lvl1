package hexlet.code;

import java.util.Random;

public class Engine {

    public static final int LOWER_BOUNDARY = 1;
    public static final int UPPER_BOUNDARY = 100;
    public static final int NUMBER_OF_SUCCSESFUL_ANSWERS = 3;
    public static final int NUMBER_OF_OPERATIONS = 3;
    public static final int LOWER_SEQ_LENGTH = 5;
    public static final int UPPER_SEQ_LENGTH = 10;
    public static final int LOWER_SEQ_STEP = 2;
    public static final int UPPER_SEQ_STEP = 4;

    public static void startGame(String[] questions, String[] answers, String userName, Cli cli) {
        StringBuilder sb = new StringBuilder();
        int round = 0;
        do {
            System.out.println("Question: " + questions[round]);
            String userAnswer = cli.getUserInputStr();
            if (userAnswer.equals(answers[round])) {
                System.out.println("Correct!");
            } else {
                sb.setLength(0);
                sb.append(userAnswer).append(" is wrong answer ;(. Correct answer was ");
                sb.append(answers[round]).append(".\n");
                sb.append("Let's try again, ").append(userName).append("!");
                System.out.println(sb.toString());
                return;
            }
            round += 1;
        } while (round < questions.length);
        System.out.println("Congratulations, " + userName + "!\n");
    }
    public static int randomNumberFromInterval(int start, int end) {
        Random random = new Random();
        return random.nextInt(end - start) + start;
    }
}
