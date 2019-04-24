package com.tracker.supply.service;

import java.util.List;

import com.tracker.entity.SupplyDetail;
import com.tracker.supply.pojo.SupplyTO;
import org.springframework.web.multipart.MultipartFile;

public interface SupplyService {

	public List<SupplyTO> getAllSupply();

	public List<SupplyTO> getAllSupplyByUser(String emailId);

	public SupplyTO getSupplyById(String emailId, long supplyId);

	public List<Object[]> getSupplyDetails();

	public SupplyTO addSupply(String emailId, SupplyTO supplyTO);

	public void updateSupply(String emailId, SupplyTO supplyTO);

	public List<SupplyTO> getAllArchiveSupply();

	public void archiveSupply(String emailId, List<Long> supplyIds);

	public void archiveSupplyById(String emailId, long supplyId);

	public String storeFile(MultipartFile file);

}
