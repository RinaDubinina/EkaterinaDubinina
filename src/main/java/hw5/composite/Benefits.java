package hw5.composite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class Benefits extends AbstractPageComposite {
    @FindBy(className = "benefit-icon")
    private List<WebElement> benefitIcon;

    @FindBy(className = "benefit-txt")
    private List<WebElement> benefitTextElement;

    public Benefits(WebDriver driver) {
        super(driver);
    }

    public int getBenefitIconCount() {
        return benefitIcon.size();
    }

    public int getBenefitTextElementCount() {
        return benefitTextElement.size();
    }

    public List<String> getBenefitTexts() {
        return benefitTextElement.stream().map(WebElement::getText).collect(Collectors.toList());
    }
}
