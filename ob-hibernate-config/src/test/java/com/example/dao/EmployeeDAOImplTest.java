package com.example.dao;

import com.example.entities.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.prefs.PreferenceChangeListener;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeDAOImplTest {

    EmployeeDAO dao;

    @BeforeEach
    void setUp() {
        dao = new EmployeeDAOImpl();
    }

    @Test
    void findAll() {
        List<Employee> employees = dao.findAll();
        System.out.println(employees);
    }

    @Test
    void findById() {
        Employee employee1 = dao.findById(1L);
        Employee employee2 = dao.findById(2L);
    }

    @Test
    void findByAge() {
        List<Employee> employees40 = dao.findByAge(40);
        List<Employee> employees20 = dao.findByAge(20);
    }

    @Test
    void create() {
        Employee employee = new Employee(null, "Empleado creado desde JUnit", "empleado@company.co", 50, 80000d,false,null,null);

        employee = dao.create(employee);
        System.out.println(employee);

    }

    @Test
    void update() {

        // Se coloca id porque es una actualizacion del registro
        Employee employee1;
        employee1 = new Employee(1L,
                "Empleado1 editado",
                "empleado1@company.com",
                32,
                40000d,
                true,
                LocalDate.of(1990,1,1),
                LocalDateTime.now()
        );
        employee1 = dao.update(employee1);
        System.out.println(employee1);
    }

    @Test
    void delete() {
       boolean result = dao.delete(1L);
        System.out.println(result);
    }
}