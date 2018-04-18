package ru.liga.domain;

public class Employee {
    private final Long id;
    private final String fio;
    private final String gender;
    private final String department;
    private final String degree;
    private final String position;
    private final String birthday;

    public Employee(Long id, String fio, String gender, String faculty, String degree, String position, String birthday) {
        this.id = id;
        this.fio = fio;
        this.gender = gender;
        this.department = faculty;
        this.degree = degree;
        this.position = position;
        this.birthday = birthday;
    }


}
