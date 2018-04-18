package ru.liga.mybatis.dao;

import ru.liga.mybatis.entity.DepartmentEntity;
import ru.liga.mybatis.entity.StudentEntity;

public interface StudentDao {
    StudentEntity insert(StudentEntity entity);

    StudentEntity update(StudentEntity entity);

    void deleteById(Long entityId);

    StudentEntity selectById(Long id);

    StudentEntity selectByDepartmentId(Long departmentId);
}
