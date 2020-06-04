package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class RandomHelper {
    public static String getRandomNumber() {
        int random = (int) (Math.random() * (1000 - 1)) + 1;
        return new SimpleDateFormat("ddMMyyHHmmssSSS").format(new Date()) + random;
    }
}
