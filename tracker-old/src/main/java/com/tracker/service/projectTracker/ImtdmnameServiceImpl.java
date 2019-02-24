package com.tracker.service.projectTracker;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tracker.model.projectTracker.DelvryMgr;
import com.tracker.model.projectTracker.Imt;
import com.tracker.repository.projectTracker.DmnameRepository;
import com.tracker.repository.projectTracker.ImtnameRepository;

@Service
@Transactional
public class ImtdmnameServiceImpl implements ImtdmnameService{

	@Autowired
	private ImtnameRepository imtnameRepository;
	@Autowired
	private DmnameRepository dmnameRepository;
	
	@Override
	public List<Imt> getAllImtNm() {
		return imtnameRepository.findAll();
		
	}

	@Override
	public List<DelvryMgr> getAllDmNam() {
		return dmnameRepository.findAll();
	}

}
