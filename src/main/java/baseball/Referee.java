package baseball;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Referee {
    public String judge(String inputNumber, String randomNumber) {
        String[] inputNumbers = inputNumber.split("");
        String[] randomNumbers = randomNumber.split("");

        StringBuilder sb = new StringBuilder();
        long[] strike = {0};

        IntStream.range(0,3).forEach(i -> {
            if (inputNumbers[i].equals(randomNumbers[i])) {
                strike[0]++;
            }
        });

        long count = Arrays.stream(inputNumbers)
                .filter(in -> Arrays.asList(randomNumbers).contains(in))
                .count();

        long ball = count - strike[0];

        if (ball != 0) {
            sb.append(ball + " ball ");
        }
        if (strike[0] != 0) {
            sb.append(strike[0] + " strike");
        }

        if (!sb.toString().equals("")) {
            return sb.toString().trim();
        }

        return "nothing";
    }
}
