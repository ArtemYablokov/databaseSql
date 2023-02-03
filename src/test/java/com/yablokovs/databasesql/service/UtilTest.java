package com.yablokovs.databasesql.service;

import org.junit.jupiter.api.Test;

import java.util.Random;

class UtilTest {

    Util util = new Util();

    @Test
    public void test_givenUsingJava8_whenGeneratingRandomAlphabeticString_thenCorrect() {

        String s = util.generateRandomStringJava8();
        String s1 = util.generateRandomStringApache(10);

        int n = 0;
    }

    @Test
    public void testRandom() {
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            int mark = random.nextInt(1, 5 + 1);
            int student_id = random.nextInt(1, 100_000 + 1);
            int subject_id = random.nextInt(1, 1_000 + 1);

            System.out.printf("mark = " + mark +
                    ", student_id = " + student_id +
                    ", subject_id = " + subject_id
            );
            System.out.println();
        }
    }
}