package ru.liga.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import ru.liga.dao.mapper.DepartmentMapper;
import ru.liga.dao.mapper.EmployeeMapper;
import ru.liga.dao.mapper.StudentMapper;
import ru.liga.entity.DepartmentEntity;
import ru.liga.entity.EmployeeEntity;
import ru.liga.entity.StudentEntity;

import java.util.List;

public class EmployeeDao {
    private JdbcTemplate jdbcTemplate;

    public EmployeeDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public EmployeeEntity insert(EmployeeEntity entity) {
        String sqlInsert = "INSERT INTO liga.employee (birthday)"
                + " VALUES (?)";
        jdbcTemplate.update(sqlInsert, entity.getBirthday());
        return entity;
    }

    public EmployeeEntity update(EmployeeEntity entity) {
        String sqlUpdate = "update liga.employee set" +
                " fio = ?," +
                " gender = ?," +
                " department_id = ?," +
                " degree = ?," +
                " position = ?," +
                " birthday=?" +
                " where id = ?";
        jdbcTemplate.update(sqlUpdate,
                entity.getFio(),
                entity.getGender(),
                entity.getDepartmentId(),
                entity.getDegree(),
                entity.getPosition(),
                entity.getBirthday(),
                entity.getId()
        );
        return entity;
    }

    public void delete(Long entityId) {
        String sqlDelete = "delete from liga.employee where id = ?";
        jdbcTemplate.update(sqlDelete, entityId);
    }

    public EmployeeEntity findById(Long id) {
        String sql = "SELECT * FROM liga.employee WHERE ID = ?";
        List<EmployeeEntity> entities = jdbcTemplate.query(
                sql, new EmployeeMapper(), id);
        return entities.isEmpty() ? null : entities.get(0);
    }

    public EmployeeEntity save(EmployeeEntity entity) {
        if (findById(entity.getId()) == null) {
            return insert(entity);
        } else {
            return update(entity);
        }
    }

    public List<EmployeeEntity> findByDepartmentId(Long department_id) {
        String sql = "SELECT * FROM liga.employee WHERE department_id = ?";
        List<EmployeeEntity> entities = jdbcTemplate.query(
                sql, new Object[]{department_id}, new EmployeeMapper());
        return entities;
    }
}
