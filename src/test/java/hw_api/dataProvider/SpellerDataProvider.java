package hw_api.dataProvider;

import org.testng.annotations.DataProvider;

import static hw_api.builder.TestData.*;
import static hw_api.enums.Language.*;
import static hw_api.enums.Options.*;

public class SpellerDataProvider {
    @DataProvider
    public Object [][] correctText(){
    return new Object[][]{
            {RU_CORRECT_WORD.getGivenText(), RUSSIAN.getValue()},
            {EN_CORRECT_WORD.getGivenText(),ENGLISH.getValue()},
            {EN_CORRECT_PHRASE.getGivenText(),ENGLISH.getValue()}
    };
    }

    @DataProvider
    public Object[][] incorrectText(){
        return new Object[][]{
            {RU_WRONG_WORD.getGivenText(),RUSSIAN.getValue(),RU_WRONG_WORD.getGetterText()},
            {RU_WRONG_PHRASE.getGivenText(),RUSSIAN.getValue(),RU_WRONG_PHRASE.getGetterText()},
            {EN_WRONG_WORD.getGivenText(),ENGLISH.getValue(),EN_WRONG_WORD.getGetterText()}
        };
    }

    @DataProvider
    public Object[][] correctTexts(){
        return new Object[][]{
        {RU_CORRECT_WORD.getGivenText(),RU_CORRECT_PHRASE.getGivenText()},
        {EN_CORRECT_WORD.getGivenText(), EN_CORRECT_PHRASE.getGivenText()}
    };
    }

    @DataProvider
    public Object[][] incorrectTexts(){
        return new Object[][]{
                {RU_WRONG_WORD.getGivenText(),RU_WRONG_PHRASE.getGivenText()},
                {EN_WRONG_WORD.getGivenText(), EN_PHRASE_WITH_REPEAT_WORD.getGivenText()}
        };
    }

    @DataProvider
    public Object[][] textWithOptionsIgnoreMistake(){
        return new Object[][]{
               {RU_WORD_IGNORE_CASE.getGivenText(),RUSSIAN.getValue(),IGNORE_CASE.getValue()},
                {EN_PHRASE_IGNORE_CASE.getGivenText(),ENGLISH.getValue(),IGNORE_CASE.getValue()},
                {EN_WORD_IGNORE_DIGITS.getGivenText(), ENGLISH.getValue(),IGNORE_DIGITS.getValue()},
                {EN_WORD_IGNORE_URL.getGivenText(), ENGLISH.getValue(),IGNORE_URLS.getValue()},
                {EN_WORD_IGNORE_EMAIL.getGivenText(), ENGLISH.getValue(),IGNORE_URLS.getValue()}

        };
    }
    @DataProvider
    public Object[][] textWithFindRepeatWordOption(){
        return new Object[][]{
                 {RU_PHRASE_WITH_REPEAT_WORD.getGivenText(),RUSSIAN.getValue(),
                        FIND_REPEATED_WORDS.getValue(), RU_PHRASE_WITH_REPEAT_WORD.getGetterText()},
                {EN_PHRASE_WITH_REPEAT_WORD.getGivenText(),ENGLISH.getValue(),
                FIND_REPEATED_WORDS.getValue(),EN_PHRASE_WITH_REPEAT_WORD.getGetterText()}

        };
    }





}
