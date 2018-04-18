-- liquibase formatted sql logicalFilePath:V1_010_STUDENT.sql
-- changeset sanasov:1.10 runOnChange:true context:prod
ALTER TABLE liga.student ADD COLUMN department_id INTEGER;
UPDATE liga.student SET department_id = (SELECT liga.department.id FROM
  liga.department WHERE
  liga.student.department_name = liga.department.title);
ALTER TABLE liga.student DROP COLUMN department_name;