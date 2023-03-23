package ru.netology.testmode.test;

import org.junit.jupiter.api.Test;
import ru.netology.testmode.data.DataGenerator;
import ru.netology.testmode.page.PaymentPage;
import ru.netology.testmode.page.StartPage;

import static com.codeborne.selenide.Selenide.open;

public class BuyTest {
    @Test
    public void buyTourValidDate() {
        var startPage = open("http://localhost:8080", StartPage.class);
        var paymentPage = StartPage.goToPaymentPage();
        var dateInfo = DataGenerator.getValidCardInfo();
        PaymentPage page = new PaymentPage();
        page.setValidDate(dateInfo);
    }

    @Test
    public void buyTourInvalidCardNumber() {
        var startPage = open("http://localhost:8080", StartPage.class);
        var paymentPage = StartPage.goToPaymentPage();
        var dateInfo = DataGenerator.getInvalidCardNumber();
        PaymentPage page = new PaymentPage();
        page.setInvalidCardNumber(dateInfo);
    }

    @Test
    public void buyTourInvalidMonth() {
        var startPage = open("http://localhost:8080", StartPage.class);
        var paymentPage = StartPage.goToPaymentPage();
        var dateInfo = DataGenerator.getInvalidCardMonth();
        PaymentPage page = new PaymentPage();
        page.setInvalidMonth(dateInfo);
    }

    @Test
    public void buyTourInvalidYear() {
        var startPage = open("http://localhost:8080", StartPage.class);
        var paymentPage = StartPage.goToPaymentPage();
        var dateInfo = DataGenerator.getInvalidalidCardYear();
        PaymentPage page = new PaymentPage();
        page.setInvalidYear(dateInfo);
    }
}
