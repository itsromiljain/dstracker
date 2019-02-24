package com.tracker.supply.service;

import java.util.List;

import com.tracker.supply.model.SupplyDetail;
import org.springframework.web.multipart.MultipartFile;

public interface SupplyService {

	public List<SupplyDetail> getAllSupply();

	public SupplyDetail getSupplyById(long id);

	public SupplyDetail addSupply(SupplyDetail s);

	public void updateSupply(SupplyDetail s);

	public void deleteSupply(long id);

	public String storeFile(MultipartFile file);

}
