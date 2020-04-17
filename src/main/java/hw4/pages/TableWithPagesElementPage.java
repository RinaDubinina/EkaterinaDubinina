package hw4.pages;

import hw4.composite.HeaderMenu;
import hw4.composite.TableWithPages;
import org.openqa.selenium.WebDriver;

public class TableWithPagesElementPage extends AbstractPage {
    private TableWithPages tableWithPages;

    public TableWithPagesElementPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        this.headerMenu = new HeaderMenu(driver);
        this.tableWithPages = new TableWithPages(driver);
    }

    public String getTableLengthDefaultValue() {
        return tableWithPages.getTableLengthDefaultValue();
    }

    public void setTableLengthValue(String value) {
        tableWithPages.setTableLengthValue(value);
    }

    public int getEntriesAmount() {
        return tableWithPages.getEntriesAmount();
    }
    public void setSearchFieldText(String text){
        tableWithPages.setSearchFieldText(text);
    }
    public boolean isEntriesContainSearchValue(String searchValue){
       return tableWithPages.isEntriesContainSearchValue(searchValue);
    }
}
