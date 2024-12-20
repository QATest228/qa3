package pages.components;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Condition.text;

public class SubmissionAssertions {

    // Селекторы для таблицы
    private final String TABLE_RESPONSIVE_SELECTOR = ".table-responsive";
    private final String MODAL_CONTENT_SELECTOR = ".modal-content";

    // Универсальный метод для проверки текста в таблице
    public void verifyTextInTable(String label, String expectedText) {
        $(TABLE_RESPONSIVE_SELECTOR).shouldHave(text(label));
        $(TABLE_RESPONSIVE_SELECTOR).shouldHave(text(expectedText));
    }

    // Метод для проверки всех данных после отправки формы
    public void verifySubmission() {
        $(MODAL_CONTENT_SELECTOR).shouldHave(text("Thanks for submitting the form"));
        verifyTextInTable("Student Name", "Vaqif Yusibli");
        verifyTextInTable("Student Email", "vaqifyusibli@gmail.com");
        verifyTextInTable("Gender", "Male");
        verifyTextInTable("Mobile", "1551662124");
        verifyTextInTable("Date of Birth", "01 December,2000");
        verifyTextInTable("Subjects", "Maths, Arts");
        verifyTextInTable("Hobbies", "Sports");
        verifyTextInTable("Picture", "orig.png");
        verifyTextInTable("Address", "Poland");
        verifyTextInTable("State and City", "Haryana Karnal");
    }
}
