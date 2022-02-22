package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class RefereeTest {

    Referee referee = new Referee();

    @Test
    public void 숫자가_모두_동일하면_3스트라이크() throws Exception {
        //given
        String inputNumber = "123";
        String randomNumber = "123";
        
        //when
        String result = referee.judge(inputNumber, randomNumber);
        //then
        assertThat(result).isEqualTo("3 strike");
    }

    @Test
    public void 숫자가_모두_틀린_경우_nothing() throws Exception {
        //given
        String inputNumber = "456";
        String randomNumber = "123";

        //when
        String result = referee.judge(inputNumber, randomNumber);

        //then
        assertThat(result).isEqualTo("nothing");
    }

    @Test
    public void 숫자는_모두_같지만_순서만_틀린경우_3볼() throws Exception {
        //given
        String inputNumber = "312";
        String randomNumber = "123";

        //when
        String result = referee.judge(inputNumber, randomNumber);
        //then
        assertThat(result).isEqualTo("3 ball");
    }

    @Test
    public void 숫자가_한_개만_맞은_경우_1스트라이크() throws Exception {
        //given
        String inputNumber = "145";
        String randomNumber = "123";

        //when
        String result = referee.judge(inputNumber,randomNumber);
        //then
        assertThat(result).isEqualTo("1 strike");
    }

    @Test
    public void 숫자가_두_개만_맞은_경우_2스트라이크() throws Exception {
        //given
        String inputNumber = "126";
        String randomNumber = "123";

        //when
        String result = referee.judge(inputNumber, randomNumber);
        //then
        assertThat(result).isEqualTo("2 strike");
    }

    @Test
    public void 위치는_다르지만_동일한_숫자가_1개_1볼() throws Exception {
        //given
        String inputNumber = "123";
        String randomNumber = "451";

        //when
        String result = referee.judge(inputNumber, randomNumber);
        //then
        assertThat(result).isEqualTo("1 ball");
    }

    @Test
    public void 위치는_다르지만_동일한_숫자가_2개_2볼() throws Exception {
        //given
        String inputNumber = "123";
        String randomNumber = "214";

        //when
        String result = referee.judge(inputNumber, randomNumber);
        //then
        assertThat(result).isEqualTo("2 ball");
    }

    @Test
    public void 스트라이크_1개_볼_1개() throws Exception {
        //given
        String inputNumber = "123";
        String randomNumber = "142";

        //when
        String result = referee.judge(inputNumber, randomNumber);
        //then
        assertThat(result).isEqualTo("1 ball 1 strike");
    }

    @Test
    public void 볼_2개_스트라이크_1개() throws Exception {
        //given
        String inputNumber = "123";
        String randomNumber = "132";

        //when
        String result = referee.judge(inputNumber, randomNumber);
        //then
        assertThat(result).isEqualTo("2 ball 1 strike");
    }

}