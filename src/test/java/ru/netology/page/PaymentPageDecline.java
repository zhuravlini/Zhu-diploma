package ru.netology.page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import ru.netology.data.DataGenerator;
import ru.netology.data.DataHelper;

import java.time.Duration;

import static com.codeborne.selenide.Condition.ownText;
import static com.codeborne.selenide.Selenide.*;

public class PaymentPageDecline {
    private SelenideElement buyButton = $x("//span[text()=\"Купить\"]");
    private SelenideElement cardNumberField = $("input[placeholder='0000 0000 0000 0000']");
    private SelenideElement monthField = $("input[placeholder='08']");
    private SelenideElement yearField = $("input[placeholder='22']");
    private ElementsCollection emptyField = $$(".input__control");
    private SelenideElement cvcCodeField = $("input[placeholder='999']");
    private SelenideElement statusField = $(".notification__content");
    private SelenideElement continueButton = $x("//span[text()=\"Продолжить\"]");
    private ElementsCollection title = $$("h3");

    public PaymentPageDecline() {
        buyButton.click(); // тестируем функционал "Купить"
        title.get(1).should(ownText("Оплата по карте"));

        // в поле "Номер карты" вводим номер карты со статусом "Отклонено"
        cardNumberField.setValue(DataHelper.getDeclined().getNumber());
        monthField.setValue(DataGenerator.generateMonth());
        yearField.setValue(DataGenerator.generateYear());
        emptyField.get(3).setValue(DataGenerator.generateName("ru"));
        cvcCodeField.setValue(DataGenerator.generateCvcCode());
        continueButton.click();
        statusField.should(ownText("Ошибка! Банк отказал в проведении операции."), Duration.ofSeconds(30));
    }
}
