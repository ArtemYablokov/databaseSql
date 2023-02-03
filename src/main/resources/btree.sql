drop index if exists idx_student_name;

EXPLAIN ANALYSE SELECT * FROM student where NAME = 'wANJerryMosshmh';
EXPLAIN ANALYSE SELECT * FROM student where NAME = 'NOTEXISTED';
EXPLAIN ANALYSE SELECT * FROM student where NAME LIKE 'wANJerry%';
EXPLAIN ANALYSE SELECT * FROM student where NAME LIKE '%Jerry%';
EXPLAIN ANALYSE SELECT * FROM student where NAME LIKE '%NOTEXISTED%';

CREATE index idx_student_name ON STUDENT (name);

EXPLAIN ANALYSE SELECT * FROM student where NAME = 'wANJerryMosshmh';
EXPLAIN ANALYSE SELECT * FROM student where NAME = 'NOTEXISTED';
EXPLAIN ANALYSE SELECT * FROM student where NAME LIKE 'wANJerry%';
EXPLAIN ANALYSE SELECT * FROM student where NAME LIKE '%Jerry%';
EXPLAIN ANALYSE SELECT * FROM student where NAME LIKE '%NOTEXISTED%';

drop index idx_student_name;