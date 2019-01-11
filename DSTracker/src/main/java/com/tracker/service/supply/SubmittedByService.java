package com.tracker.service.supply;

import java.util.List;

import com.tracker.model.supply.SubmittedBy;

public interface SubmittedByService {

	SubmittedBy addSubmittedBy(SubmittedBy submittedBy);

	List<SubmittedBy> getAllSubmittedBy();



}
