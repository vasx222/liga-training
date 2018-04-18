package ru.liga.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.liga.config.TestDaoSpringConfig;
import ru.liga.domain.Employee;
import ru.liga.entity.EmployeeEntity;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestDaoSpringConfig.class})
public class EmployeeDaoTest {
    @Autowired
    EmployeeDao employeeDao;

    @Test
    public void simpleTest() {
        employeeDao.update(new EmployeeEntity(1L, "qwerty", "male",
                1L, "degree1", "position1",
                LocalDate.of(2, 2, 2)));
        assertEquals(employeeDao.findById(1L).getBirthday(), LocalDate.of(2, 2, 2));
    }

}
