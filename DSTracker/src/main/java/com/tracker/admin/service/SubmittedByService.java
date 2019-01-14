package com.tracker.admin.service;

import java.util.List;

import com.tracker.admin.model.SubmittedBy;

public interface SubmittedByService {

	SubmittedBy addSubmittedBy(SubmittedBy submittedBy);

	List<SubmittedBy> getAllSubmittedBy();



}
