package study;

import static org.assertj.core.api.Assertions.*;

import java.util.LinkedList;
import java.util.Queue;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class StringCalculatorTest {

  /*
  * 사용자가 입력한 문자열 값에 따라 사칙연산을 수행할 수 있는 계산기를 구현해야 한다.
  * 문자열 계산기는 사칙연산의 계산 우선순위가 아닌 입력 값에 따라 계산 순서가 결정된다.
  * 즉, 수학에서는 곱셈, 나눗셈이 덧셈, 뺄셈 보다 먼저 계산해야 하지만 이를 무시한다.
  * 예를 들어 "2 + 3 * 4 / 2"와 같은 문자열을 입력할 경우 2 + 3 * 4 / 2 실행 결과인 10을 출력해야 한다.
  */

  StringCalculator calculator = new StringCalculator();

  @Test
  public void nothing() throws Exception {
  }

  @Test
  public void 숫자_문자_하나_입력() throws Exception {
    //given
    String value = "2";
    //when
    int result = calculator.calculate(value);
    //then
    assertThat(result).isEqualTo(2);
  }

  @Test
  public void 연산자_문자_하나_입력() throws Exception {
    //given
    String value = "+";
    //when
    //then
    assertThatThrownBy(() -> {calculator.calculate(value);}).isInstanceOf(IllegalArgumentException.class);
  }

  @ParameterizedTest
  @ValueSource( strings = {"2 2","2 +"})
  public void 문자_두개_입력(String value) throws Exception {
    //given
    //when
    //then
    assertThatThrownBy(() -> {calculator.calculate(value);}).isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  public void 숫자_문자_두개_더하기() throws Exception {
    //given
    String value = "2 + 2";
    //when
    int result = calculator.calculate(value);
    //then
    assertThat(result).isEqualTo(4);
  }
}
