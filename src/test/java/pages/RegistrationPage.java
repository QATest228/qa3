package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarTest;
import pages.components.MinimalDataAssertions;
import pages.components.NegativeDataAssertions;
import pages.components.SubmissionAssertions;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    private SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            GenderInput = $("#genterWrapper"),
            NumberInput = $("#userNumber"),
            CalendarInput = $("#dateOfBirthInput"),
            HobbiesInput = $("#hobbiesWrapper"),
            PageButton = $("#uploadPicture"),
            AdressBut = $("#currentAddress");

    CalendarTest calendarComponent = new CalendarTest();
    SubmissionAssertions submissionAssertions = new SubmissionAssertions();
    MinimalDataAssertions minimalDataAssertions = new MinimalDataAssertions();
    NegativeDataAssertions negativeDataAssertions = new NegativeDataAssertions();


    public RegistrationPage opening() {
        open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setUserEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    public RegistrationPage SetGender(String value) {
        GenderInput.$(byText(value)).click();
        return this;
    }

    public RegistrationPage SetNumber(String value) {
        NumberInput.setValue(value);
        return this;
    }

    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        CalendarInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public RegistrationPage setSubject(String subject1, String subject2) {
        $("#userForm #subjectsInput").setValue(subject1);
        $("#userForm .subjects-auto-complete__menu").click();
        $("#userForm #subjectsInput").setValue(subject2);
        $("#userForm .subjects-auto-complete__menu").click();
        return this;
    }

    public RegistrationPage setHobbie(String value){
        HobbiesInput.$(byText(value)).click();
        return this;
    }

    public RegistrationPage SetPage(){
        PageButton.uploadFromClasspath("orig.png.jpg");
        return this;
    }

    public RegistrationPage SetAdress(String value){
        AdressBut.setValue(value);
        return this;
    }

    public RegistrationPage setAddressAndSubmit(String state, String city) {
        $("#react-select-3-input").setValue(state).pressEnter();
        $("#react-select-4-input").setValue(city).pressEnter();
        $("#submit").click();
        return this;
    }

    public RegistrationPage verifySubmission() {
        submissionAssertions.verifySubmission();
        return this;
    }

    public RegistrationPage verifyMinimalSubmission() {
        minimalDataAssertions.verifyMinimalSubmission();
        return this;
    }

    public RegistrationPage verifyIncorrectCityInTable() {
        negativeDataAssertions.verifyIncorrectDataInTable("State and City", "Warsaw"); // Город Варшава не должен быть в таблице
        return this;
    }
}
