package com.yablokovs.databasesql.service;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Random;

@Service
public class MarksService {

    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    public void populate1Exam(long id) {

        Random random = new Random();
        int mark = random.nextInt(1, 5 + 1);
        int student_id = random.nextInt(1, 100_000 + 1);
        int subject_id = random.nextInt(1, 1_000 + 1);
        Query nativeQuery = entityManager.createNativeQuery(
                "INSERT INTO exam (id, student_id, subject_id, mark) VALUES ('" + id + "','" + student_id + "', '" + subject_id + "', '" + mark + "')");
        nativeQuery.executeUpdate();

    }
}
