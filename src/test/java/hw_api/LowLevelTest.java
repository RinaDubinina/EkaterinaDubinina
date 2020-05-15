package hw_api;

import hw_api.enums.ErrorCodes;
import hw_api.enums.Language;
import hw_api.enums.SpellerKeys;
import hw_api.service.URI;
import io.restassured.RestAssured;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static hw_api.enums.ErrorCodes.*;
import static hw_api.enums.Language.*;
import static hw_api.enums.SpellerKeys.*;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.is;

public class LowLevelTest extends BaseTest {

    @Test
    public void checkText(){
        RestAssured
                .given(REQUEST_SPECIFICATION)
                .get(URI.CHECK_TEXT)
                .then()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void checkCorrectWord(){
        RestAssured
                .given(REQUEST_SPECIFICATION)
                .param(TEXT.getValue(),"кошка")
                .param(LANGUAGE.getValue(), RUSSIAN.getValue())
                .log().all()
                .get(URI.CHECK_TEXT)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body(is("[]"));
    }


    @Test
    public void checkIncorrectWord(){
        RestAssured
                .given(REQUEST_SPECIFICATION)
                .param(TEXT.getValue(), "cAT")
                .param(LANGUAGE.getValue(), ENGLISH.getValue())
                .log().all()
                .get(URI.CHECK_TEXT)
                .then()
                .body("code[0]", is(ERROR_CAPITALIZATION.getValue()))
                .body("s[0]", hasItem("cat"));

    }









}
