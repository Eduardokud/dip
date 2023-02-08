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
    private  SelenideElement cardNumberField = $("[placeholder='0000 0000 0000 0000']");
    private  SelenideElement dateMonthField = $("[placeholder='08']");
    private  SelenideElement dateYearField = $("[placeholder='22']");
     ElementsCollection items = $$("[autocomplete='on']");
    private  SelenideElement nameField = items.get(4);

    private  SelenideElement cvvField=  $("[placeholder='999']");
    private  SelenideElement continueButton = $(byText("Продолжить"));
    private SelenideElement heading = $(byText("Оплата по карте"));
    private  SelenideElement successfully = $(byText("Успешно"));

    public PaymentPage() {
        heading.shouldBe(visible);
    }


  /*  public static void SetValidDate(Card card) {

        cardNumberField.setValue(card.getNumber());
        dateMonthField.setValue(card.getMonth());
        dateYearField.setValue(card.getYear());
        nameField.setValue(card.getName());
        cvvField.setValue(card.getCvv());
        continueButton.click();
        successfully.shouldBe(visible);

    }*/
    public  void  Setlogin(Card info){
        cardNumberField.setValue(info.getNumber());
        dateMonthField.setValue(info.getMonth());
        dateYearField.setValue(info.getYear());
        nameField.setValue(info.getName());
        cvvField.setValue(info.getCvv());
        continueButton.click();
        successfully.shouldHave(exactText("Успешно"), Duration.ofSeconds(15)).shouldBe(visible);
        //return new Verify();
    }

}


//private void setDate(DataGenerator.Month month){
// dateMonthField.setValue((CharSequence) DataGenerator.getMonth(2));
//dateYearField.setValue(DataGenerator.generateYear(3));
//}









