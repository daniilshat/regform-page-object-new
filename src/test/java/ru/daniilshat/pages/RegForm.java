package ru.daniilshat.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegForm {
    // Locators
    SelenideElement firstNameInput = $("#firstName");
    SelenideElement lastNameInput = $("#lastName");
    SelenideElement userEmailInput = $("#userEmail");
    SelenideElement userNumberInput = $("#userNumber");
    SelenideElement genderInput = $("#genterWrapper");
    SelenideElement userSubjectInput = $("#subjectsInput");
    SelenideElement hobbiesInput = $("#hobbiesWrapper");
    SelenideElement birthInput = $("#dateOfBirthInput");
    SelenideElement addressInput = $("#currentAddress");
    SelenideElement pictureUpload = $("#uploadPicture");
    SelenideElement resultTable = $("#example-modal-sizes-title-lg");
    SelenideElement srcTable = $(".modal-body");

    // Actions
    public RegForm openPage() {
        open("/automation-practice-form");
        return this;
    }

    public RegForm setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public RegForm setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public RegForm setUserEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    public RegForm setGender(String value) {
        genderInput.$(byText(value)).click();
        return this;
    }

    public RegForm setNumber(String value) {
        userNumberInput.setValue(value);
        return this;
    }

    public RegForm setSubject(String value) {
        userSubjectInput.setValue(value).pressEnter();
        return this;
    }

    public RegForm setHobbies(String value) {
        hobbiesInput.$(byText(value)).click();
        return this;
    }

    public RegForm uploadUserImage(String value) {
        pictureUpload.uploadFromClasspath(value);
        return this;
    }

    public RegForm setAddress(String value) {
        addressInput.setValue(value);
        return this;
    }

    public RegForm stateAndCitySet(String state, String city) {
        $("#state").click();
        $(byText(state)).click();
        $("#city").click();
        $(byText(city)).click();
        return this;
    }

    public RegForm setBirthDate(String month, String year) {
        birthInput.click();
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $("[aria-label$='" + month + " 1st, " + year + "']").click();
        return this;
    }

    // Some checks //
    public RegForm checkResultHeader(String value) {
        resultTable.shouldHave(text(value));
        return this;
    }

    public RegForm checkFirstAndLastName(String value) {
        srcTable.shouldHave(text(value));
        return this;
    }

    public RegForm checkEmail(String value) {
        srcTable.shouldHave(text(value));
        return this;
    }

    public RegForm checkGender(String value) {
        srcTable.shouldHave(text(value));
        return this;
    }

    public RegForm checkMobile(String value) {
        srcTable.shouldHave(text(value));
        return this;
    }

    public RegForm checkDate(String value) {
        srcTable.shouldHave(text(value));
        return this;
    }

    public RegForm checkSubject(String value) {
        srcTable.shouldHave(text(value));
        return this;
    }

    public RegForm checkHobbie(String value) {
        srcTable.shouldHave(text(value));
        return this;
    }

    public RegForm checkFilePath(String value) {
        srcTable.shouldHave(text(value));
        return this;
    }

    public RegForm checkAddress(String value) {
        srcTable.shouldHave(text(value));
        return this;
    }

    public RegForm checkStateAndCity(String value) {
        srcTable.shouldHave(text(value));
        return this;
    }
}
