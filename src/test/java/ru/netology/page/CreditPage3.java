package ru.netology.page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import ru.netology.data.DataGenerator;

import static com.codeborne.selenide.Condition.ownText;
import static com.codeborne.selenide.Selenide.*;

public class CreditPage3 {
    private SelenideElement creditButton = $x("//span[text()=\"Купить в кредит\"]");
    private SelenideElement cardNumberField = $("input[placeholder='0000 0000 0000 0000']");
    private SelenideElement monthField = $("input[placeholder='08']");
    private SelenideElement yearField = $("input[placeholder='22']");
    private ElementsCollection emptyField = $$(".input__control");
    private SelenideElement cvcCodeField = $("input[placeholder='999']");
    private SelenideElement errorField = $(".input__sub");
    private SelenideElement continueButton = $x("//span[text()=\"Продолжить\"]");
    private ElementsCollection title = $$("h3");

    public CreditPage3() {
        creditButton.click(); // тестируем функционал "Купить в кредит"
        title.get(1).should(ownText("Кредит по данным карты"));

        // вводим невалидное значение в поле "Месяц" (2х-значное число, больше 12)
        cardNumberField.setValue(DataGenerator.generateCardNumber());
        monthField.setValue(DataGenerator.generateInvalidMonth());
        yearField.setValue(DataGenerator.generateYear());
        emptyField.get(3).setValue(DataGenerator.generateName("ru"));
        cvcCodeField.setValue(DataGenerator.generateCvcCode());
        continueButton.click();
        errorField.should(ownText("Неверно указан срок действия карты"));
    }
}
