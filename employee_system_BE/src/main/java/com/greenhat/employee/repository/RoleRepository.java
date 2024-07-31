package com.greenhat.employee.repository;

import com.greenhat.employee.entity.EmployeeRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<EmployeeRole, Long> {

    Optional<Object> findByName(String roleName);
}
