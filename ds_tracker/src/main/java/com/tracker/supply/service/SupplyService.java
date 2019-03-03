package com.tracker.supply.service;

import java.util.List;

import com.tracker.admin.model.Skill;
import com.tracker.supply.model.SupplyDetail;
import org.springframework.web.multipart.MultipartFile;

public interface SupplyService {

	public List<SupplyDetail> getAllSupply();

	public List<SupplyDetail> getAllSupplyByUser(String emailId);

	public SupplyDetail getSupplyById(String emailId, long supplyId);

	public List<Object[]> getSupplyDetails();

	public SupplyDetail addSupply(String emailId, SupplyDetail supplyDetail);

	public void updateSupply(String emailId, SupplyDetail supplyDetail);

	public List<SupplyDetail> getAllArchiveSupply();

	public void archiveSupply(String emailId, List<Long> supplyIds);

	public void archiveSupplyById(String emailId, long supplyId);

	public String storeFile(MultipartFile file);

}
