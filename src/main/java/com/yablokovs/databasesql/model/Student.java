package com.yablokovs.databasesql.model;

//import jakarta.persistence.*;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
// TODO: 01.10.2022 check @DATA vs HIBERNATE
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@NoArgsConstructor
@Table(name = "student")
public class Student {
    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_generator")
//    @SequenceGenerator(name = "sequence_generator")
    @GeneratedValue(/*strategy = GenerationType.TABLE*/)
    private Long id;

    @Column(name = "name")
    private String name;
    private String sureName;
    private String phoneNumber;
    private String primarySkill;

    LocalDateTime dateOfBirth;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    public Set<Exam> exams = new HashSet<>();

    @CreatedDate
    LocalDateTime createdAt;

    @LastModifiedDate
    Timestamp updatedAt;

}
