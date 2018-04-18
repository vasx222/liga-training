package ru.liga.dao;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.liga.config.TestDaoSpringConfig;
import ru.liga.entity.DepartmentEntity;
import ru.liga.repository.DepartmentRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestDaoSpringConfig.class})
public class DbDepartmentRepositoryTest {
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private DepartmentDao departmentDao;
    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private StudentDao studentDao;

    private DepartmentEntity departmentEntity;

    @Before
    public void init() {
        DepartmentEntity someEntity = departmentDao.findById(1L);
        departmentEntity = new DepartmentEntity(4L, "qwert", "1",
                1, someEntity.getEmployees(), someEntity.getStudents());
    }

    @Test
    public void someTest() {
        departmentRepository.save(departmentEntity);
        DepartmentEntity someEntity = departmentRepository.findById(4L);
        Assert.assertEquals(someEntity.getTitle(), "qwert");
    }
}
