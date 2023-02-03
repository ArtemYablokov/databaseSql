
package com.yablokovs.databasesql.service;

import com.yablokovs.databasesql.model.Subject;
import com.yablokovs.databasesql.repo.SubjectRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PopulateSubjects {

    private final SubjectRepo subjectRepo;
    private final Util util;

    public PopulateSubjects(SubjectRepo subjectRepo, Util util) {
        this.subjectRepo = subjectRepo;
        this.util = util;
    }

    public void populate1KSubject() {

        List<String> names = util.provideSubjName();
        List<String> secondNames = util.provideSubjName();

        for (int i = 0; i < 10; i++) {
            for (var name : names) {
                for (var secondName : secondNames) {
                    subjectRepo.save(new Subject(name + secondName + "_" + util.generateRandomStringApache(3)));
                }
            }
        }
    }

}
