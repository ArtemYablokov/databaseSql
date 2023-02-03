package com.yablokovs.databasesql.repo;

import com.yablokovs.databasesql.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<Student, Long> {
}
