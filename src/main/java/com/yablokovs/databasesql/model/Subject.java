package com.yablokovs.databasesql.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.HashSet;
import java.util.Set;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@NoArgsConstructor
@Table(name = "subject")
public class Subject {
    @Id
    @GeneratedValue(/*strategy = GenerationType.TABLE*/)
    private Long id;

    @Column(name = "name")
    private String name;
    private String tutor;

    @OneToMany(mappedBy = "subject", cascade = CascadeType.ALL)
    public Set<Exam> exams = new HashSet<>();

}
