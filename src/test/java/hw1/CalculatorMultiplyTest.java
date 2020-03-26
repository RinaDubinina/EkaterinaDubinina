package hw1;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorMultiplyTest {
    private Calculator calculator;

    @BeforeMethod
    public void setUp() {
        calculator = new Calculator();
    }

    @DataProvider
    public Object[][] multTwoLongNumber() {
        return new Object[][]{
                {50, 34, 1700},
                {10, 3, 30},
                {1, 46, 46},
        };
    }

    @Test(groups = {"gr2"}, dataProvider = "multTwoLongNumber")
    public void multTwoLongNumberWithDP(long a, long b, long expected) {
        long actual = calculator.mult(a, b);
        assertEquals(actual, expected);

    }
    @DataProvider
    public Object[][] multTwoDoubleNumber() {
        return new Object[][]{
                {5.0, 4.2, 21},
                {7.2, 4.5, 32},
                {1.1, 4.6, 5.0},
        };
    }
    @Test(groups = {"gr2"}, dataProvider = "multTwoDoubleNumber")
    public void multTwoDoubleNumberWithDP(double a, double b, double expected) {
        double actual = calculator.mult(a,b);
        assertEquals(actual, expected);
    }

    @AfterMethod
    public void tearDown() {
        calculator = null;
    }

}
