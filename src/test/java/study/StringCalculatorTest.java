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
    //then
    assertThat(calculator.calculate(value)).isEqualTo(2);
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
  @ValueSource( strings = {"2 2","2 +","+ 2"})
  public void 문자_두개_입력(String value) throws Exception {
    //given
    //when
    //then
    assertThatThrownBy(() -> {calculator.calculate(value);}).isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  public void 연산자로_시작하는_길이_3의_문자열() throws Exception {
    //given
    String value = "+ 2 2";
    //when
    //then
    assertThatThrownBy(() -> {calculator.calculate(value);}).isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  public void 연산자로_끝나는_길이_3의_문자열() throws Exception {
    //given
    String value = "2 2 +";
    //when
    //then
    assertThatThrownBy(() -> {calculator.calculate(value);}).isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  public void 연산자가_문자보다_많은_문자열() throws Exception {
    //given
    String value = "2 + + + 3";
    //when
    //then
    assertThatThrownBy(() -> {calculator.calculate(value);}).isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  public void 숫자만_두_개_입력_문자열() throws Exception {
    //given
    String value = "2 2";
    //when
    //then
    assertThatThrownBy(() -> {calculator.calculate(value);}).isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  public void 숫자만_세_개_이상_입력_문자열() throws Exception {
    //given
    String value = "2 2 2 ";
    //when
    //then
    assertThatThrownBy(() -> {calculator.calculate(value);}).isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  public void 숫자_문자_두개_더하기() throws Exception {
    //given
    String value = "2 + 2";
    //when
    //then
    assertThat(calculator.calculate(value)).isEqualTo(4);
  }

  @Test
  public void 숫자_문자_세개_더하기() throws Exception {
    //given
    String value = "2 + 3 + 4";
    //when
    //then
    assertThat(calculator.calculate(value)).isEqualTo(9);
  }

  @Test
  public void 숫자_두개_빼기() throws Exception {
    //given
    String value = "2 - 2";
    //when
    //then
    assertThat(calculator.calculate(value)).isEqualTo(0);
  }

  @Test
  public void 숫자_세_개_빼기() throws Exception {
    //given
    String value = "7 - 3 - 1";
    //when
    //then
    assertThat(calculator.calculate(value)).isEqualTo(3);
  }

  @Test
  public void 더하기_빼기_믹스() throws Exception {
    //given
    String value = "7 + 4 - 10";
    //when
    //then
    assertThat(calculator.calculate(value)).isEqualTo(1);
  }

  @Test
  public void 숫자_곱하기() throws Exception {
    //given
    String value = "7 * 3";
    //when
    //then
    assertThat(calculator.calculate(value)).isEqualTo(21);
  }

  @Test
  public void 숫자_3개_곱하기() throws Exception {
    //given
    String value = "1 * 3 * 7";
    //when
    //then
    assertThat(calculator.calculate(value)).isEqualTo(21);
  }

  @Test
  public void 숫자_곱하기_빼기_순서_혼합() throws Exception {
    //given
    String value = "7 - 3 * 4";
    //when
    //then
    assertThat(calculator.calculate(value)).isEqualTo(16);
  }

  @Test
  public void 숫자_나누기() throws Exception {
    //given
    String value = "16 / 4";
    //when
    //then
    assertThat(calculator.calculate(value)).isEqualTo(4);
  }

  @Test
  public void 숫자_3개_나누기() throws Exception {
    //given
    String value = "49 / 7 / 7";
    //when
    //then
    assertThat(calculator.calculate(value)).isEqualTo(1);
  }

  @Test
  public void 모든_연산자_순서_혼합() throws Exception {
    //given
    String value = "12 - 2 * 10 / 100 + 5";
    //when
    //then
    assertThat(calculator.calculate(value)).isEqualTo(6);
  }

  @Test
  public void 문자열_null_입력() throws Exception {
    //given
    //when
    //then
    assertThatThrownBy(() -> { calculator.calculate(null);}).isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  public void 문자열_blank() throws Exception {
    //given
    //when
    //then
    assertThatThrownBy(() -> { calculator.calculate("");}).isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  public void 문자열_space() throws Exception {
    //given
    //when
    //then
    assertThatThrownBy(() ->{ calculator.calculate(" ");}).isInstanceOf(IllegalArgumentException.class);
  }
}
