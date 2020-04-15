package hw4.utill;

import java.util.List;

public class Summary {
    public String getSum(List<String> sumValues) {
        Integer firstValue = Integer.parseInt(sumValues.get(0));
        Integer secondValue = Integer.parseInt(sumValues.get(1));
        return Integer.toString(firstValue + secondValue);

    }
}
