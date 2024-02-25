package com.example.dao;

import com.example.entities.Employee;
import com.example.util.HibernateUtil;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO{

    @Override
    public List<Employee> findAll() {

        Session session = HibernateUtil.getSessionFactory().openSession();

        //Consulta HQL
        Query<Employee> query = session.createQuery("from Employee", Employee.class);
        List<Employee> employees = query.list();

        // Equivalente:
        //List<Employee> employees = session.createQuery("from Employee", Employee.class).list();

        session.close();
        return employees;

    }

    @Override
    public List<Employee> findAllCriteria() {
        Session session = HibernateUtil.getSessionFactory().openSession();

        // 1. Criteria
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Employee> criteria = builder.createQuery(Employee.class);
        //Root<Employee> root = criteria.from(Employee.class);
        //criteria.select(root);
        criteria.select(criteria.from(Employee.class));

        // 2. Query
        List<Employee> employees = session.createQuery(criteria).list();
        session.close();
        return employees;
    }

    @Override
    public Employee findById(Long id) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        Employee employee = session.find(Employee.class, id);
        session.close();
        return employee;
    }

    @Override
    public List<Employee> findByAge(Integer age) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<Employee> query = session.createQuery("from Employee where age = :age", Employee.class);
        query.setParameter("age", age);
        List<Employee> employees = query.list();

        session.close();
        return employees;
    }

    @Override
    public Employee create(Employee employee) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        try {

            session.beginTransaction();

            session.save(employee);

            session.getTransaction().commit();
        }catch (PersistenceException e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.close();
        return employee;
    }

    @Override
    public Employee update(Employee employee) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {

            session.beginTransaction();

            session.update(employee);

            session.getTransaction().commit();
        }catch (PersistenceException e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.close();
        return employee;
    }

    @Override
    public boolean delete(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            session.beginTransaction();

            Employee employee = this.findById(id);
            employee.setId(id);

            session.delete(employee);

            session.getTransaction().commit();
        }catch (PersistenceException e){
            e.printStackTrace();
            session.getTransaction().rollback();
            return false;
        }finally {
            session.close();
        }
        return true;
    }
}
