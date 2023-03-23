package ru.netology.testmode.test;

import org.junit.jupiter.api.*;
import ru.netology.testmode.data.DataGenerator;
import ru.netology.testmode.page.CreditPage;
import ru.netology.testmode.page.StartPage;
import ru.netology.testmode.page.PaymentPage;


import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class CreditTest {


    @Test
    public void creditTourValidDate() {
        var startPage = open("http://localhost:8080", StartPage.class);
        var paymentPage = StartPage.goToCreditPage();
        var dateInfo = DataGenerator.getValidCardInfo();
        CreditPage page = new CreditPage();
        page.setValidDate(dateInfo);
    }

    @Test
    public void creditTourInvalidCardNumber() {
        var startPage = open("http://localhost:8080", StartPage.class);
        var paymentPage = StartPage.goToCreditPage();
        var dateInfo = DataGenerator.getInvalidCardNumber();
        CreditPage page = new CreditPage();
        page.setInvalidCardNumber(dateInfo);
    }

    @Test
    public void creditTourInvalidMonth() {
        var startPage = open("http://localhost:8080", StartPage.class);
        var paymentPage = StartPage.goToCreditPage();
        var dateInfo = DataGenerator.getInvalidCardMonth();
        CreditPage page = new CreditPage();
        page.setInvalidMonth(dateInfo);
    }

    @Test
    public void creditTourInvalidYear() {
        var startPage = open("http://localhost:8080", StartPage.class);
        var paymentPage = StartPage.goToCreditPage();
        var dateInfo = DataGenerator.getInvalidalidCardYear();
        CreditPage page = new CreditPage();
        page.setInvalidYear(dateInfo);
    }
}
