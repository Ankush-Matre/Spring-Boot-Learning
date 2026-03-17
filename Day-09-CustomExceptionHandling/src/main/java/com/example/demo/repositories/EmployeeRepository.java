package com.example.demo.repositories;

import com.example.demo.entities.EmployeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeEntity , Long> {

}
