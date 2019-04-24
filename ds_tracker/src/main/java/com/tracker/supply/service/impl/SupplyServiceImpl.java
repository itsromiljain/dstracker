package com.tracker.supply.service.impl;


import com.tracker.admin.repo.SkillRepo;
import com.tracker.entity.DemandDetail;
import com.tracker.entity.DemandSupplyMapping;
import com.tracker.entity.SupplyDetail;
import com.tracker.supply.pojo.SupplyMappingTO;
import com.tracker.supply.pojo.SupplyTO;
import com.tracker.supply.repository.SupplyRepo;
import com.tracker.supply.service.SupplyService;
import com.tracker.user.model.User;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.sql.Date;
import java.util.*;

@Service
@Transactional
public class SupplyServiceImpl implements SupplyService {
	@Autowired
	private SupplyRepo supplyRepo;

	@Autowired
	private SkillRepo skillRepo;
	
	
	@Override
	public List<SupplyTO> getAllSupply() {
		return convertSupplyDomainToSupply(supplyRepo.findAll());
	}


	@Override
	public List<SupplyTO> getAllSupplyByUser(String emailId) {
		return convertSupplyDomainToSupply(supplyRepo.findAllSupplyByUser(emailId));

	}

	@Override
	public SupplyTO getSupplyById(String emailId, long supplyId) {
		Optional<SupplyDetail> optSupplyDetail = supplyRepo.findById(emailId, supplyId);
		return optSupplyDetail.isPresent()? convertSupplyDomainToSupply(optSupplyDetail.get()):null;
	}

	@Override
	public List<Object[]> getSupplyDetails() {
		return supplyRepo.getSupplyDetails();
	}

	@Override
	public SupplyTO addSupply(String emailId, SupplyTO supplyTO) {
		supplyRepo.save(convertSupplyToSupplyDomain(supplyTO));
		return supplyTO;
	}

	@Override
	public void updateSupply(String emailId, SupplyTO supplyTO) {
		supplyRepo.save(convertSupplyToSupplyDomain(supplyTO)) ;
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
	public List<SupplyTO> getAllArchiveSupply() {
		return convertSupplyDomainToSupply(supplyRepo.findAllArchivedSupply());
	}

	@Override
	public String storeFile(MultipartFile file) {
		  return StringUtils.cleanPath(file.getOriginalFilename());
	}


	private List<SupplyTO> convertSupplyDomainToSupply(List<SupplyDetail> supplyDetails) {
		List<SupplyTO> supplyTOS = new ArrayList<>();
		for(SupplyDetail supplyDetail: supplyDetails){
			supplyTOS.add(convertSupplyDomainToSupply(supplyDetail));
		}
		return supplyTOS;
	}

	private SupplyTO convertSupplyDomainToSupply(SupplyDetail supplyDetail) {
		SupplyTO supplyTO = new SupplyTO();
		supplyTO.setSupplyId(supplyDetail.getSupplyId());
		supplyTO.setCandidateName(supplyDetail.getCandidateName());
		supplyTO.setSkillSummary(supplyDetail.getSkillSummary());
		supplyTO.setCandidateStatus(supplyDetail.getStatus());
		supplyTO.setPremiumRate(supplyDetail.getPremiumRate());
		supplyTO.setRecruiterName(supplyDetail.getRecruiterName());
		supplyTO.setSubmittedBy(supplyDetail.getSubmittedBy().getEmailId());
		supplyTO.setExperienceYear(supplyDetail.getExperienceYear());
		supplyTO.setSupplyIntExt(supplyDetail.getSupplyIntExt());
		supplyTO.setSupplyOnOffshore(supplyDetail.getSupplyOnOffshore());
		supplyTO.setCandidateLocation(supplyDetail.getCandidateLocation());
		supplyTO.setOnBoardingDate(supplyDetail.getOnBoardingDate());
		supplyTO.setRrNumber(supplyDetail.getRrNumber());
		supplyTO.setSfId(supplyDetail.getSfId());
		supplyTO.setComments(supplyDetail.getComments());
		supplyTO.setArchived(supplyDetail.isArchived());
		supplyTO.setCreatedDate(supplyDetail.getCreatedDate());
		supplyTO.setModifiedDate(supplyDetail.getModifiedDate());
		supplyTO.setCreatedBy(supplyDetail.getCreatedBy().getEmailId());

		Set<DemandSupplyMapping> mappings = supplyDetail.getDemandMappings();
		if(CollectionUtils.isNotEmpty(mappings)){
			List<SupplyMappingTO> supplyMappingTOList = new ArrayList<>();
			for(DemandSupplyMapping mapping: mappings){
				SupplyMappingTO supplyMappingTO = new SupplyMappingTO();
				supplyMappingTO.setMappingId(mapping.getMappingId());
				supplyMappingTO.setClientInterviewDate(mapping.getClientInterviewDate());
				supplyMappingTO.setInterviewLocation(mapping.getInterviewLocation());
				supplyMappingTO.setSelectionStatus(mapping.getSelectionStatus());
				supplyMappingTO.setDemandId(mapping.getDemand().getDemandId());
				supplyMappingTOList.add(supplyMappingTO);
			}
			supplyTO.setSupplyMapping(supplyMappingTOList);
		}

		return supplyTO;
	}

	private List<SupplyDetail> convertSupplyToSupplyDomain(List<SupplyTO> supplyTOS) {
		List<SupplyDetail> supplyDetails = new ArrayList<>();
		for(SupplyTO supplyTO: supplyTOS){
			supplyDetails.add(convertSupplyToSupplyDomain(supplyTO));
		}
		return supplyDetails;
	}

	private SupplyDetail convertSupplyToSupplyDomain(SupplyTO supplyTO) {
		SupplyDetail supplyDetail = new SupplyDetail();
		supplyDetail.setSupplyId(supplyTO.getSupplyId());
		supplyDetail.setCandidateName(supplyTO.getCandidateName());
		supplyDetail.setSkillSummary(supplyTO.getSkillSummary());
		supplyDetail.setStatus(supplyTO.getCandidateStatus());
		supplyDetail.setPremiumRate(supplyTO.getPremiumRate());
		supplyDetail.setRecruiterName(supplyTO.getRecruiterName());
		supplyDetail.setSubmittedBy(populateUser(supplyTO.getSubmittedBy()));
		supplyDetail.setExperienceYear(supplyTO.getExperienceYear());
		supplyDetail.setSupplyIntExt(supplyTO.getSupplyIntExt());
		supplyDetail.setSupplyOnOffshore(supplyTO.getSupplyOnOffshore());
		supplyDetail.setCandidateLocation(supplyTO.getCandidateLocation());
		supplyDetail.setOnBoardingDate(supplyTO.getOnBoardingDate());
		supplyDetail.setRrNumber(supplyTO.getRrNumber());
		supplyDetail.setSfId(supplyTO.getSfId());
		supplyDetail.setComments(supplyTO.getComments());
		supplyDetail.setArchived(supplyTO.isArchived());
		supplyDetail.setCreatedDate(supplyTO.getCreatedDate());
		supplyDetail.setModifiedDate(supplyTO.getModifiedDate());
		supplyDetail.setCreatedBy(populateUser(supplyTO.getCreatedBy()));

		/*List<SupplyMappingTO> supplyMappingTOList = supplyTO.getSupplyMapping();
		if(CollectionUtils.isNotEmpty(supplyMappingTOList)){
			Set<DemandSupplyMapping> demandMappings = new HashSet<>();
			for(SupplyMappingTO supplyMappingTO : supplyMappingTOList) {
				DemandSupplyMapping mapping = new DemandSupplyMapping();
				mapping.setMappingId(supplyMappingTO.getMappingId());
				mapping.setClientInterviewDate(supplyMappingTO.getClientInterviewDate());
				mapping.setInterviewLocation(supplyMappingTO.getInterviewLocation());
				mapping.setSelectionStatus(supplyMappingTO.getSelectionStatus());
				mapping.setRemarks(supplyMappingTO.getRemarks());
				mapping.setSupply(supplyDetail);
				demandMappings.add(mapping);

			}
			supplyDetail.setDemandMappings(demandMappings);
		}*/

		return supplyDetail;
	}

	private User populateUser(String emailId) {
		User user = new User();
		user.setEmailId(emailId);
		return user;
	}
}
