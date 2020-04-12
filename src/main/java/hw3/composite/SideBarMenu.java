package hw3.composite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class SideBarMenu extends AbstractPageComposite {
    @FindBy(css = ".sidebar-menu > li")
    private List<WebElement> sideBarMenuElement;

    public SideBarMenu(WebDriver driver) {
        super(driver);
    }

    public int getSideBarMenuCountElements() {
        return sideBarMenuElement.size();
    }

    public List<String> getSideBarMenuText() {
        return sideBarMenuElement.stream().map(WebElement::getText).collect(Collectors.toList());
    }
}
