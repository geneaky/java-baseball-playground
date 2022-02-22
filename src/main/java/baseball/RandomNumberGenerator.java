package baseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RandomNumberGenerator {

    public static String generate() {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9));
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        for(int i = 0 ; i < 3; i++) {
            Integer number = numbers.get(random.nextInt(numbers.size() - 1));
            sb.append(number);
            numbers.remove(number);
        }

        return sb.toString();
    }

}
