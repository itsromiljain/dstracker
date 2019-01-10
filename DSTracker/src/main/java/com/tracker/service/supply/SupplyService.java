package com.tracker.service.supply;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.tracker.model.supply.SupplyDtls;

public interface SupplyService {

	public List<SupplyDtls> getAllSupply();
	//public Optional<SupplyDtls> getSupply(long id);
	//public SupplyDtls addSupply(SupplyDtls s, MultipartFile[] file);
	public SupplyDtls addSupply(SupplyDtls s);
	public void UpdateSupply(SupplyDtls s);
	public void deleteSupply(long id);

}
