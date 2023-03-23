package ru.netology.testmode.data;

import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DataGenerator {
    private DataGenerator() {
    }

    private static Faker fakerEn = new Faker(new Locale("en"));

    public static String getRandomCardNumber() {
        return fakerEn.business().creditCardNumber();
    }

    public static String getValidMonth() {
        String validMonth = LocalDate.now().format(DateTimeFormatter.ofPattern("MM"));
        return validMonth;
    }


    public static String getValidName() {
        return fakerEn.name().firstName() + " " + fakerEn.name().lastName();
    }

    public static String getValidCvv() {
        return fakerEn.number().digits(3);
    }

    public static String getValidCardNumber() {
        return "4444 4444 4444 4441";
    }

    public static Card getValidCardInfo() {
        return new Card(getValidCardNumber(), getValidMonth(), getShiftedYear(0), getValidName(), getValidCvv());
    }

    public static Card getInvalidCardNumber() {
        return new Card(getRandomCardNumber(), getValidMonth(), getShiftedYear(0), getValidName(), getValidCvv());
    }

    public static String getInvalidMonth() {
        return "13";
    }

    public static String getShiftedYear(int year) {
        String year1 = LocalDate.now().plusYears(year).format(DateTimeFormatter.ofPattern("yy"));
        return year1;
    }

    public static Card getInvalidCardMonth() {
        return new Card(getValidCardNumber(), getInvalidMonth(), getShiftedYear(0), getValidName(), getValidCvv());
    }

    public static Card getInvalidalidCardYear() {
        return new Card(getValidCardNumber(), getValidMonth(), getShiftedYear(6), getValidName(), getValidCvv());
    }
}
