package com.vaqif;


import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TestBoxes {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 5000;
    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        $("#firstName").setValue("Vaqif");
        $("#lastName").setValue("Yusibli");
        $("#userEmail").setValue("vaqifyusibli@gmail.com");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("15516621241");
        $("#userForm #dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOptionContainingText("December");
        $(".react-datepicker__year-select").selectOptionByValue("2000");
        $(".react-datepicker__day.react-datepicker__day--001").click();
        $("#userForm #subjectsInput").setValue("Maths");
        $("#userForm .subjects-auto-complete__menu").click();
        $("#userForm #subjectsInput").setValue("Arts");
        $("#userForm .subjects-auto-complete__menu").click();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFile(new File("C:/Users/Vaqif/IdeaProjects/qa_quru/QA3UROK/src/test/resources/orig.png.jpg"));
        $("#currentAddress").setValue("Poland,Krakow");
        $("#react-select-3-input").setValue("Haryana").pressEnter();
        $("#react-select-4-input").setValue("Karnal").pressEnter();
        $("#submit").click();
        $(".modal-content").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("Student Name")).shouldHave(text("Vaqif Yusibli"));
        $(".table-responsive").shouldHave(text("Student Email")).shouldHave(text("vaqifyusibli@gmail.com"));
        $(".table-responsive").shouldHave(text("Gender")).shouldHave(text("Male"));
        $(".table-responsive").shouldHave(text("Mobile")).shouldHave(text("1551662124"));
        $(".table-responsive").shouldHave(text("Date of Birth")).shouldHave(text("01 December,2000"));
        $(".table-responsive").shouldHave(text("Subjects")).shouldHave(text("Maths, Arts"));
        $(".table-responsive").shouldHave(text("Hobbies")).shouldHave(text("Sports"));
        $(".table-responsive").shouldHave(text("Picture")).shouldHave(text("orig.png"));
        $(".table-responsive").shouldHave(text("Address")).shouldHave(text("Poland,Krakow"));
        $(".table-responsive").shouldHave(text("State and City")).shouldHave(text("Haryana Karnal"));
    }
}