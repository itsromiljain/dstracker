package com.tracker.supply.service;

import java.util.List;

import com.tracker.admin.model.Skill;
import com.tracker.supply.model.SupplyDetail;
import org.springframework.web.multipart.MultipartFile;

public interface SupplyService {

	public List<SupplyDetail> getAllSupply();

	public SupplyDetail getSupplyById(long id);

	public List<Object[]> getSupplyDetails();

	public SupplyDetail addSupply(SupplyDetail supplyDetail);

	public void updateSupply(SupplyDetail supplyDetail);

	public void deleteSupply(long id);

	public String storeFile(MultipartFile file);

}
