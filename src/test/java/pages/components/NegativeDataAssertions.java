package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class NegativeDataAssertions {
    // Проверка на ошибочные данные в таблице
    public void verifyIncorrectDataInTable(String fieldName, String incorrectValue) {
        // Проверяем, что в таблице данные не совпадают с неправильным значением
        $(".table-responsive").shouldHave(text(fieldName));
        $(".table-responsive").shouldNotHave(text(incorrectValue)); // Проверяем, что в таблице нет неправильных данных
    }
}
