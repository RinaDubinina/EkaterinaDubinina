package hw_api.enums;

import lombok.Getter;

@Getter
public enum Language {
    RUSSIAN("ru"),
    ENGLISH("en"),
    UKRAINS("uk");
    private String value;

    Language(String value) {
        this.value = value;
    }
}
