package hw_jdi.forms;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.complex.Checklist;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.complex.RadioButtons;
import hw_jdi.entities.MetalsAndColors;


public class MetalsAndColorsForm extends Form<MetalsAndColors> {

    public static final String VEGETABLES = "Vegetables";

    @UI("[name=custom_radio_odd]")
    private RadioButtons oddSum;

    @UI("[name=custom_radio_even]")
    private RadioButtons evenSum;

    @Css("#elements-checklist input")
    private Checklist elements;

    @JDropdown(root = "#colors",
            value = ".filter-option",
            list = "li",
            expand = ".caret")
    private Dropdown colors;

    @JDropdown(root = "#metals",
            value = ".filter-option",
            list = "li",
            expand = ".caret")
    private Dropdown metals;

    @JDropdown(root = "#salad-dropdown",
            value = ".dropdown-menu",
            list = "li",
            expand = ".caret")
    private Dropdown vegetables;

    @Css("#submit-button")
    private Button submit;

    @Override
    public void fill(MetalsAndColors metalsAndColors) {
        oddSum.select(String.valueOf(metalsAndColors.getOddSum()));
        evenSum.select(String.valueOf(metalsAndColors.getEvenSum()));
        for (String element : metalsAndColors.getElements()) {
            elements.select(element);
        }
        colors.select(metalsAndColors.getColor());
        metals.select(metalsAndColors.getMetals());
        selectDefaultVegetablesValue();

        for (String vegetable : metalsAndColors.getVegetables()) {
            vegetables.select(vegetable);
        }
    }

    @Override
    public void pressButton(String nameButton) {
        super.pressButton(nameButton);
    }

    public void selectDefaultVegetablesValue() {
        vegetables.select(VEGETABLES);
    }

}
