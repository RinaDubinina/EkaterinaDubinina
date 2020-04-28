package hw_jdi.pages;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import hw_jdi.entities.MetalsAndColors;
import hw_jdi.forms.MetalsAndColorsForm;

public class MetalsAndColorsPage extends WebPage {

    private MetalsAndColorsForm metalsAndColorsForm;

    @Css(".results")
    private UIElement results;

    public void fill(MetalsAndColors metalsAndColors) {
        metalsAndColorsForm.fill(metalsAndColors);
    }

    public void submitForm() {
        metalsAndColorsForm.pressButton("Submit");
    }

    public String getResults() {
        return results.getText().replace("\n", ", ");
    }

}
