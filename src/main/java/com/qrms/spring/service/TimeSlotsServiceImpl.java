package com.qrms.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.qrms.spring.model.CurrentTimeSlots;
import com.qrms.spring.model.OldTimeSlots;
import com.qrms.spring.repository.CurrTimeSlotsRepository;
import com.qrms.spring.repository.OldTimeSlotsRepository;

public class TimeSlotsServiceImpl implements TimeSlotsService{
	
	@Autowired
	private CurrTimeSlotsRepository currTimeSlotsRepository;
	
	@Autowired
	private OldTimeSlotsRepository oldTimeSlotsRepository;
	
	@Override
	public void updateTimeSlots() {
		List<CurrentTimeSlots> currTimeSlots = currTimeSlotsRepository.findAll();
		for(CurrentTimeSlots cts:currTimeSlots) {
			OldTimeSlots ots = new OldTimeSlots();
			ots.setActivity(cts.getActivity());
			ots.setActivityIncharge(cts.getActivityIncharge());
			ots.setDate(cts.getDate());
			ots.setDay(cts.getDay());
			ots.setStartTime(cts.getStartTime());
			ots.setEndTime(cts.getEndTime());
			ots.setResourceId(cts.getResourceId());
			oldTimeSlotsRepository.save(ots);
		}
	}

}
