CREATE OR REPLACE FUNCTION public.update_modification_time()
    RETURNS trigger AS
$BODY$
BEGIN
    NEW.updated_at = now();
    RETURN NEW;
END;
$BODY$
    LANGUAGE plpgsql VOLATILE
                     COST 100;

CREATE TRIGGER update_modification_time_trigger
    BEFORE UPDATE
    ON student
    FOR EACH ROW
EXECUTE PROCEDURE public.update_modification_time();


create or replace function get_average_mark_for_student(_student_name text) returns integer
    cost 10
    language plpgsql
as
$$
BEGIN
    SELECT avg(mark)
    from exam e
             join student s on s.id = e.student_id
    where s.name = _student_name;
END
$$;

create or replace function get_average_mark_for_subject(_subject_name text) returns integer
    cost 10
    language plpgsql
as
$$
BEGIN
    SELECT avg(mark)
    from exam e
             join subject s on e.subject_id = s.id
    where s.name = _subject_name;
END
$$;

create or replace function get_students_in_risk_zone() returns TABLE(student_name varchar)
    cost 10
    language plpgsql
as
$$
BEGIN
    RETURN QUERY
    SELECT s.name
    from student s join exam e on s.id = e.student_id
    where e.mark <= 3
    group by s.name
    having count(*) >= 2;
END
$$;

select * from get_students_in_risk_zone();



