package com.example.dao;

import com.example.entities.Employee;

import java.util.List;

public interface EmployeeDAO {

    /**
     * Recuperar todos los empleados de base de datos de la tabla Employees
     * Utiliza HQL
     * @return Lista de empleados
     */
    List<Employee> findAll();

    /**
     * Recuperar todos los empleados de base de datos de la tabla Employees
     * Utiliza Criteria
     * @return Lista de empleados
     */
    List<Employee> findAllCriteria();

    /**
     * Busca un empleado por su Id
     * @param id
     * @return empleado
     */
    Employee findById(Long id);



    /**
     * Busca todos los empleados por edad
     * @param age
     * @return
     */
    List<Employee> findByAge(Integer age);

    /**
     * Inserta un nuevo registro en la tabla employees
     * @param employee
     * @return
     */
    Employee create(Employee employee);

    /**
     * Actualiza un registro existente en la tabla employees
     * @param employee
     * @return
     */
    Employee update(Employee employee);

    /**
     * Borra un empleado de la tabla employees
     * @param employee
     * @return
     */
    boolean delete(Long id);
}
