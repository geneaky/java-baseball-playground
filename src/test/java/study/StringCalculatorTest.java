package study;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringCalculatorTest {

  /*
  * 사용자가 입력한 문자열 값에 따라 사칙연산을 수행할 수 있는 계산기를 구현해야 한다.
  * 문자열 계산기는 사칙연산의 계산 우선순위가 아닌 입력 값에 따라 계산 순서가 결정된다.
  * 즉, 수학에서는 곱셈, 나눗셈이 덧셈, 뺄셈 보다 먼저 계산해야 하지만 이를 무시한다.
  * 예를 들어 "2 + 3 * 4 / 2"와 같은 문자열을 입력할 경우 2 + 3 * 4 / 2 실행 결과인 10을 출력해야 한다.
  */

  @Test
  public void nothing() throws Exception {
  }

  @Test
  public void 문자_한개_숫자로_변환() throws Exception {
      //given
      String input = "2";
      //when
      int number = Integer.parseInt(input);
      //then
      assertThat(number).isEqualTo(2);
  }

  @Test
  public void 문자열_배열로_저장() throws Exception {
      //given
      String input = "2 + 2";
      String[] inputs = input.split(" ");
      //when
      //then
      assertThat(inputs.length).isEqualTo(3);
      assertThat(inputs).containsExactly("2","+","2");
  }
}
