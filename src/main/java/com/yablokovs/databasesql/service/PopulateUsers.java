package com.yablokovs.databasesql.service;

import com.yablokovs.databasesql.model.Student;
import com.yablokovs.databasesql.repo.UserRepo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PopulateUsers {

    private final UserRepo userRepo;
    private final Util util;

    public PopulateUsers(UserRepo userRepo, Util util) {
        this.userRepo = userRepo;
        this.util = util;
    }

    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    public void populateUsers() {

    }

    public void populate1KUsers() {
        List<String> names = util.provideNames();
        List<String> secondNames = util.provideSecondNames();

        for (int i = 0; i < 10; i++) {
            for (var name : names) {
                for (var secondName : secondNames) {
                    userRepo.save(new Student(
                            util.generateRandomStringApache(3)
                                    + name + secondName +
                                    util.generateRandomStringApache(3),
                            util.generateRandomStringApache(10)));
                }
            }
        }
    }
}
