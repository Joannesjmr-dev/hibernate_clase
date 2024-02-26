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
     * Utiliza metódos de Hibernate
     * @param id
     * @return empleado
     */
    Employee findById(Long id);

    /**
     * Busca un empleado por su Id
     * Utiliza Criteria
     * @param id
     * @return empleado
     */
    Employee findByIdCriteria(Long id);

    /**
     * Busca todos los empleados por edad
     * @param age
     * @return
     */
    List<Employee> findByAge(Integer age);

    /**
     * Filtrar por nombre
     * Criteria utilizando like
     * @param firstName
     * @return
     */
    List<Employee> findByFirstNameLikeCriteria(String firstName);

    /**
     * Filtrar por edad. Mayor de determinado numero
     * Criteria utilizando like
     * @param age
     * @return
     */
    List<Employee> findByAgeGreater18Criteria(Integer age);

    /**
     * Filtrar por rango de edad entre dos numeros
     * Criteria utilizando like
     * @param min
     * @param max
     * @return
     */
    List<Employee> findByAgeBetweenCriteria(Integer min, Integer max);

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
