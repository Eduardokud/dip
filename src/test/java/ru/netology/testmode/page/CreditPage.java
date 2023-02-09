package ru.netology.testmode.page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import ru.netology.testmode.date.Card;

import java.time.Duration;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CreditPage {
    private SelenideElement cardNumberField = $("[placeholder='0000 0000 0000 0000']");
    private SelenideElement dateMonthField = $("[placeholder='08']");
    private SelenideElement dateYearField = $("[placeholder='22']");
    ElementsCollection items = $$("[autocomplete='on']");
    private SelenideElement nameField = items.get(4);

    private SelenideElement cvvField = $("[placeholder='999']");
    private SelenideElement continueButton = $(byText("Продолжить"));
    private SelenideElement heading = $(byText("Кредит по данным карты"));
    private SelenideElement successfully = $(byText("Успешно"));
    private SelenideElement errormessenge = $(byText("Ошибка"));
    private SelenideElement errorMonthmessege = $(byText("Неверно указан срок действия карты"));
    private SelenideElement errorYearmessege = $(byText("Неверно указан срок действия карты"));

    public CreditPage() {
        heading.shouldBe(visible);
    }

    public void SetValidDate(Card info) {
        cardNumberField.setValue(info.getNumber());
        dateMonthField.setValue(info.getMonth());
        dateYearField.setValue(info.getYear());
        nameField.setValue(info.getName());
        cvvField.setValue(info.getCvv());
        continueButton.click();
        successfully.shouldHave(exactText("Успешно"), Duration.ofSeconds(15)).shouldBe(visible);
    }

    public void SetInvalidCardNumber(Card info) {
        cardNumberField.setValue(info.getNumber());
        dateMonthField.setValue(info.getMonth());
        dateYearField.setValue(info.getYear());
        nameField.setValue(info.getName());
        cvvField.setValue(info.getCvv());
        continueButton.click();
        errormessenge.shouldHave(exactText("Ошибка"), Duration.ofSeconds(15)).shouldBe(visible);
    }

    public void SetInvalidMonth(Card info) {
        cardNumberField.setValue(info.getNumber());
        dateMonthField.setValue(info.getMonth());
        dateYearField.setValue(info.getYear());
        nameField.setValue(info.getName());
        cvvField.setValue(info.getCvv());
        continueButton.click();
        errorMonthmessege.shouldHave(exactText("Неверно указан срок действия карты"), Duration.ofSeconds(15)).shouldBe(visible);
    }

    public void SetInvalidYear(Card info) {
        cardNumberField.setValue(info.getNumber());
        dateMonthField.setValue(info.getMonth());
        dateYearField.setValue(info.getYear());
        nameField.setValue(info.getName());
        cvvField.setValue(info.getCvv());
        continueButton.click();
        errorYearmessege.shouldHave(exactText("Неверно указан срок действия карты"), Duration.ofSeconds(15)).shouldBe(visible);
    }
}
