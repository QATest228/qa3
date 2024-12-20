import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class RegistrationTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void fillFormTest() {
        registrationPage.opening()
                .setFirstName("Vaqif")
                .setLastName("Yusibli")
                .setUserEmail("vaqifyusibli@gmail.com")
                .SetGender("Male")
                .SetNumber("1551662124")
                .setDateOfBirth("1", "December", "2000")
                .setSubject("Math", "Arts")
                .setHobbie("Sports")
                .SetPage()
                .SetAdress("Poland")
                .setAddressAndSubmit("Haryana", "Karnal")
                .verifySubmission();
    }

    @Test
    void fillFormWithMinimalDataTest() {
        registrationPage.opening()
                .setFirstName("Vaqif")
                .setLastName("Yusibli")
                .setUserEmail("vaqifyusibli@gmail.com")
                .SetGender("Male")
                .SetNumber("1551662124")
                .setAddressAndSubmit("Haryana", "Karnal")
                .verifyMinimalSubmission();  // Проверка с минимальными данными
    }

    @Test
    void negativeCityTest() {
        registrationPage.opening()
                .setFirstName("Vaqif")
                .setLastName("Yusibli")
                .setUserEmail("vaqifyusibli@gmail.com")
                .SetGender("Male")
                .SetNumber("1551662124")
                .setDateOfBirth("1", "December", "2000")
                .setSubject("Math", "Arts")
                .setHobbie("Sports")
                .SetPage()
                .SetAdress("Poland")
                .setAddressAndSubmit("Haryana", "Karnal")
                .verifyIncorrectCityInTable();
    }
}
