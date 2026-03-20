package com.cricket.bcci.Cricket.repositories;

import com.cricket.bcci.Cricket.entities.CricketerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CricketerRepository extends JpaRepository<CricketerEntity , Integer> {

}
