package com.greenhat.employee.services.serviceImpl;

import com.greenhat.employee.entity.Employee;
import com.greenhat.employee.entity.EmployeeRole;
import com.greenhat.employee.entity.Role;
import com.greenhat.employee.model.EmployeeModel;
import com.greenhat.employee.repository.EmployeeRepository;
import com.greenhat.employee.repository.EmployeeRoleRepository;
import com.greenhat.employee.repository.RoleRepository;
import com.greenhat.employee.services.EmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private EmployeeRoleRepository employeeRoleRepository;
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


    @Transactional
    public void addEmployeeRole(String email, String roleName) throws Exception {
        Optional<Employee> employeeOptional = employeeRepository.findByEmail(email);
        if (employeeOptional.isPresent()) {
            Employee employee = employeeOptional.get();
            Role role = (Role) roleRepository.findByName(roleName)
                    .orElseThrow(() -> new IllegalArgumentException("Role not found: " + roleName));

            EmployeeRole userRole = new EmployeeRole(employee, role);
            employeeRoleRepository.save(userRole);
        } else {
            throw new Exception("No employee found with email: " + email);
        }
    }

    @Transactional
    public void removeEmployeeRole(String email, String roleName) throws Exception {
        Optional<Employee> employeeOptional = employeeRepository.findByEmail(email);
        if (employeeOptional.isPresent()) {
            Employee employee = employeeOptional.get();
            Role role = (Role) roleRepository.findByName(roleName)
                    .orElseThrow(() -> new IllegalArgumentException("Role not found: " + roleName));

            EmployeeRole userRole = (EmployeeRole) employeeRoleRepository.findByEmployeeAndRole(employee, role)
                    .orElseThrow(() -> new IllegalArgumentException("EmployeeRole not found for employee: " + email + " and role: " + roleName));

            employeeRoleRepository.delete(userRole);
        } else {
            throw new Exception("No Employee found with email: " + email);
        }
    }
}
