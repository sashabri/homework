import block3.unit1.task1.Calculator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

public class CalculatorTests {

    Calculator calculator;

    @BeforeEach
    public void beforeEach() {
        calculator = new Calculator();
    }

    @AfterEach
    public void afterEach() {
        calculator = null;
    }

    @Test
    public void TestMinus() {
        // given:
        int a = 8;
        int b = 12;
        int expected = -4;

        // when:
        int resultMinus = calculator.minus.apply(a, b);

        // then:
        Assertions.assertEquals(expected, resultMinus);
    }

    @Test
    public void TestDevide() {
        // given:
        int a = 5;
        int b = 0;
        Class<IllegalArgumentException> expected = IllegalArgumentException.class;

        // when:
        Executable executable = () -> calculator.devide.apply(a, b);

        // then:
        Assertions.assertThrowsExactly(expected, executable);
    }
}
