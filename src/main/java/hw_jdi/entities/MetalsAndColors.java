package hw_jdi.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class MetalsAndColors {
    private int[] summary;
    private List<String> elements;
    private String color;
    private String metals;
    private List<String> vegetables;

    public int getOddSum() {
        return this.summary[0];
    }

    public int getEvenSum() {
        return this.summary[1];
    }

    public String getExpectedResults() {
        List<String> expectedResult = new ArrayList<String>() {{
            add("Summary: " + sum());
            add("Elements: " + String.join(", ", elements));
            add("Color: " + color);
            add("Metal: " + metals);
            add("Vegetables: " + String.join(", ", vegetables));
        }};
        return expectedResult.toString().replaceAll("\\[|\\]", "");
    }

    private int sum() {
        return (getOddSum() + getEvenSum());
    }

}
