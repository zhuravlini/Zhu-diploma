package ru.netology.test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.page.*;

import static com.codeborne.selenide.Selenide.open;

public class CreditNegativeTests {

    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }

    @BeforeEach
    public void setUp() {
        open("http://localhost:8080");
        Configuration.holdBrowserOpen = true;
    }

    @Test // пользователь оставил пустыми все поля
    public void shouldReturnErrorIfAllFieldsEmpty() { var creditPage = new CreditPage(); }

    @Test // пользователь ввел невалидный номер карты (13 чисел)
    public void shouldReturnErrorIfCardNumberInvalid() {
        var creditPage = new CreditPage2();
    }

    @Test // пользователь ввел невалидное значение в поле "Месяц" (2х-значное число, больше 12)
    public void shouldReturnErrorIfMonthInvalid() {
        var creditPage = new CreditPage3();
    }

    @Test // пользователь ввел невалидное значение в поле "Год" (до 21 года)
    public void shouldReturnErrorIfYearInvalid() {
        var creditPage = new CreditPage4();
    }

    @Test // пользователь ввел невалидное значение в поле "Владелец" (цифры)
    public void shouldReturnErrorIfOwnerInvalid() {
        var creditPage = new CreditPage5();
    }

    @Test // пользователь ввел невалидное значение в поле "CVC" (2 цифры)
    public void shouldReturnErrorIfCVCInvalid() {
        var creditPage = new CreditPage6();
    }
}

