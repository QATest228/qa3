package pages.components;

import static com.codeborne.selenide.Selenide.$;

public class CalendarTest {
    public void setDate(String day, String month, String year) {
        $(".react-datepicker__month-select").selectOptionContainingText("December");
        $(".react-datepicker__year-select").selectOptionByValue("2000");
        $(".react-datepicker__day.react-datepicker__day--001").click();
    }
}