SELECT *
FROM exam
         JOIN STUDENT S on S.ID = EXAM.STUDENT_ID
         join SUBJECT S2 on S2.ID = EXAM.SUBJECT_ID
where S.ID = 1;

SELECT * FROM student where NAME = 'BillBradyKLB';
SELECT * FROM student where NAME LIKE '%Tom%';

SELECT *
FROM exam
         JOIN STUDENT Student on Student.ID = EXAM.STUDENT_ID
         join SUBJECT Subject on Subject.ID = EXAM.SUBJECT_ID
where Student.NAME LIKE '%K%';
-- SELECT count(*)
SELECT *
FROM exam
         JOIN STUDENT Student on Student.ID = EXAM.STUDENT_ID
         join SUBJECT Subject on Subject.ID = EXAM.SUBJECT_ID
where Student.NAME LIKE '%ck%'
  and Student.SURE_NAME LIKE '%ck%'
-- and Subject.NAME LIKE '%at%'
  and SUBJECT_ID = 123;

SELECT pg_size_pretty( pg_total_relation_size('student') );
SELECT pg_size_pretty( pg_total_relation_size('exam') );
SELECT pg_size_pretty( pg_total_relation_size('subject') );
