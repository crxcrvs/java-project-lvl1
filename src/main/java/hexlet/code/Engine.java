package hexlet.code;

import java.util.Scanner;

public class Engine {

    public static final int NUMBER_OF_SUCCSESFUL_ANSWERS = 3;
    private static Scanner sc = new Scanner(System.in);

    public static void startGame(String[] questions, String[] answers, String gameRule) {

        System.out.println("Welcome to the Brain Games!");
        System.out.println("May I have your name?");
        String userName = sc.nextLine();
        System.out.println("Hello, " + userName + "!");
        System.out.println(gameRule);

        for (int round = 0; round < questions.length; round++) {
            System.out.println("Question: " + questions[round]);
            String userAnswer = sc.nextLine();
            if (userAnswer.equals(answers[round])) {
                System.out.println("Correct!");
            } else {
                String incorrectAnswer = buildIncorrectAnswer(userAnswer, answers[round], userName);
                System.out.println(incorrectAnswer);
                return;
            }
        }
        System.out.println("Congratulations, " + userName + "!\n");
        sc.close();
    }
    public static String buildIncorrectAnswer(String userAnswer, String correctAnswer, String userName) {
        String templ = "%s is wrong answer ;(. Correct answer was %s.\n";
        templ += "Let's try again, %s!";
        return String.format(templ, userAnswer, correctAnswer, userName);
    }
}
