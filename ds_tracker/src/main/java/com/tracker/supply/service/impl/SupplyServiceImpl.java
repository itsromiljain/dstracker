package com.tracker.supply.service.impl;


import java.util.List;

import javax.transaction.Transactional;

import com.tracker.supply.model.SupplyDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.tracker.supply.repository.SupplyRepository;

import com.tracker.supply.service.SupplyService;

@Service
@Transactional
public class SupplyServiceImpl implements SupplyService {
	@Autowired
	private SupplyRepository supplyRepository;
	
	
	@Override
	public List<SupplyDetail> getAllSupply() {
		return supplyRepository.findAll();
	}
	
	@Override
	public SupplyDetail getSupplyById(long id) {
		return supplyRepository.findById(id).get();
	}

	@Override
	public void updateSupply(SupplyDetail s) {
		supplyRepository.save(s) ;
	}

	@Override
	public void deleteSupply(long id) {
		supplyRepository.deleteById(id) ;
	}

	@Override
	public SupplyDetail addSupply(SupplyDetail s) {
		return supplyRepository.save(s);
	}


	@Override
	public String storeFile(MultipartFile file) {
		  return StringUtils.cleanPath(file.getOriginalFilename());
	}

}
