package com.tracker.supply.service.impl;


import java.util.List;

import javax.transaction.Transactional;

import com.tracker.admin.model.Skill;
import com.tracker.admin.repo.SkillRepo;
import com.tracker.supply.model.SupplyDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.tracker.supply.repository.SupplyRepo;

import com.tracker.supply.service.SupplyService;

@Service
@Transactional
public class SupplyServiceImpl implements SupplyService {
	@Autowired
	private SupplyRepo supplyRepo;

	@Autowired
	private SkillRepo skillRepo;
	
	
	@Override
	public List<SupplyDetail> getAllSupply() {
		return supplyRepo.findAll();
	}
	
	@Override
	public SupplyDetail getSupplyById(long id) {
		return supplyRepo.findById(id).get();
	}

	@Override
	public List<Object[]> getSupplyDetails() {
		return supplyRepo.getSupplyDetails();
	}

	@Override
	public void updateSupply(SupplyDetail s) {
		supplyRepo.save(s) ;
	}

	@Override
	public void deleteSupply(long id) {
		supplyRepo.deleteById(id) ;
	}

	@Override
	public SupplyDetail addSupply(SupplyDetail s) {
		return supplyRepo.save(s);
	}


	@Override
	public String storeFile(MultipartFile file) {
		  return StringUtils.cleanPath(file.getOriginalFilename());
	}

}
