package ru.liga.mybatis.entity;

import java.time.LocalDate;

public class StudentEntity {
    private Long id;
    private String fio;
    private String gender;
    private Long departmentId;
    private String studentGroupId;
    private LocalDate birthday;

    public StudentEntity() {
    }

    public StudentEntity(Long id, String fio, String gender, Long departmentId,
                         String studentGroupId, LocalDate birthday) {
        this.id = id;
        this.fio = fio;
        this.gender = gender;
        this.departmentId = departmentId;
        this.studentGroupId = studentGroupId;
        this.birthday = birthday;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartment(Long departmentId) {
        this.departmentId = departmentId;
    }

    public String getStudentGroupId() {
        return studentGroupId;
    }

    public void setStudentGroupId(String studentGroupId) {
        this.studentGroupId = studentGroupId;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }
}
