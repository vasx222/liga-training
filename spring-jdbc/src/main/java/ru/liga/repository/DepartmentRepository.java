package ru.liga.repository;

import ru.liga.entity.DepartmentEntity;

public interface DepartmentRepository {
    void save(DepartmentEntity departmentEntity);
    void deleteById(Long id);
    DepartmentEntity findById(Long id);
}
