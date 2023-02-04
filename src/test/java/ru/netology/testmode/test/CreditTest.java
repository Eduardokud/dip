package ru.netology.testmode.test;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.logevents.SelenideLogger;
import org.junit.jupiter.api.*;
import ru.netology.testmode.date.Card;
import ru.netology.testmode.date.DataGenerator;
import ru.netology.testmoe.page.PaymentPage;


import static com.codeborne.selenide.Selenide.open;


public class CreditTest {
    @Test
    public void validDate() {
        var paymentPage = open("http://localhost:8080", PaymentPage.class);
        var dateInfo = DataGenerator.getValidCardInfo();
        var setDate = paymentPage.SetDate(dateInfo);


    }
        /*var CardNumber = "4444444444444441";
        var cvv = DataGenerator.generateCvv();
        var mmOfEnd = 2;
        var mmTry = DataGenerator.generateMonth(mmOfEnd);
        var yeOfEnd =3;
        var yeTry= DataGenerator.generateYear(yeOfEnd);

        $("[class='button__text']").click();
        $("[placeholder='0000 0000 0000 0000']").setValue(CardNumber);
        $("[placeholder='08']").setValue(mmTry);
        $("[placeholder='22']").setValue(yeTry);
        ElementsCollection items = $$("[autocomplete='on']");
        items.get(4).setValue(DataGenerator.generateName("ru"));
        $("[placeholder='999']").setValue(cvv);
        $(byText("Продолжить")).click();
        $("[class='icon-button__text']").shouldBe(Condition.visible, Duration.ofSeconds(10));
    }
    @Test
    void  BuyTourInvalidCardNumber(){
        var CardNumber = DataGenerator.generateInvalidCardNumber();
        var cvv = DataGenerator.generateCvv();
        var mmOfEnd = 2;
        var mmTry = DataGenerator.generateMonth(mmOfEnd);
        var yeOfEnd =3;
        var yeTry= DataGenerator.generateYear(yeOfEnd);
        $("[class='button__text']").click();
        $("[placeholder='0000 0000 0000 0000']").setValue(CardNumber);
        $("[placeholder='08']").setValue(mmTry);
        $("[placeholder='22']").setValue(yeTry);
        ElementsCollection items = $$("[autocomplete='on']");
        items.get(4).setValue(DataGenerator.generateName("ru"));
        $("[placeholder='999']").setValue(cvv);
        $(byText("Продолжить")).click();
        $("[class='notification__title']").shouldBe(Condition.visible, Duration.ofSeconds(10));
    } */
}