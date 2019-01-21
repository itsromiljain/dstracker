package com.tracker.supply.service.impl;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.tracker.supply.model.SupplyDtls;
import com.tracker.supply.repository.SupplyRepository;

import com.tracker.supply.service.SupplyService;

@Service
@Transactional
public class SupplyServiceImpl implements SupplyService {
	@Autowired
	private SupplyRepository supplyRepository;
	
	
	@Override
	public List<SupplyDtls> getAllSupply() {
		return supplyRepository.findAll();
	}
	
	/*@Override
	public Optional<SupplyDtls> getSupply(long id) {
		return supplyRepository.findById(id);
	}*/
	

	@Override
	public void UpdateSupply(SupplyDtls s) {
		supplyRepository.save(s) ;
	}

	@Override
	public void deleteSupply(long id) {
		supplyRepository.deleteById(id) ;
	}

	@Override
	public SupplyDtls addSupply(SupplyDtls s) {
		return supplyRepository.save(s);
	}


	@Override
	public String storeFile(MultipartFile file) {
		  String fileName = StringUtils.cleanPath(file.getOriginalFilename());		
			return fileName;			
	}
	
//	@Override
//	public SupplyDtls addSupply(SupplyDtls s, MultipartFile[] file) {
//		byte[] bytesArray = new byte[(int) file.length]; 
//		s.setData(bytesArray);
//	
//		return supplyRepository.save(s);
//	}

}
