package hexlet.code;

import java.util.Random;

public class Utils {
    public static final int LOWER_BOUNDARY = 1;
    public static final int UPPER_BOUNDARY = 100;

    public static int randomNumberFromInterval(int start, int end) {
        Random random = new Random();
        return random.nextInt(end - start) + start;
    }
}
