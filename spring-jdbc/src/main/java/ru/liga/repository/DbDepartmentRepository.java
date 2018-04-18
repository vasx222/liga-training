package ru.liga.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import ru.liga.dao.DepartmentDao;
import ru.liga.dao.EmployeeDao;
import ru.liga.dao.StudentDao;
import ru.liga.entity.DepartmentEntity;
import ru.liga.entity.EmployeeEntity;
import ru.liga.entity.StudentEntity;

@Component
public class DbDepartmentRepository implements DepartmentRepository {
    @Autowired
    private DepartmentDao departmentDao;

    @Autowired
    private StudentDao studentDao;

    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public void save(DepartmentEntity departmentEntity) {
        departmentDao.save(departmentEntity);
        departmentEntity.getStudents().forEach(studentDao::save);
        departmentEntity.getEmployees().forEach(employeeDao::save);
    }

    @Override
    public void deleteById(Long id) {
        departmentDao.delete(id);
        studentDao.findByDepartmentId(id).stream()
                .mapToLong(StudentEntity::getId)
                .forEach(studentDao::delete);
        employeeDao.findByDepartmentId(id).stream()
                .mapToLong(EmployeeEntity::getId)
                .forEach(employeeDao::delete);
    }

    @Override
    public DepartmentEntity findById(Long id) {
        DepartmentEntity entity = departmentDao.findById(id);
        if (entity == null) {
            return null;
        }
        entity.setStudents(studentDao.findByDepartmentId(id));
        entity.setEmployees(employeeDao.findByDepartmentId(id));
        return entity;
    }
}
