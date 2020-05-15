package hw_api.assertions;

import hw_api.dto.SpellerDto;
import hw_api.enums.ErrorCodes;

import static org.assertj.core.api.Assertions.assertThat;


public class SpellerAssertions {
    private SpellerDto[] spellerDto;
    private SpellerDto[][] spellerDtos;


    public SpellerAssertions(SpellerDto[] spellerDto) {
        this.spellerDto = spellerDto;
    }

    public SpellerAssertions(SpellerDto[][] spellerDtos) {
        this.spellerDtos = spellerDtos;
    }

    public SpellerAssertions assertTextEmptyResponse() {
        assertThat(spellerDto).isEmpty();
        return this;
    }
    public SpellerAssertions assertTextNotEmptyResponse() {
        assertThat(spellerDto).isNotEmpty();
        return this;
    }

    public SpellerAssertions assertGivenWord(String word) {
        assertThat(this.spellerDto[0].getWord()).isEqualTo(word);
        return this;
    }
    public SpellerAssertions assertGetterWord(String expected) {
        assertThat(spellerDto[0].getS().get(0)).isEqualTo(expected);
        return this;
    }

    public SpellerAssertions assertErrorCode(int code) {
        assertThat(spellerDto[0].getCode()).isEqualTo(code);
        return this;
    }
    public SpellerAssertions assertTextsEmptyResponse() {
        assertThat(spellerDtos[0]).isEmpty();
        return this;
    }
    public SpellerAssertions assertTextsNotEmptyResponse() {
        assertThat(spellerDtos[0]).isNotEmpty();
        return this;
    }


}
