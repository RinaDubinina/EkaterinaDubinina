package hw5.composite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FramePage extends AbstractPageComposite {
    @FindBy(id = "frame")
    private WebElement framePage;

    @FindBy(id = "button-frame")
    private WebElement frameButton;

    public FramePage(WebDriver driver) {
        super(driver);
    }

    public boolean isFrameDisplayed() {
        return framePage.isDisplayed();
    }

    public void switchToFrame() {
        driver.switchTo().frame("frame");
    }

    public boolean isFrameButtonDisplayed() {
        return frameButton.isDisplayed();
    }

    public void switchToOriginalWindow() {
        driver.switchTo().defaultContent();
    }

}
