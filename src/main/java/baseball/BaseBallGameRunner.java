package baseball;

import java.util.Scanner;

public class BaseBallGameRunner {

    private Referee referee;

    public BaseBallGameRunner(Referee referee) {
        this.referee = referee;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String randomNumber = RandomNumberGenerator.generate();
        Referee referee = new Referee();
        start(scanner, randomNumber, referee);

    }

    private static void start(Scanner scanner, String randomNumber, Referee referee) {
        while(true){
            String inputNumber = InputView.ask(scanner);
            String result = referee.judge(inputNumber, randomNumber);
            System.out.println(result);
            if (isClear(scanner, result)) break;
        }
    }

    private static boolean isClear(Scanner scanner, String result) {
        return isEnd(scanner, result);
    }

    private static boolean isEnd(Scanner scanner, String result) {
        if (result.equals("3 strike")) {
            isCoinInserted(scanner);
            return true;
        }
        return false;
    }

    private static void isCoinInserted(Scanner scanner) {
        if (InputView.retry(scanner) == 1) {
            BaseBallGameRunner.main(null);
        }
    }

}
