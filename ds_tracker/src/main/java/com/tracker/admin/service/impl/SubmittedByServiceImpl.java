package com.tracker.admin.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tracker.admin.model.SubmittedBy;
import com.tracker.admin.repo.SubmittedByRepo;
import com.tracker.admin.service.SubmittedByService;
@Service
@Transactional
public class SubmittedByServiceImpl implements SubmittedByService{
@Autowired
SubmittedByRepo submittedByRepo;

	@Override
	public SubmittedBy addSubmittedBy(SubmittedBy submittedBy) {
		
		return submittedByRepo.save(submittedBy);
	}

	@Override
	public List<SubmittedBy> getAllSubmittedBy() {
		// TODO Auto-generated method stub
		return submittedByRepo.findAll();
	}

}
