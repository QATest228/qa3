package pages.components;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class MinimalDataAssertions {

    public void verifyMinimalSubmission() {
        $(".modal-header").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("Student Name")).shouldHave(text("Vaqif Yusibli"));
        $(".table-responsive").shouldHave(text("Student Email")).shouldHave(text("vaqifyusibli@gmail.com"));
        $(".table-responsive").shouldHave(text("Gender")).shouldHave(text("Male"));
        $(".table-responsive").shouldHave(text("Mobile")).shouldHave(text("1551662124"));
    }
}
