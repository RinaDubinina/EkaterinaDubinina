package hw_api.enums;

import lombok.Getter;

@Getter
public enum ErrorCodes {
    ERROR_UNKNOWN_WORD(1),
    ERROR_REPEAT_WORD(2),
    ERROR_CAPITALIZATION(3),
    ERROR_TOO_MANY_ERRORS(4);

    private int value;

    ErrorCodes(int value) {
        this.value = value;
    }
}
