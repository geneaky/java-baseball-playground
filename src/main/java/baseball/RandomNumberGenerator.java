package baseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RandomNumberGenerator {

    public static String generate() {
        List<Integer> numbers = new ArrayList<>();
        for(int i = 1; i <= 9; i++) {
            numbers.add(i);
        }
        StringBuilder sb = new StringBuilder();
        Random random = new Random();

        for(int i = 0 ; i < 3; i++) {
            Integer number = numbers.get(random.nextInt(numbers.size() - 1));
            sb.append(number);
            numbers.remove(number);
        }
        return sb.toString();
    }

}
