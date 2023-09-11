package com.multitenancy.multitenancy.Controller;

import com.multitenancy.multitenancy.Context.TenantContext;
import com.multitenancy.multitenancy.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/{id}")
    public <Employee> List<Employee> getEmployeesBySchema(@PathVariable String schema) {
        TenantContext.setCurrentSchema(schema);
        List<Employee> employees = (List<Employee>) employeeRepository.findAll();
        TenantContext.clear();
        return employees;
    }

}
