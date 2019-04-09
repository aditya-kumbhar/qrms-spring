package com.qrms.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qrms.spring.model.CurrentTimeSlots;

public interface CurrTimeSlotsRepository extends JpaRepository<CurrentTimeSlots, Integer>{

}
