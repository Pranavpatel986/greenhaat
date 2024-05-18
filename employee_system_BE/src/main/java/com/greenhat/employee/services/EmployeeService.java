package com.greenhat.employee.services;

import com.greenhat.employee.entity.Employee;
import com.greenhat.employee.model.EmployeeModel;

import java.util.List;

public interface EmployeeService {
    Employee createEmployee(EmployeeModel employeeModel);

    List<EmployeeModel> getAllEmployees();

    boolean deleteEmployee(Long id);

    EmployeeModel getEmployeeById(Long id);

    EmployeeModel updateEmployee(Long id, EmployeeModel employeeModel);
}
