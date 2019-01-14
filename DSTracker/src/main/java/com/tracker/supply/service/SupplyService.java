package com.tracker.supply.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.tracker.supply.model.SupplyDtls;

public interface SupplyService {

	public List<SupplyDtls> getAllSupply();
	//public Optional<SupplyDtls> getSupply(long id);
	//public SupplyDtls addSupply(SupplyDtls s, MultipartFile[] file);
	public SupplyDtls addSupply(SupplyDtls s);
	public void UpdateSupply(SupplyDtls s);
	public void deleteSupply(long id);

}
