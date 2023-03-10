package ru.netology.testmode.page;

import com.codeborne.selenide.SelenideElement;
import ru.netology.testmode.page.PaymentPage;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$$;

public class StartPage {
    private SelenideElement heading = $$("h2").find(text("Путешествие дня"));
    private static SelenideElement buyButton = $$("button").find(exactText("Купить"));
    private static SelenideElement creditButton = $$("button").find(exactText("Купить в кредит"));

    public StartPage() {
        heading.shouldBe(visible);
    }

    public static PaymentPage goToPaymentPage() {
        buyButton.click();
        return new PaymentPage();
    }

    public static CreditPage goToCreditPage() {
        creditButton.click();
        return new CreditPage();
    }
}




