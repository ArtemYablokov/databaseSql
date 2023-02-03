package com.yablokovs.databasesql.service;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class Util {

    public String generateRandomStringJava8() {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        return generatedString;
    }

    public String generateRandomStringApache(int length) {
        boolean useLetters = true;
        boolean useNumbers = false;
        String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);

        return generatedString;
    }

    public List<String> provideNames() {
        return List.of("Tom", "Julian", "Danny", "Donta", "Bill",
                "Rob", "Darrel", "Richard", "Randy", "Jerry");
    }

    public List<String> provideSecondNames() {
        return List.of("Brady", "Edelman", "Amendola", "Hightower", "Belicheckl",
                "Gronkowski", "Revis", "Sherman", "Moss", "Rice");
    }

    public List<String> provideSubjName() {
        return List.of("Math", "Chemistry", "History", "Biology", "Physic",
                "Psychology", "Economic", "Design", "Writing", "Presenting");
    }
}
