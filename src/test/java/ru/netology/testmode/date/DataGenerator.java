package ru.netology.testmode.date;

import com.github.javafaker.Faker;
import lombok.Value;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.localStorage;

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

    public static String getValidYear() {
        String validYear = LocalDate.now().format(DateTimeFormatter.ofPattern("yy"));
        return validYear;
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
        return new Card(getValidCardNumber(), getValidMonth(), getValidYear(), getValidName(), getValidCvv());
    }
   //public static Card getValidCardInfo() {
        //return new Card("4444444444444441", "06", "24", "dsfgdgd dgfdg", "911");
    //}









    /* public static Month getMonth(int month) {
        String mm = LocalDate.now().plusMonths(month).format(DateTimeFormatter.ofPattern("MM"));
        return new Month("mm");
    }


    public static Year getYear(int year) {
        String ye = LocalDate.now().plusYears(year).format(DateTimeFormatter.ofPattern("yy"));
        return new Year(ye);
    }
    public static Name getName(String locale) {
        var faker = new Faker(new Locale(locale));
        String n=faker.name().lastName() + " " + faker.name().firstName();
        return new Name (n);


    }
   public static  Cvv getCvv() {
        int a = 100+ (int) (Math.random()*899);
        String b=Integer.toString(a);
        return  new Cvv(b);

   }
   public static String generateInvalidCardNumber() {
         long c = 2000000000000000L + (long) (Math.random()*4000000000000000L);
         String q =Long.toString(c);
         return q;


   }
   public static ValidCardNumber getValidCardNumber(){
        return  new ValidCardNumber("4444444444444441");
   }
   @Value
    public static class ValidCardNumber{
        String cardNumber;

   }
   @Value
    public static class Cvv{
        String Cvv;
   }
   @Value
    public static class Year{
        String year;
   }
   @Value
    public static class Month{
        String month;
   }
   @Value
    public static class Name{
        String name;
   }*/


}
