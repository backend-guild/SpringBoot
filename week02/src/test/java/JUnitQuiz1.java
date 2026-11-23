import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class JUnitQuiz1 {
    @Test
    public void junitTest() {
        String name1 = "홍길동";
        String name2 = "홍길동";
        String name3 = "홍길은";

        assertThat(name1).isNotEmpty();
        assertThat(name2).isNotEmpty();
        assertThat(name3).isNotEmpty();

        assertThat(name1).isEqualTo(name2);

        assertThat(name1).isNotEqualTo(name3);
    }
}
