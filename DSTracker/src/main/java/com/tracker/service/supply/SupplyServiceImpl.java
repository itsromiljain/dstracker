package com.tracker.service.supply;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.tracker.model.supply.SupplyDtls;
import com.tracker.repository.supply.SupplyRepository;

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
	
//	@Override
//	public SupplyDtls addSupply(SupplyDtls s, MultipartFile[] file) {
//		byte[] bytesArray = new byte[(int) file.length]; 
//		s.setData(bytesArray);
//	
//		return supplyRepository.save(s);
//	}

}
