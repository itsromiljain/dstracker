package com.tracker.service.projectTracker;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tracker.model.projectTracker.Lead;
import com.tracker.repository.projectTracker.LeadRepo;

@Service
@Transactional
public class LeadServiceImpl implements LeadService{

	@Autowired
	LeadRepo leadrepo;
	
	@Override
	public Lead addLead(Lead lead) {
		// TODO Auto-generated method stub
		return leadrepo.save(lead);
	}

	@Override
	public List<Lead> getAllLead() {
		// TODO Auto-generated method stub
		return leadrepo.findAll();
	}

}
