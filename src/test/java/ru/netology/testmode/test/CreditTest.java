package ru.netology.testmode.test;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.nio.channels.Selector;
import java.time.Duration;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class CreditTest {
    @BeforeEach
    void setup() {
        open("http://localhost:8080");
    }

    @Test
    void  BuyTourValidCardNumber(){
        var CardNumber = "4444444444444441";
        var cvv = DataGenerator.generateCvv();
        var mmOfEnd = 2;
        var mmTry = DataGenerator.generateMonth(mmOfEnd);
        var yeOfEnd =3;
        var yeTry= DataGenerator.generateYear(yeOfEnd);
        var rrrrr= DataGenerator.generateinvalidCardNumber();
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
        var CardNumber = DataGenerator.generateinvalidCardNumber();
        var cvv = DataGenerator.generateCvv();
        var mmOfEnd = 2;
        var mmTry = DataGenerator.generateMonth(mmOfEnd);
        var yeOfEnd =3;
        var yeTry= DataGenerator.generateYear(yeOfEnd);
        var rrrrr= DataGenerator.generateinvalidCardNumber();
        $("[class='button__text']").click();
        $("[placeholder='0000 0000 0000 0000']").setValue(CardNumber);
        $("[placeholder='08']").setValue(mmTry);
        $("[placeholder='22']").setValue(yeTry);
        ElementsCollection items = $$("[autocomplete='on']");
        items.get(4).setValue(DataGenerator.generateName("ru"));
        $("[placeholder='999']").setValue(cvv);
        $(byText("Продолжить")).click();
        $("[class='notification__title']").shouldBe(Condition.visible, Duration.ofSeconds(10));
    }
}
