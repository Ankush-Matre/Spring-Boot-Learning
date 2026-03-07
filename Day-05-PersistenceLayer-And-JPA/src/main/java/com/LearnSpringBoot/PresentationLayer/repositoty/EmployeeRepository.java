package com.LearnSpringBoot.PresentationLayer.repositoty;

import com.LearnSpringBoot.PresentationLayer.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity , Long> {
}
