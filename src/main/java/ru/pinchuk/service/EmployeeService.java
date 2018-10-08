package ru.pinchuk.service;

import ru.pinchuk.entity.Employee;

import java.util.List;

public interface EmployeeService {

    Employee addEmployee(Employee employee);
    void deleteEmployee(Long id);
    Employee editEmployee(Employee employee);
    List<Employee> getAll();
    List<Employee> getEmployeesByBankId(Long id);
    Employee getEmployeeById(Long id);
}
