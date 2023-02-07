drop index if exists idx_student_name;
drop index if exists idx_exam_student_id;

EXPLAIN ANALYSE
    SELECT * FROM student AS s
    JOIN exam AS e on s.id = e.student_id
    WHERE NAME = 'wANJerryMosshmh';

CREATE index idx_student_name ON STUDENT (name);
CREATE index idx_exam_student_id ON exam USING gin (student_id);

EXPLAIN ANALYSE
    SELECT * FROM student AS s
    JOIN exam AS e on s.id = e.student_id
    WHERE NAME = 'wANJerryMosshmh';

drop index idx_student_name;
drop index idx_exam_student_id;
