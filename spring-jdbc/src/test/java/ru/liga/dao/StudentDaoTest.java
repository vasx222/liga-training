package ru.liga.dao;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.liga.config.TestDaoSpringConfig;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestDaoSpringConfig.class})
public class StudentDaoTest {
    @Autowired
    private StudentDao studentDao;

    @Before
    public void init() {

    }

    @Test
    public void simpleTest() {
        assertEquals(studentDao.findById(1L).getFio(),
                "Бардашов Данила Романович");
        assertEquals(studentDao.findByDepartmentId(1L).size(), 16);
    }
}
