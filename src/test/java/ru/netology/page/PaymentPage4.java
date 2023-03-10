package ru.netology.page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import ru.netology.data.DataGenerator;

import static com.codeborne.selenide.Condition.ownText;
import static com.codeborne.selenide.Selenide.*;

public class PaymentPage4 {
    private SelenideElement buyButton = $x("//span[text()=\"Купить\"]");
    private SelenideElement cardNumberField = $("input[placeholder='0000 0000 0000 0000']");
    private SelenideElement monthField = $("input[placeholder='08']");
    private SelenideElement yearField = $("input[placeholder='22']");
    private ElementsCollection emptyField = $$(".input__control");
    private SelenideElement cvcCodeField = $("input[placeholder='999']");
    private SelenideElement errorField = $(".input__sub");
    private SelenideElement continueButton = $x("//span[text()=\"Продолжить\"]");
    private ElementsCollection title = $$("h3");

    public PaymentPage4() {
        buyButton.click(); // тестируем функционал "Купить"
        title.get(1).should(ownText("Оплата по карте"));

        // вводим невалидное значение в поле "Год" (до 21 года)
        cardNumberField.setValue(DataGenerator.generateCardNumber());
        monthField.setValue(DataGenerator.generateMonth());
        yearField.setValue(DataGenerator.generateInvalidYear());
        emptyField.get(3).setValue(DataGenerator.generateName("ru"));
        cvcCodeField.setValue(DataGenerator.generateCvcCode());
        continueButton.click();
        errorField.should(ownText("Истёк срок действия карты"));
    }
}
