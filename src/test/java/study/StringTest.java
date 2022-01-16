package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

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
}
