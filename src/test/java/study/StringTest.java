package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }
    
    @Test
    public void splitBaseComa() throws Exception {
        //given
        //when
        String[] actual = "1,2".split(",");
        //then
        assertThat(actual).contains("1","2");
        assertThat(actual).containsExactly("1", "2");
    }
    
    @Test
    public void splitBaseComaWithoutParentheses() throws Exception {
        //given
        String givenValue = "(1,2)";
        //when
        String actual = givenValue.substring(1,givenValue.length()-1);
        //then
        assertThat(actual).isEqualTo("1,2");
    }

    @Test
    @DisplayName("문자열에서 특정 인덱스 위치의 문자를 가져오기 성공")
    public void charAtTest() throws Exception {
        //given
        String givenValue = "abc";
        //when
        char actual = givenValue.charAt(0);
        //then
        assertThat(actual).isEqualTo('a');
    }

    @Test
    @DisplayName("문자열에서 벗어난 인덱스 위치 입력시 StringIndexOutOfBoundsException 발생")
    public void charAtExceptionTest() throws Exception {
        //given
        String givenValue = "abc";
        //when
        //then
        assertThatThrownBy(() -> {
            givenValue.charAt(givenValue.length());
        }).isInstanceOf(StringIndexOutOfBoundsException.class);
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
            .isThrownBy(() -> {
                givenValue.charAt(givenValue.length());
            });
    }
}
