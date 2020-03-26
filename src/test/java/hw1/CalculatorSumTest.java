package hw1;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorSumTest {
    private Calculator calculator;

    @BeforeMethod
    public void setUp() {
        calculator = new Calculator();
    }

    @DataProvider
    public Object[][] sumTwoLongNumber() {
        return new Object[][]{
                {20, 32, 52},
                {10, 2, 12},
                {600, 190, 790},
        };
    }

    @Test(groups = {"gr1"}, dataProvider = "sumTwoLongNumber")
    public void sumTwoLongNumberWithDP(long a, long b, long expected) {
        long actual = calculator.sum(a, b);
        assertEquals(actual, expected);
    }

    @DataProvider
    public Object[][] sumTwoDoubleNumber() {
        return new Object[][]{
                {3.5, 3.2, 6.7},
                {10.9, 8.1, 19.0},
                {500.7, 430.0, 930.7},
        };
    }

    @Test(groups = {"gr1"}, dataProvider = "sumTwoDoubleNumber")
    public void sumTwoDoubleNumberWithDP(double a, double b, double expected) {
        double actual = calculator.sum(a, b);
        assertEquals(actual, expected);
    }

    @AfterMethod
    public void tearDown() {
        calculator = null;
    }

}
