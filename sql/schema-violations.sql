
-- Task 5: Fixed-schema experiments
-- Run each of the first eight statements separately.
-- Each one is expected to fail.

USE university_db;

-- 1. Column that does not exist
INSERT INTO student (student_code, full_name, email, phone)
VALUES ('S010', 'Test One', 'test1@example.com', '0771234567');

-- 2. Required NOT NULL column left out
INSERT INTO student (student_code, full_name)
VALUES ('S011', 'Test Two');

-- 3. Wrong data type
INSERT INTO course (code, title, credits, lecturer_id)
VALUES ('CS301', 'Test Course', 'three', 1);

-- 4. Duplicate UNIQUE value
INSERT INTO student (student_code, full_name, email)
VALUES ('S001', 'Test Three', 'test3@example.com');

-- 5. Value longer than VARCHAR(10)
INSERT INTO department (code, name)
VALUES ('D0000000001', 'Too Long Code');

-- 6. Foreign key pointing to a row that does not exist
INSERT INTO enrollment (student_id, course_id, grade)
VALUES (1, 999, 'A');

-- 7. Delete a department that is still referenced
DELETE FROM department
WHERE code = 'D01';

-- 8. Value that breaks the CHECK constraint
INSERT INTO course (code, title, credits, lecturer_id)
VALUES ('CS302', 'Test Course', 10, 1);

-- Change the structure explicitly with ALTER TABLE
ALTER TABLE student ADD COLUMN phone VARCHAR(15);

DESCRIBE student;

SELECT * FROM student;

-- Undo the structure change
ALTER TABLE student DROP COLUMN phone;
