package com.tracker.service.projectTracker;

import java.util.List;

import com.tracker.model.projectTracker.Lead;

public interface LeadService {

	Lead addLead(Lead lead);

	List<Lead> getAllLead();

}
