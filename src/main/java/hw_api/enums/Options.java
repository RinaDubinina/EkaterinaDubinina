package hw_api.enums;

import lombok.Getter;

@Getter
public enum Options {
    IGNORE_DIGITS("2"),
    IGNORE_URLS("4"),
    FIND_REPEATED_WORDS("8"),
    IGNORE_CASE("512");

    private String value;

    Options(String value) {
        this.value = value;
    }

}
