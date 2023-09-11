package com.multitenancy.multitenancy.Repository;

import com.multitenancy.multitenancy.Entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Integer> {
    List<EmployeeEntity> findById(String id);
    List<EmployeeEntity> findAll();
}
