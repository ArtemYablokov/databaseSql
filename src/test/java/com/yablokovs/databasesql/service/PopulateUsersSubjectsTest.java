package com.yablokovs.databasesql.service;

import com.yablokovs.databasesql.model.Exam;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@SpringBootTest
class PopulateUsersSubjectsTest {

    @Autowired
    PopulateUsers populateUsers;

    @Autowired
    PopulateSubjects populateSubjects;

    @Autowired
    MarksService marksService;

//    @Test
    public void save100KUsers() {
        for (int i = 0; i < 100; i++) {
            populateUsers.populate1KUsers();
        }
    }

    @Test
    public void save1MilStudents() {
        for (int i = 0; i < 1000; i++) {
            populateUsers.populate1KUsers();
        }
    }

    @Test
    public void testStream() {
        Exam exam = new Exam();
        Exam exam2 = new Exam();
        Stream<Exam> exams = Stream.of(exam, exam2);
        List<Exam> collect = exams.limit(1)
                .peek(e -> e.setId(0L))
                .toList();
        Exam exam1 = collect.get(0);
        int n = 0;

    }

    @Test
    public void save1KSubject(){
        populateSubjects.populate1KSubject();
    }

    @Test
    public void populateMarks() {
        for (int i = 1; i < 1_000_000 + 1; i++) {
            marksService.populate1Exam(i);
        }
    }
}