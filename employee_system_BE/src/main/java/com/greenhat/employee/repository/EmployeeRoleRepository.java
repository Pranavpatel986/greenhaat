package com.greenhat.employee.repository;

import com.greenhat.employee.entity.Employee;
import com.greenhat.employee.entity.EmployeeRole;
import com.greenhat.employee.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRoleRepository extends JpaRepository<EmployeeRole, Integer> {
    Optional<Object> findByEmployeeAndRole(Employee employee, Role role);
}
