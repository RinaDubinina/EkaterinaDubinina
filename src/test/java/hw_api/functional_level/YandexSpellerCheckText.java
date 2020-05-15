package hw_api.functional_level;

import hw_api.assertions.SpellerAssertions;
import hw_api.builder.SpellerBuilder;
import hw_api.dataProvider.SpellerDataProvider;
import hw_api.dto.SpellerDto;

import hw_api.service.YandexSpellerService;

import org.testng.annotations.Test;

import static hw_api.enums.ErrorCodes.*;

public class YandexSpellerCheckText {

    @Test(dataProviderClass = SpellerDataProvider.class, dataProvider = "correctText")
    public void checkCorrectTextTest(String text, String language) {
        SpellerBuilder spellerBuilder = SpellerBuilder.builder()
                .text(text)
                .language(language)
                .build();
        SpellerDto[] speller = new YandexSpellerService().getCheckText(spellerBuilder);
        new SpellerAssertions(speller).assertTextEmptyResponse();
    }

    @Test(dataProviderClass = SpellerDataProvider.class, dataProvider = "incorrectText")
    public void checkIncorrectTextTest(String givenText, String language, String getterText) {
        SpellerBuilder spellerBuilder = SpellerBuilder.builder()
                .text(givenText)
                .language(language)
                .build();
        SpellerDto[] speller = new YandexSpellerService().getCheckText(spellerBuilder);
        new SpellerAssertions(speller)
                .assertTextNotEmptyResponse()
                .assertErrorCode(ERROR_UNKNOWN_WORD.getValue())
                .assertGetterWord(getterText);
    }

    @Test(dataProviderClass = SpellerDataProvider.class, dataProvider = "textWithOptionsIgnoreMistake")
    public void checkTextWithOptionsIgnoreMistakeTest(String givenText, String language, String options) {
        SpellerBuilder spellerBuilder = SpellerBuilder.builder()
                .text(givenText)
                .language(language)
                .options(options)
                .build();
        SpellerDto[] speller = new YandexSpellerService().getCheckText(spellerBuilder);
        new SpellerAssertions(speller)
                .assertTextEmptyResponse();

    }

    @Test(dataProviderClass = SpellerDataProvider.class, dataProvider = "textWithFindRepeatWordOption")
    public void checkWithFindRepeatWordOptionTest(String givenText, String language, String options, String repeatWord) {
        SpellerBuilder spellerBuilder = SpellerBuilder.builder()
                .text(givenText)
                .language(language)
                .options(options)
                .build();
        SpellerDto[] speller = new YandexSpellerService().getCheckText(spellerBuilder);
        new SpellerAssertions(speller)
                .assertTextNotEmptyResponse()
                .assertErrorCode(ERROR_REPEAT_WORD.getValue())
                .assertGivenWord(repeatWord);
    }


}

