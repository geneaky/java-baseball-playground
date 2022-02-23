package baseball;

import java.util.Scanner;

public class InputView {

    public static String ask(Scanner scanner) {
        System.out.println("숫자를 입력해 주세요 : ");
        return scanner.next();
    }

    public static int retry(Scanner scanner) {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
        return scanner.nextInt();
    }
}
