package com.qrms.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qrms.spring.model.ElectiveBatches;

@Repository
public interface ElectiveBatchesRepository extends JpaRepository<ElectiveBatches, Integer> {

}
