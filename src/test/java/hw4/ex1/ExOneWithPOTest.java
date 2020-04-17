package hw4.ex1;


import hw4.LoginBase;
import hw4.pages.IndexPage;
import hw4.pages.TableWithPagesElementPage;
import hw4.utill.PropertyReader;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class ExOneWithPOTest extends LoginBase {

    public static final String DEFAULT_TABLE_LENGTH_VALUE = "5";
    public static final String TABLE_LENGTH_VALUE = "10";
    public static final String SEARCH_FIELD_TEXT = " junit";


    @Test
    public void exerciseOneTest() {

        IndexPage indexPage = new IndexPage(getDriver());
        TableWithPagesElementPage tableWithPagesElementPage = new TableWithPagesElementPage(getDriver());
        //1. Open test site by URL
        openSite();

        //2. Assert Browser title
        assertEquals(indexPage.getBrowserTitle(), "Home Page", "Browser title has incorrect name");

        //3. Perform login
        indexPage.login(PropertyReader.read("user"), PropertyReader.read("password"));

        //4. Assert Username is loggined
        assertTrue(indexPage.getUserName().equals("ROMAN IOVLEV"), "Name is not equals to expected result");

        //5. Open through the header menu Service -> Table with pages
        indexPage.getTableWithPagesElementPage();

        //6. Check that default value for “Show entries” dropdown is 5
        String actualDefaultValue = tableWithPagesElementPage.getTableLengthDefaultValue();
        assertEquals(actualDefaultValue, ExOneWithPOTest.DEFAULT_TABLE_LENGTH_VALUE,
                "default value for “Show entries” dropdown is " + actualDefaultValue + " but expected value " + DEFAULT_TABLE_LENGTH_VALUE);

        //7. Select new value for the entries in the dropdown list
        tableWithPagesElementPage.setTableLengthValue(TABLE_LENGTH_VALUE);
        String actualValue = tableWithPagesElementPage.getTableLengthDefaultValue();
        assertEquals(actualValue, TABLE_LENGTH_VALUE,
                "New value for the entries in the dropdown list is " + actualValue + " but expected value " + TABLE_LENGTH_VALUE);


        //8. Assert that in the table displayed corrected amount of entries
        int actualEntriesAmount = tableWithPagesElementPage.getEntriesAmount();
        assertEquals(actualEntriesAmount, 10,"Amount of entries is "+ actualEntriesAmount+ "but expected 10" );

        //9. Type in “Search” text field
        tableWithPagesElementPage.setSearchFieldText(SEARCH_FIELD_TEXT);

        //10. Assert the table contains only records with Search field value
        assertTrue(tableWithPagesElementPage.isEntriesContainSearchValue(SEARCH_FIELD_TEXT));

        //11. Close Browser
        // by tearDown() in LoginBase.class

    }
}