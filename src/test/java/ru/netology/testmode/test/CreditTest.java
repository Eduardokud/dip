package ru.netology.testmode.test;

import org.junit.jupiter.api.*;
import ru.netology.testmode.date.DataGenerator;
import ru.netology.testmode.page.CreditPage;
import ru.netology.testmode.page.StartPage;
import ru.netology.testmoe.page.PaymentPage;


import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class CreditTest {
    @Test
    public void BuyTourValidDate() {
        var startPage = open("http://localhost:8080", StartPage.class);
        var paymentPage = StartPage.goToPaymentPage();
        var dateInfo = DataGenerator.getValidCardInfo();
        PaymentPage page = new PaymentPage();
        page.SetValidDate(dateInfo);
    }

    @Test
    public void CreditTourValidDate() {
        var startPage = open("http://localhost:8080", StartPage.class);
        var paymentPage = StartPage.goToCreditPage();
        var dateInfo = DataGenerator.getValidCardInfo();
        CreditPage page = new CreditPage();
        page.SetValidDate(dateInfo);
    }

    @Test
    public void BuyTourInvalidCardNumber() {
        var startPage = open("http://localhost:8080", StartPage.class);
        var paymentPage = StartPage.goToPaymentPage();
        var dateInfo = DataGenerator.getInvalidCardNumber();
        PaymentPage page = new PaymentPage();
        page.SetInvalidCardNumber(dateInfo);
    }
    @Test
    public void CreditTourInvalidCardNumber() {
        var startPage = open("http://localhost:8080", StartPage.class);
        var paymentPage = StartPage.goToCreditPage();
        var dateInfo = DataGenerator.getInvalidCardNumber();
        CreditPage page = new CreditPage();
        page.SetInvalidCardNumber(dateInfo);
    }
    @Test
    public void BuyTourInvalidMonth() {
        var startPage = open("http://localhost:8080", StartPage.class);
        var paymentPage = StartPage.goToPaymentPage();
        var dateInfo = DataGenerator.getInvalidCardMonth();
        PaymentPage page = new PaymentPage();
        page.SetInvalidMonth(dateInfo);
    }
    @Test
    public void BuyTourInvalidYear() {
        var startPage = open("http://localhost:8080", StartPage.class);
        var paymentPage = StartPage.goToPaymentPage();
        var dateInfo = DataGenerator.getInvalidalidCardYear();
        PaymentPage page = new PaymentPage();
        page.SetInvalidYear(dateInfo);
    }
    @Test
    public void CreditTourInvalidMonth() {
        var startPage = open("http://localhost:8080", StartPage.class);
        var paymentPage = StartPage.goToCreditPage();
        var dateInfo = DataGenerator.getInvalidCardMonth();
        CreditPage page = new CreditPage();
        page.SetInvalidMonth(dateInfo);
    }
    @Test
    public void CreditTourInvalidYear() {
        var startPage = open("http://localhost:8080", StartPage.class);
        var paymentPage = StartPage.goToCreditPage();
        var dateInfo = DataGenerator.getInvalidalidCardYear();
        CreditPage page = new CreditPage();
        page.SetInvalidYear(dateInfo);
    }
}
