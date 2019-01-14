package com.tracker.admin.service;

import java.util.List;

import com.tracker.admin.model.Lead;

public interface LeadService {

	Lead addLead(Lead lead);

	List<Lead> getAllLead();

}
