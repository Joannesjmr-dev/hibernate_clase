package com.example.entities;

import com.example.util.HibernateUtil;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class EmployeeTest {

    @Test
    void createTablesTest() {

        Employee employee2;
        employee2 = new Employee(null,
                "Empleado2",
                "empleado2@company.com",
                32,
                40000d,
                true,
                LocalDate.of(1990,1,1),
                LocalDateTime.now()
        );

        Employee employee3 = new Employee(null,
                "Empleado3",
                "empleado3@company.com",
                40,
                50000d,
                true,
                LocalDate.of(1980, 2, 2),
                LocalDateTime.now()
        );

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        session.beginTransaction();

        session.save(employee2);
        session.save(employee3);

        session.getTransaction().commit();

        session.close();
        sessionFactory.close();


    }

    @Test
    void createTables2Test() {

    }
}
