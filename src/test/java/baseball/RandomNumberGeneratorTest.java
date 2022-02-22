package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RandomNumberGeneratorTest {



    @Test
    public void nothing() throws Exception {
        //given


        //when

        //then

    }

    @Test
    public void 문자숫자_생성() throws Exception {
        //given

        //when

        //then
        assertThat(RandomNumberGenerator.generate())
                .isInstanceOf(String.class);
    }

    @Test
    public void 생성된_숫자는_not_null() throws Exception {
        //given


        //when

        //then
        assertThat(RandomNumberGenerator.generate()).isNotNull();
    }

    @Test
    public void 생성된_숫자는_양수() throws Exception {
        //given

        //when

        //then
        assertThat(Integer.parseInt(RandomNumberGenerator.generate())).isPositive();
    }

    @Test
    public void 세자리_숫자_생성() throws Exception {
        //given
        int length = RandomNumberGenerator.generate()
                .length();

        //when

        //then
        assertThat(length).isEqualTo(3);
    }

    @Test
    public void 세자리_숫자에_0은_포함되지_않음() throws Exception {
        //given
        String[] numbers = RandomNumberGenerator.generate()
                .split("");

        //when

        //then
        assertThat(numbers).doesNotContain("0");
    }

    @Test
    public void 세자리_숫자는_각각_중복되지_않음() throws Exception {
        //given
        String[] numbers = RandomNumberGenerator.generate()
                .split("");

        //when

        //then
        assertThat(numbers).doesNotHaveDuplicates();
    }

}