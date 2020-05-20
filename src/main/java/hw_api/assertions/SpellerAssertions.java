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
        assertThat(spellerDto).withFailMessage("Get unexpected error %s", spellerDto.toString()).isEmpty();
        return this;
    }

    public SpellerAssertions assertTextNotEmptyResponse() {
        assertThat(spellerDto)
                .withFailMessage("Expected error not found").isNotEmpty();
        return this;
    }

    public SpellerAssertions assertGivenWord(String word) {
        assertThat(this.spellerDto[0].getWord())
                .withFailMessage("The word %s not equals %s", spellerDto[0].getWord(), word).isEqualTo(word);
        return this;
    }

    public SpellerAssertions assertGetterWord(String expected) {
        assertThat(spellerDto[0].getS().get(0))
                .withFailMessage("The misspell word %s not equals %s", spellerDto[0].getS().get(0), expected).isEqualTo(expected);
        return this;
    }

    public SpellerAssertions assertErrorCode(int code) {
        assertThat(spellerDto[0].getCode())
                .withFailMessage("Error code is %s but expected %s", spellerDto[0].getCode(), code).isEqualTo(code);
        return this;
    }

    public SpellerAssertions assertTextsEmptyResponse() {
        assertThat(spellerDtos[0])
                .withFailMessage("Get unexpected error %s", spellerDto.toString()).isEmpty();
        return this;
    }

    public SpellerAssertions assertTextsNotEmptyResponse() {
        assertThat(spellerDtos[0])
                .withFailMessage("Expected error not found").isNotEmpty();
        return this;
    }
}
