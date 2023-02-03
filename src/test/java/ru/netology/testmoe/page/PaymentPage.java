package ru.netology.testmoe.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import ru.netology.testmode.date.Card;
import ru.netology.testmode.date.DataGenerator;
import ru.netology.testmode.page.StartPage;

import java.util.Set;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class PaymentPage {
    @FindBy(css = "[class='button__text']")
    private SelenideElement cardNumberField;
    @FindBy(css = "[placeholder='08']")
    private SelenideElement dateMonthField;
    @FindBy(css = "[placeholder='22']")
    private SelenideElement dateYearField;

    ElementsCollection items = $$("[autocomplete='on']");
    private SelenideElement nameField = items.get(4);
    @FindBy(css = "[placeholder='999']")
    private SelenideElement cvvField;
    private SelenideElement continueButton = $(byText("Продолжить"));
    private SelenideElement heading = $(byText("Оплата по карте"));

    public PaymentPage() {
        heading.shouldBe(visible);
    }


    public StartPage SetDate(Card card) {

        cardNumberField.setValue(card.getNumber());
        dateMonthField.setValue(card.getMonth());
        dateYearField.setValue(card.getYear());
        nameField.setValue(card.getName());
        cvvField.setValue(card.getCvv());
        continueButton.click();
        return new StartPage();


    }

}


//private void setDate(DataGenerator.Month month){
// dateMonthField.setValue((CharSequence) DataGenerator.getMonth(2));
//dateYearField.setValue(DataGenerator.generateYear(3));
//}









