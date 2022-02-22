package study;

import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class SetTest {
  private Set<Integer> numbers;


  @BeforeEach
  void setUp() {
    numbers = new HashSet<>();
    numbers.add(1);
    numbers.add(1);
    numbers.add(2);
    numbers.add(3);
  }


  @Test
  public void set_크기_구하는_메서드_테스트() throws Exception {
    assertThat(numbers.size()).isEqualTo(3);
  }

  @ParameterizedTest
  @ValueSource(ints = {1,2,3})
  public void set_내용_정확히_일치_테스트(int value) throws Exception {
    assertThat(numbers.contains(value)).isTrue();
  }

  @ParameterizedTest
  @CsvSource(value = {"1:true","2:true","3:true","4:false","5:false"}, delimiter = ':')
  public void set_내용과_일치하지_않는_인자_입력_테스트(int value, boolean result) throws Exception {
    assertThat(numbers.contains(value)).isEqualTo(result);
  }
}
