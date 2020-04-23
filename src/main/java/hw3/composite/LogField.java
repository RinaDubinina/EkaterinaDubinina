package hw3.composite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class LogField extends AbstractPageComposite {
    @FindBy(css = ".logs li")
    private List<WebElement> logs;

    public LogField(WebDriver driver) {
        super(driver);
    }

    public boolean isLogElementDisplayed(String elementName){
        boolean isDisplayed = false;
        for (WebElement log:logs){
            if (log.getText().contains(elementName + ": condition changed to") || log.getText().contains("value changed to " + elementName)) {
                isDisplayed = true;
            }
        }
        return isDisplayed;
    }

   public boolean isLogTextDisplayed(int index,String logText){
       boolean isDisplayed = false;
           if (logs.get(index-1).getText().contains(logText)) {
               isDisplayed = true;
           }
       return isDisplayed;
   }
}



