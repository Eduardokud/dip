package ru.netology.testmode.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import ru.netology.testmode.data.Card;
import ru.netology.testmode.data.DataGenerator;
import ru.netology.testmode.page.StartPage;

import java.time.Duration;
import java.util.Set;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class PaymentPage {
    private SelenideElement cardNumberField = $("[placeholder='0000 0000 0000 0000']");
    private SelenideElement dateMonthField = $("[placeholder='08']");
    private SelenideElement dateYearField = $("[placeholder='22']");
    ElementsCollection items = $$("[autocomplete='on']");
    private SelenideElement nameField = items.get(4);

    private SelenideElement cvvField = $("[placeholder='999']");
    private SelenideElement continueButton = $(byText("Продолжить"));
    private SelenideElement heading = $(byText("Оплата по карте"));
    private SelenideElement successfully = $(byText("Успешно"));
    private SelenideElement errormessenge = $(byText("Ошибка"));
    private SelenideElement errorMonthmessege = $(byText("Неверно указан срок действия карты"));
    private SelenideElement errorYearmessege = $(byText("Неверно указан срок действия карты"));

    public PaymentPage() {
        heading.shouldBe(visible);
    }

    public void setData(Card info) {
        cardNumberField.setValue(info.getNumber());
        dateMonthField.setValue(info.getMonth());
        dateYearField.setValue(info.getYear());
        nameField.setValue(info.getName());
        cvvField.setValue(info.getCvv());
        continueButton.click();
    }

    public void setValidDate(Card info) {
        setData(info);
        successfully.shouldHave(exactText("Успешно"), Duration.ofSeconds(15)).shouldBe(visible);
    }

    public void setInvalidCardNumber(Card info) {
        setData(info);
        errormessenge.shouldHave(exactText("Ошибка"), Duration.ofSeconds(15)).shouldBe(visible);
    }

    public void setInvalidMonth(Card info) {
        setData(info);
        errorMonthmessege.shouldHave(exactText("Неверно указан срок действия карты"), Duration.ofSeconds(15)).shouldBe(visible);
    }

    public void setInvalidYear(Card info) {
        setData(info);
        errorYearmessege.shouldHave(exactText("Неверно указан срок действия карты"), Duration.ofSeconds(15)).shouldBe(visible);
    }


}












