ALTER TABLE student
    ADD
        CONSTRAINT proper_name
            CHECK (student.name !~ '[@|#|$]');

-- select * from student where name like '%@|#|$%';
-- select * from student where name like '@|#|$';
--
-- select * from student where name SIMILAR TO '@|#|$';
-- select * from student where name SIMILAR TO '%@|#|$%';
-- select count(*) from student where name NOT SIMILAR TO '@|#|$';

