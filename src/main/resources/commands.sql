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
)

CREATE TABLE SUBJECT
(
    ID    BIGINT NOT NULL,
    NAME  VARCHAR(255),
    TUTOR VARCHAR(255),
    PRIMARY KEY (ID)
)

CREATE TABLE EXAM
(
    ID         BIGINT NOT NULL,
    MARK       VARCHAR(255),
    STUDENT_ID BIGINT,
    SUBJECT_ID BIGINT,
    PRIMARY KEY (ID),
    CONSTRAINT FK_EXAM_STUDENT FOREIGN KEY (STUDENT_ID) REFERENCES STUDENT
)

CREATE SEQUENCE EXAM_SEQ START WITH 1 INCREMENT BY 50
CREATE SEQUENCE STUDENT_SEQ START WITH 1 INCREMENT BY 50
CREATE SEQUENCE SUBJECT_SEQ START WITH 1 INCREMENT BY 50

-- ALTER TABLE IF EXISTS EXAM
--     ADD CONSTRAINT FK_EXAM_STUDENT FOREIGN KEY (STUDENT_ID) REFERENCES STUDENT
ALTER TABLE IF EXISTS EXAM
    ADD CONSTRAINT FK_EXAM_SUBJECT FOREIGN KEY (SUBJECT_ID) REFERENCES SUBJECT
CREATE INDEX myindex ON exam (mark);