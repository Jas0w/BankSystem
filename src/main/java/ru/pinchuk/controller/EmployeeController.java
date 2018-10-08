package ru.pinchuk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.pinchuk.entity.Employee;
import ru.pinchuk.service.BankService;
import ru.pinchuk.service.EmployeeService;

import java.util.List;

@Controller(value = "/banks/{bankId}/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private BankService bankService;

    @GetMapping(value = "/banks/{bankId}/employees")
    public ModelAndView getEmployeesByBankId(@PathVariable Long bankId) {
        List<Employee> bankEmployees = employeeService.getEmployeesByBankId(bankId);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("employees", bankEmployees);

        modelAndView.setViewName("employee/listOfEmployees");

        return modelAndView;
    }

    @GetMapping(value = "/banks/{bankId}/employees/{id}")
    public ModelAndView getEmployeeById(@PathVariable Long id) {
        Employee employee = employeeService.getEmployeeById(id);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("employee", employee);

        modelAndView.setViewName("employee/employeeInfo");

        return modelAndView;
    }

    @GetMapping(value = "/banks/{bankId}/addEmployee")
    public ModelAndView createNewEmployee() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("newEmployee", new Employee());
        modelAndView.setViewName("employee/addEmployee");

        return modelAndView;
    }

    @PostMapping(value = "/banks/{bankId}/addEmployee")
    @Transactional
    public ModelAndView saveNewEmployee(@ModelAttribute("SpringWeb") Employee newEmployee, @PathVariable Long bankId) {
        newEmployee.setBank(bankService.getById(bankId));
        employeeService.addEmployee(newEmployee);

        return new ModelAndView("redirect:/banks/"+bankId+"/employees");
    }

    @GetMapping(value = "/banks/{bankId}/employees/{employeeId}/delete")
    public ModelAndView deleteEmployee(@PathVariable Long employeeId, @PathVariable Long bankId) {
        employeeService.deleteEmployee(employeeId);

        return new ModelAndView("redirect:/banks/"+bankId+"/employees");
    }


}
