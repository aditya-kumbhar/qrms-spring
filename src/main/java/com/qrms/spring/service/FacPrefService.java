package com.qrms.spring.service;

import java.util.List;

import com.qrms.spring.queryBeans.FacPrefCountInfo;

public interface FacPrefService {
	List<FacPrefCountInfo> computeFacPrefTable();

}
