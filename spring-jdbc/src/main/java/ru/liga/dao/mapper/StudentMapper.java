package ru.liga.dao.mapper;

import org.springframework.jdbc.core.RowMapper;
import ru.liga.entity.StudentEntity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        return new StudentEntity(
                resultSet.getLong("id"),
                resultSet.getString("fio"),
                resultSet.getString("gender"),
                resultSet.getLong("course"),
                resultSet.getLong("department_id"),
                resultSet.getDate("birthday").toLocalDate()
        );
    }
}
