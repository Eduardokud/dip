package ru.netology.testmoe.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import ru.netology.testmode.date.Card;
import ru.netology.testmode.date.DataGenerator;
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


//private void setDate(DataGenerator.Month month){
// dateMonthField.setValue((CharSequence) DataGenerator.getMonth(2));
//dateYearField.setValue(DataGenerator.generateYear(3));
//}









