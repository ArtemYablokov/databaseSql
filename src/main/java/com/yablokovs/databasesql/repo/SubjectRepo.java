package com.yablokovs.databasesql.repo;

import com.yablokovs.databasesql.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepo extends JpaRepository<Subject, Long> {
}
