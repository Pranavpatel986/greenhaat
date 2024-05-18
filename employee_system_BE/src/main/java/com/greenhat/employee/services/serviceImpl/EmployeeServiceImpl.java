package com.greenhat.employee.services.serviceImpl;

import com.greenhat.employee.entity.Employee;
import com.greenhat.employee.model.EmployeeModel;
import com.greenhat.employee.repository.EmployeeRepository;
import com.greenhat.employee.services.EmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public Employee createEmployee(EmployeeModel employeeModel) {
        Employee employee= new Employee();
        BeanUtils.copyProperties(employeeModel, employee);
        employeeRepository.save(employee);

        return employee;
    }

    @Override
    public List<EmployeeModel> getAllEmployees() {
        List<Employee> employees=employeeRepository.findAll();

        return employees
                .stream()
                .map(emp -> new EmployeeModel(
                        emp.getId(),
                        emp.getFirstName(),
                        emp.getLastName(),
                        emp.getEmail()
                )).toList();
    }

    @Override
    public boolean deleteEmployee(Long id) {
        Employee employee=employeeRepository.findById(id).get();
        employeeRepository.delete(employee);
        return true;
    }

    @Override
    public EmployeeModel getEmployeeById(Long id) {
        Employee employee= employeeRepository.findById(id).get();
        EmployeeModel employeeModel= new EmployeeModel();
        BeanUtils.copyProperties(employee, employeeModel);
        return employeeModel;
    }

    @Override
    public EmployeeModel updateEmployee(Long id, EmployeeModel employeeModel) {
        Employee employee=employeeRepository.findById(id).get();
        employee.setEmail(employeeModel.getEmail());
        employee.setFirstName(employeeModel.getFirstName());
        employee.setLastName(employeeModel.getLastName());

        employeeRepository.save(employee);
        return employeeModel;
    }
}
