package ru.liga.dao;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import ru.liga.dao.mapper.StudentMapper;
import ru.liga.entity.StudentEntity;

import java.util.List;

public class StudentDao {
    private JdbcTemplate jdbcTemplate;

    public StudentDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public StudentEntity insert(StudentEntity entity) {
        String sql = "INSERT INTO liga.student " +
                "(id, fio, gender, course, department_id, birthday)" +
                "VALUES (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                entity.getId(),
                entity.getFio(),
                entity.getGender(),
                entity.getCourse(),
                entity.getDepartmentId(),
                entity.getBirthday()
        );
        return entity;
    }

    public StudentEntity update(StudentEntity entity) {
        String sql = "UPDATE liga.student SET fio = ?, gender = ?," +
                " course = ?, department_id = ?, birthday = ? " +
                "WHERE id = ?";
        jdbcTemplate.update(sql,
                entity.getFio(),
                entity.getGender(),
                entity.getCourse(),
                entity.getDepartmentId(),
                entity.getBirthday(),
                entity.getId()
        );
        return entity;
    }
    public void delete(Long entityId) {
        String sqlDelete = "DELETE FROM liga.student WHERE id = ?";
        jdbcTemplate.update(sqlDelete, entityId);
    }

    public List<StudentEntity> findByDepartmentId(Long department_id) {
        String sql = "SELECT * FROM liga.student WHERE department_id = ?";
        List<StudentEntity> entities = jdbcTemplate.query(
                sql, new Object[]{department_id}, new StudentMapper());
        return entities;
    }

    public StudentEntity findById(Long id) {
        String sql = "SELECT * FROM liga.student WHERE id = ?";
        try {
            return (StudentEntity) jdbcTemplate.queryForObject(sql,
                    new StudentMapper(), id);
        } catch (DataAccessException e) {
            return null;
        }
    }


    public StudentEntity save(StudentEntity entity) {
        if (findById(Long.valueOf(entity.getId())) == null) {
            return insert(entity);
        } else {
            return update(entity);
        }
    }
}
