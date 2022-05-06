package ru.daniilshat;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.daniilshat.pages.RegForm;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class RegFormTest {
    // Vanilla variables and variables with java-faker //
    Faker faker = new Faker();

    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String checkName = firstName + " " + lastName;
    String email = faker.internet().emailAddress();
    String mobile = "0123456789";
    String month = "January";
    String year = "1999";
    String fullDate = "01 " + month + "," + year;
    String subject = "Maths";
    String address = faker.address().fullAddress();
    String hobbie = "Reading";
    String imgPath = "img/1.jpg";
    String state = "NCR";
    String city = "Delhi";
    String gender = "Other";
    String finalHeader = "Thanks for submitting the form";

    RegForm regFormPage = new RegForm();
    
    @BeforeAll
    static void setUP() {
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl =("https://demoqa.com");
    }

    @Test
    // Fill the form with data from variables //
    void fillRegForm() {
        regFormPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(email)
                .setGender(gender)
                .setNumber(mobile)
                .setBirthDate(month, year)
                .setSubject(subject)
                .setHobbies(hobbie)
                .uploadUserImage(imgPath)
                .setAddress(address)
                .stateAndCitySet(state, city);

        // Submit button //
        $("#submit").click();

        // Some Checks //

        // Check header of table
        regFormPage.checkResultHeader(finalHeader);

        // Check data in the table
        regFormPage.checkFirstAndLastName(checkName)
                .checkEmail(email)
                .checkGender(gender)
                .checkMobile(mobile)
                .checkDate(fullDate)
                .checkSubject(subject)
                .checkHobbie("Reading")
                .checkFilePath("1.jpg")
                .checkAddress(address)
                .checkStateAndCity("NCR Delhi");

        // Close the window //
        $("#closeLargeModal").click();
    }
}
