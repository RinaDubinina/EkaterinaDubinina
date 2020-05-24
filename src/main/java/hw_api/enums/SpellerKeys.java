package hw_api.enums;

import lombok.Getter;

@Getter
public enum SpellerKeys {

    TEXT("text"),
    LANGUAGE("lang"),
    OPTIONS("options"),
    FORMAT("format");
    private String value;

    SpellerKeys(String value) {
        this.value = value;
    }
}
