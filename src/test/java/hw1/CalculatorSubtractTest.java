package hw1;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorSubtractTest extends CalculatorBasis {

    @DataProvider
    public Object[][] subTwoLongNumber() {
        return new Object[][]{
                {100, 32, 68},
                {10, 2, 8},
                {600, 190, 410},
        };
    }

    @Test(groups = {"gr1"}, dataProvider = "subTwoLongNumber")
    public void subTwoLongNumberWithDP(long a, long b, long expected) {
        long actual = calculator.sub(a, b);
        assertEquals(actual, expected);
    }

    @DataProvider
    public Object[][] subTwoDoubleNumber() {
        return new Object[][]{
                {11.5, 3.2, 8.3},
                {100.7, 20.3, 80.4},
                {60.0, 19.0, 41.0},
        };
    }

    @Test(groups = {"gr1"}, dataProvider = "subTwoDoubleNumber")
    public void subTwoDoubleNumberWithDP(double a, double b, double expected) {
        double actual = calculator.sub(a, b);
        assertEquals(actual, expected);
    }
}
