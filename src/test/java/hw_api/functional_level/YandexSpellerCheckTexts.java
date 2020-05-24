package hw_api.functional_level;

import hw_api.assertions.SpellerAssertions;
import hw_api.dataProvider.SpellerDataProvider;
import hw_api.dto.SpellerDto;
import hw_api.service.YandexSpellerService;
import org.testng.annotations.Test;

public class YandexSpellerCheckTexts {
    @Test(dataProviderClass = SpellerDataProvider.class, dataProvider = "correctTexts")
    public void checkCorrectTextsTest(String firstText, String secondTest) {
        SpellerDto[][] speller = new YandexSpellerService().getCheckTexts(new String[]{firstText, secondTest});
        new SpellerAssertions(speller).assertTextsEmptyResponse();
    }

    @Test(dataProviderClass = SpellerDataProvider.class, dataProvider = "incorrectTexts")
    public void checkIncorrectTextsTest(String firstText, String secondTest) {
        SpellerDto[][] speller = new YandexSpellerService().getCheckTexts(new String[]{firstText, secondTest});
        new SpellerAssertions(speller).assertTextsNotEmptyResponse();
    }
}
