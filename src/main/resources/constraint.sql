ALTER TABLE student
    ADD
        CONSTRAINT proper_name
            CHECK (student.name !~ '[@|#|$]');
-- почему то наложил ограничение только на #

select * from student where name like '%@|#|$%';
select * from student where name like '@|#|$';

-- LIKE doesn't use REG-EX

select * from student where name SIMILAR TO '@|#|$';
select * from student where name SIMILAR TO '%@|#|$%';
select count(*) from student where name NOT SIMILAR TO '@|#|$';

