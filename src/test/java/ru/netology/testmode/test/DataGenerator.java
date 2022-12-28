package ru.netology.testmode.test;

import com.github.javafaker.Faker;
import lombok.Value;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.localStorage;

public class DataGenerator {

    private DataGenerator() {
    }


    public static String generateMonth(int month) {
        String mm = LocalDate.now().plusMonths(month).format(DateTimeFormatter.ofPattern("MM"));
        return mm;
    }
    public static String generateYear(int year) {
        String ye = LocalDate.now().plusYears(year).format(DateTimeFormatter.ofPattern("yy"));
        return ye;
    }
    public static String generateName(String locale) {
        var faker = new Faker(new Locale(locale));
        return faker.name().lastName() + " " + faker.name().firstName();


    }
   public static String generateCvv() {
        int a = 100+ (int) (Math.random()*899);
        String b=Integer.toString(a);
        return b;

   }
   public static String generateinvalidCardNumber() {
         long c = 2000000000000000L + (long) (Math.random()*4000000000000000L);
         String q =Long.toString(c);
         return q;


   }



}
