package ru.pinchuk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.pinchuk.entity.Employee;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("select e from Employee e where e.bank.id = :bankId")
    List<Employee> findEmployeesByBankId(@Param("bankId") Long id);

    @Query("select e from Employee e where e.id = :id")
    Employee getEmployeeById(@Param("id") Long id);
}
