package com.tracker.supply.service.impl;


import com.tracker.admin.repo.SkillRepo;
import com.tracker.supply.model.SupplyDetail;
import com.tracker.supply.repository.SupplyRepo;
import com.tracker.supply.service.SupplyService;
import com.tracker.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

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
	public List<SupplyDetail> getAllSupplyByUser(String emailId) {
		return supplyRepo.findAllSupplyByUser(emailId);

	}

	@Override
	public SupplyDetail getSupplyById(String emailId, long supplyId) {
		Optional<SupplyDetail> optSupplyDetail = supplyRepo.findById(emailId, supplyId);
		return optSupplyDetail.isPresent()? optSupplyDetail.get():null;
	}

	@Override
	public List<Object[]> getSupplyDetails() {
		return supplyRepo.getSupplyDetails();
	}

	@Override
	public SupplyDetail addSupply(String emailId, SupplyDetail supplyDetail) {
		User user = new User();
		user.setEmailId(emailId);
		supplyDetail.setSubmittedBy(user);
		supplyDetail.setCreatedBy(user);
		return supplyRepo.save(supplyDetail);
	}

	@Override
	public void updateSupply(String emailId, SupplyDetail supplyDetail) {
		User user = new User();
		user.setEmailId(emailId);
		supplyDetail.setSubmittedBy(user);
		supplyDetail.setCreatedBy(user);
		supplyRepo.save(supplyDetail) ;
	}

	@Override
	public void archiveSupplyById(String emailId, long supplyId) {
		supplyRepo.archiveSupplyById(supplyId) ;
	}

	@Override
	public void archiveSupply(String emailId, List<Long> supplyIds) {
		supplyRepo.archiveSupply(supplyIds) ;
	}

	@Override
	public List<SupplyDetail> getAllArchiveSupply() { return supplyRepo.findAllArchivedSupply(); }

	@Override
	public String storeFile(MultipartFile file) {
		  return StringUtils.cleanPath(file.getOriginalFilename());
	}

}
