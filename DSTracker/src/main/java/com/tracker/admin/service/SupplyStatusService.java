package com.tracker.admin.service;

import java.util.List;

import com.tracker.admin.model.SupplyStatus;

public interface SupplyStatusService {

	SupplyStatus addStatus(SupplyStatus supplyStatus);

	List<SupplyStatus> getAllSupplyStatus();

}
