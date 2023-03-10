package ru.netology.test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import ru.netology.data.DBHelper;
import ru.netology.data.DataHelper;
import ru.netology.page.CreditPageAccept;
import ru.netology.page.CreditPageDecline;

import static com.codeborne.selenide.Selenide.open;

public class CreditPositiveTests {
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

    @Test // пользователь ввел валидные данные во все поля - операция д. б. одобрена банком
    public void shouldGetBankAcceptance() {

        var creditPageAccept = new CreditPageAccept();
        String actual = DBHelper.getCreditStatus();
        String expected = DataHelper.getApproved().getStatus();
        Assertions.assertEquals(expected, actual);
    }

    @Test // пользователь ввел валидные данные во все поля - операция д. б. отклонена банком
    public void shouldGetBankRejection() {

        var creditPageAccept = new CreditPageDecline();
        String actual = DBHelper.getCreditStatus();
        String expected = DataHelper.getDeclined().getStatus();
        Assertions.assertEquals(expected, actual);
    }
}
