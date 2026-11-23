import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class JUnitQuiz {

    //퀴즈1
    @Test
    public void JUnitQuiz1() {
        String name1 = "홍길동";
        String name2 = "홍길동";
        String name3 = "홍길은";
        //모든변수 null확인
        assertThat(name1).isNotNull();
        assertThat(name2).isNotNull();
        assertThat(name3).isNotNull();

        //name1 name2 같은지 확인
        assertThat(name1).isEqualTo(name2);
        //name1 name3 다른지 확인
        assertThat(name1).isNotEqualTo(name3);


    }

    //퀴즈2
    @Test
    public void JUnitQuiz2() {
        int number1 = 15;
        int number2 = 0;
        int number3 = -5;
        //1 양수인지
        assertThat(number1).isPositive();
        //2 0인지
        assertThat(number2).isZero();
        //3 음수인지
        assertThat(number3).isNegative();
        //1이 2보다 큰지
        assertThat(number1).isGreaterThan(number2);
        //3이 2보다 작은지
        assertThat(number3).isLessThan(number2);
    }


}
