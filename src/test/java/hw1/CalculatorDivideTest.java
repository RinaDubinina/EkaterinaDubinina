package hw1;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorDivideTest {
    private Calculator calculator;

    @BeforeMethod
    public void setUp() {
        calculator = new Calculator();
    }

    @DataProvider
    public Object[][] divTwoLongNumber() {
        return new Object[][]{
                {100, 25, 4},
                {10, 2, 5},
                {900, 90, 10},
        };
    }

    @Test(groups = {"gr2"}, dataProvider = "divTwoLongNumber")
    public void divTwoLongNumberWithDP(long a, long b, long expected) {
        long actual = calculator.div(a, b);
        assertEquals(actual, expected);
    }

    @DataProvider
    public Object[][] divTwoDoubleNumber() {
        return new Object[][]{
                {24.8, 12.5, 1.984},
                {60.0, 2.5, 24.0},
                {50.8, 50.8, 1.0},
        };
    }

    @Test(groups = {"gr2"}, dataProvider = "divTwoDoubleNumber")
    public void divTwoDoubleNumberWithDP(double a, double b, double expected) {
        double actual = calculator.div(a, b);
        assertEquals(actual, expected);
    }

    @Test(groups = {"gr2"}, expectedExceptions = NumberFormatException.class)
    public void divToZero() {
        long actual = calculator.div(26L, 0);

    }

    @AfterMethod
    public void tearDown() {
        calculator = null;
    }
}


