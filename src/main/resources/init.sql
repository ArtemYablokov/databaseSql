DROP TABLE if exists exam;
DROP TABLE if exists student;
DROP TABLE if exists subject;

CREATE TABLE STUDENT
(
    ID            BIGINT NOT NULL,
    CREATED_AT    TIMESTAMP(6),
    DATE_OF_BIRTH TIMESTAMP(6),
    NAME          VARCHAR(255),
    PHONE_NUMBER  VARCHAR(255),
    PRIMARY_SKILL VARCHAR(255),
    SURE_NAME     VARCHAR(255),
    UPDATED_AT    TIMESTAMP(6),
    PRIMARY KEY (ID)
);

CREATE TABLE SUBJECT
(
    ID    BIGINT NOT NULL,
    NAME  VARCHAR(255),
    TUTOR VARCHAR(255),
    PRIMARY KEY (ID)
);

CREATE TABLE EXAM
(
    ID         BIGINT NOT NULL,
    MARK       BIGINT,
    STUDENT_ID BIGINT,
    SUBJECT_ID BIGINT,
    PRIMARY KEY (ID)
);

ALTER TABLE IF EXISTS EXAM
    ADD CONSTRAINT fk_exam_student FOREIGN KEY (STUDENT_ID) REFERENCES STUDENT;
-- alter table exam drop constraint fk_exam_student;

ALTER TABLE IF EXISTS EXAM
    ADD CONSTRAINT FK_EXAM_SUBJECT FOREIGN KEY (SUBJECT_ID) REFERENCES SUBJECT;

DROP SEQUENCE IF EXISTS EXAM_SEQ;
drop sequence if exists STUDENT_SEQ;
drop sequence if exists SUBJECT_SEQ;

CREATE SEQUENCE EXAM_SEQ START WITH 1 INCREMENT BY 50;
CREATE SEQUENCE STUDENT_SEQ START WITH 1 INCREMENT BY 50;
CREATE SEQUENCE SUBJECT_SEQ START WITH 1 INCREMENT BY 50;

SELECT count(*) FROM student;
SELECT count(*) FROM subject;
SELECT count(*) FROM exam;

-- INFO
SELECT * FROM information_schema.columns WHERE table_name = 'student';
SELECT tablename, indexname, indexdef FROM pg_indexes WHERE schemaname = 'public' ORDER BY tablename, indexname;