import cz.cvut.fel.ts1.Calculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
public class CalculatorTest {
    Calculator calculator = new Calculator();
    @CsvSource({"1,2,3", "-4,6,2", "1,2,1"})
    @ParameterizedTest( name = "{0} plus {1} should be equal to {2}")
    public void addition_addsAAndB_returnsC(int a, int b, int c) {
        int expectedResult = c;
        int result = calculator.addition(a, b);

        Assertions.assertEquals(expectedResult, result);
    }
    @Test
    public void addition_EightPlusFour_Twelve() {
        Assertions.assertEquals(12, calculator.addition(8, 4));
    }

    @Test
    public void subtraction_EightMinusFour_Four() {
        Assertions.assertEquals(4, calculator.subtraction(8, 4));
    }

    @Test
    public void multiplication_EightTimesFour_ThirtyTwo() {
        Assertions.assertEquals(32, calculator.multiplication(8, 4));
    }

    @Test
    public void division_EightDividedByFour_Two() {
        Assertions.assertEquals(2, calculator.division(8, 4));
    }

    @Test
    public void division_EightDividedByZero_Exception() {
        Assertions.assertThrows(ArithmeticException.class,()->calculator.division(8, 0));
    }

}
