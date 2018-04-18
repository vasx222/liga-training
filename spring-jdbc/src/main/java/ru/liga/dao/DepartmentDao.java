package ru.liga.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import ru.liga.dao.mapper.DepartmentMapper;
import ru.liga.entity.DepartmentEntity;

import java.util.List;

public class DepartmentDao {
    private JdbcTemplate jdbcTemplate;

    public DepartmentDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public DepartmentEntity save(DepartmentEntity entity) {
        if (findById(entity.getId()) == null) {
            return insert(entity);
        } else {
            return update(entity);
        }
    }

    public DepartmentEntity insert(DepartmentEntity entity) {
        String sqlInsert = "INSERT INTO liga.department " +
                "(title, address, foundation_year)"
                + " VALUES (?, ?, ?)";
        jdbcTemplate.update(sqlInsert, entity.getTitle(),
                entity.getAddress(),
                entity.getFoundationYear());
        return entity;
    }

    public DepartmentEntity update(DepartmentEntity entity) {
        String sqlUpdate = "update liga.department set" +
                " title = ?," +
                " address = ?," +
                " foundation_year = ?" +
                " where id = ?";
        jdbcTemplate.update(sqlUpdate, entity.getTitle(),
                entity.getAddress(),
                entity.getFoundationYear(),
                entity.getId());
        return entity;
    }

    public void delete(Long entityId) {
        String sqlDelete = "delete from liga.department where id = ?";
        jdbcTemplate.update(sqlDelete, entityId);
    }

    public DepartmentEntity findById(Long id) {
        String sql = "SELECT * FROM liga.department WHERE ID = ?";
        List<DepartmentEntity> entities = jdbcTemplate.query(
                sql, new Object[]{id}, new DepartmentMapper());
        return entities.isEmpty() ? null : entities.get(0);
    }

    public List<DepartmentEntity> findByFoundationYear(Integer year) {
        String sql = "SELECT * FROM liga.department WHERE foundation_year = ?";
        List<DepartmentEntity> entities = jdbcTemplate.query(
                sql, new Object[]{year}, new DepartmentMapper());
        return entities;
    }

    public DepartmentEntity findByTitle(String title) {
        String sql = "SELECT * FROM liga.department WHERE title = ?";
        List<DepartmentEntity> entities = jdbcTemplate.query(
                sql, new Object[]{title}, new DepartmentMapper());
        return entities.isEmpty() ? null : entities.get(0);
    }
    
}
