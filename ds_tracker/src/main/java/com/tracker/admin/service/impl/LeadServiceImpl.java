package com.tracker.admin.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tracker.admin.model.Lead;
import com.tracker.admin.repo.LeadRepo;
import com.tracker.admin.service.LeadService;

@Service
@Transactional
public class LeadServiceImpl implements LeadService{

	@Autowired
	LeadRepo leadrepo;
	
	@Override
	public Lead addLead(Lead lead) {
		return leadrepo.save(lead);
	}

	@Override
	public List<Lead> getAllLead() {
		return leadrepo.findAll();
	}

}
