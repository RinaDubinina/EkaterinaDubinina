package hw_api.builder;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TestData {

    RU_WRONG_WORD("карова", "корова"),
    RU_CORRECT_WORD("кошка", "кошка"),
    RU_WRONG_PHRASE("В лесу радилась ёлочка", "родилась"),
    RU_CORRECT_PHRASE("В лесу родилась ёлочка", "В лесу родилась ёлочка"),
    RU_PHRASE_WITH_REPEAT_WORD("корова корова ела траву", "корова"),
    RU_WORD_IGNORE_CASE("мОСКВА", "Москва"),
    EN_WRONG_WORD("programm", "program"),
    EN_CORRECT_WORD("cat", "cat"),
    EN_PHRASE_WITH_REPEAT_WORD("repeat repeat word", "repeat"),
    EN_WORD_IGNORE_DIGITS("first1", "first 1"),
    EN_WORD_IGNORE_URL("epam.com", "COM"),
    EN_WORD_IGNORE_EMAIL("admin@admin.com", "COM"),
    EN_PHRASE_IGNORE_CASE("cAt dOG GoAT", "cat dog goat"),
    EN_CORRECT_PHRASE("This is correct phrase", "This is correct phrase");

    private String givenText;
    private String getterText;
}
