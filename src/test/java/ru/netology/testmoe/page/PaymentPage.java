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
    private static SelenideElement cardNumberField;
    @FindBy(css = "[placeholder='08']")
    private static SelenideElement dateMonthField;
    @FindBy(css = "[placeholder='22']")
    private static SelenideElement dateYearField;

    static ElementsCollection items = $$("[autocomplete='on']");
    private static SelenideElement nameField = items.get(4);
    @FindBy(css = "[placeholder='999']")
    private static SelenideElement cvvField;
    private static SelenideElement continueButton = $(byText("Продолжить"));
    private SelenideElement heading = $(byText("Оплата по карте"));
    private static SelenideElement successfully = $(byText("Успешно"));

    public PaymentPage() {
        heading.shouldBe(visible);
    }


    public static void SetValidDate(Card card) {

        cardNumberField.setValue(card.getNumber());
        dateMonthField.setValue(card.getMonth());
        dateYearField.setValue(card.getYear());
        nameField.setValue(card.getName());
        cvvField.setValue(card.getCvv());
        continueButton.click();
        successfully.shouldBe(visible);



    }

}


//private void setDate(DataGenerator.Month month){
// dateMonthField.setValue((CharSequence) DataGenerator.getMonth(2));
//dateYearField.setValue(DataGenerator.generateYear(3));
//}









