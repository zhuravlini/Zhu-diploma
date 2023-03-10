package ru.netology.data;

import com.github.javafaker.Faker;

import java.util.Locale;
import java.util.Random;

public class DataGenerator {
    private DataGenerator() {
    }

    public static String generateCardNumber() {
        Faker faker = new Faker();
        String cardNumber = String.valueOf(faker.number().randomNumber(16, true));
        return cardNumber;
    }

    public static String generateInvalidCardNumber() {
        Faker faker = new Faker();
        String invalidCardNumber = String.valueOf(faker.number().randomNumber(15, true));
        return invalidCardNumber;
    }

    public static String generateMonth() {
        final String[] months = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};
        Random random = new Random();
        int index = random.nextInt(months.length);
        String month = months[index];
        return month;
    }

    public static String generateInvalidMonth() {
        Faker faker = new Faker();
        String invalidMonth = String.valueOf(faker.number().numberBetween(13, 99));
        return invalidMonth;
    }

    public static String generateYear() {
        final String[] years = {"24", "25", "26", "27"};
        Random random = new Random();
        int index = random.nextInt(years.length);
        String year = years[index];
        return year;
    }

    public static String generateInvalidYear() {
        Faker faker = new Faker();
        String invalidMonth = String.valueOf(faker.number().numberBetween(01, 22));
        return invalidMonth;
    }

    public static String generateName(String locale) {
        Faker faker = new Faker(new Locale(locale));
        String name = faker.name().fullName().replace('ё', 'е');
        return name;
    }

    public static String generateCvcCode() {
        Faker faker = new Faker();
        String cvc = String.valueOf(faker.number().randomNumber(3, true));
        return cvc;
    }

    public static String generateInvalidCvcCode() {
        Faker faker = new Faker();
        String invalidCvc = String.valueOf(faker.number().randomNumber(2, true));
        return invalidCvc;
    }
}
