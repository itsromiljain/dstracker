package com.tracker.demand.service.impl;

import com.tracker.demand.pojo.DemandTO;
import com.tracker.demand.repository.DemandRepo;
import com.tracker.demand.service.DemandService;
import com.tracker.entity.DemandDetail;
import com.tracker.entity.DemandSupplyMapping;
import com.tracker.entity.SupplyDetail;
import com.tracker.supply.pojo.SupplyMappingTO;
import com.tracker.supply.pojo.SupplyTO;
import com.tracker.user.model.User;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;


@Service
@Transactional
public class DemandServiceImpl implements DemandService {
	
	@Autowired
	private DemandRepo demandRepo;

	@Override
	public DemandTO getDemandById(String emailId, String demandId) {
		Optional<DemandDetail> optDemandDetail = demandRepo.findById(emailId, demandId);
		DemandTO demandTO = optDemandDetail.isPresent()? convertDemandDetailToDemandTO(optDemandDetail.get()):null;
		return demandTO;
	}

	@Override
	public List<DemandTO> getAllDemands() {
		return convertDemandDetailsToDemandTOs(demandRepo.findAll());
	}

	@Override
	public List<DemandTO> getDemandsByUser(String emailId) {
		return convertDemandDetailsToDemandTOs(demandRepo.findById(emailId));
	}

	@Override
	public List<DemandTO> getAllArchivedDemands() {
		return convertDemandDetailsToDemandTOs(demandRepo.findAllArchivedDemands());
	}

	@Override
	public DemandTO createDemand(String emailId, DemandTO demandTO) {
		// Make sure isArchived set to 0 while creating demand
		demandTO.setDemandId(demandRepo.save(convertDemandTOToDemandDetail(emailId, demandTO)).getDemandId());
		return demandTO;
	}

	@Override
	public void updateDemand(String emailId, DemandTO demandTO) {
		demandRepo.save(convertDemandTOToDemandDetail(emailId, demandTO));
	}

	@Override
	public void archiveDemand(List<String> demandIds) {
		// set isArchived as 1
		demandRepo.archiveDemand(demandIds);
	}


	private List<DemandTO> convertDemandDetailsToDemandTOs(List<DemandDetail> demandDetails){
		List<DemandTO> demandTOList = new ArrayList<>();
		for (DemandDetail demandDetail : demandDetails){
			demandTOList.add(convertDemandDetailToDemandTO(demandDetail));
		}
		return demandTOList;
	}

	private DemandTO convertDemandDetailToDemandTO(DemandDetail demandDetail) {
		DemandTO demandTO = new DemandTO();
		demandTO.setDemandId(demandDetail.getDemandId());
		demandTO.setRole(demandDetail.getRole());
		demandTO.setSkills(demandDetail.getSkills());
		demandTO.setAdditionalSkills(demandDetail.getAdditionalSkills());
		demandTO.setExperience(demandDetail.getExperience());
		demandTO.setDemandType(demandDetail.getDemandType());
		demandTO.setDemandStatus(demandDetail.getDemandStatus());
		demandTO.setPriority(demandDetail.getPriority());
		demandTO.setLocation(demandDetail.getLocation());
		demandTO.setDemandOnOffshore(demandDetail.getDemandOnOffshore());
		demandTO.setAppleManager(demandDetail.getAppleManager());
		demandTO.setPortfolioAnchor(demandDetail.getPortfolioAnchor());
		demandTO.setSuggestedPanel(demandDetail.getSuggestedPanel());
		demandTO.setJobDescription(demandDetail.getJobDescription());
		demandTO.setBanjoRfr(demandDetail.getBanjoRfr());
		demandTO.setOppty(demandDetail.getOppty());
		demandTO.setRrOnshore(demandDetail.getRrOnshore());
		demandTO.setSfOnOffshore(demandDetail.getSfOnOffshore());
		demandTO.setClosureDate(demandDetail.getClosureDate());
		demandTO.setCreatedDate(demandDetail.getCreatedDate());
		demandTO.setModifiedDate(demandDetail.getModifiedDate());
		demandTO.setCreatedBy(demandDetail.getCreatedBy().getEmailId());
		demandTO.setSubmittedBy(demandDetail.getSubmittedBy().getEmailId());
		demandTO.setArchived(demandDetail.isArchived());
		// Populate Supply
		populateSupply(demandDetail, demandTO);
		return demandTO;
	}

	private void populateSupply(DemandDetail demandDetail, DemandTO demandTO) {
		//Adding Selected Supply If available.
		Set<DemandSupplyMapping> supplyMappings=  demandDetail.getSupplyMappings();
		if(CollectionUtils.isNotEmpty(supplyMappings)){
			Set<SupplyTO> supplyTOs = new HashSet<>();
			for(DemandSupplyMapping mapping: supplyMappings){
				SupplyTO supplyTO = new SupplyTO();
				supplyTO.setSupplyId(mapping.getSupply().getSupplyId());
				supplyTO.setCandidateName(mapping.getSupply().getCandidateName());
				supplyTO.setSkillSummary(mapping.getSupply().getSkillSummary());
				supplyTO.setExperienceYear(mapping.getSupply().getExperienceYear());
				supplyTO.setCandidateStatus(mapping.getSelectionStatus());
				supplyTO.setCandidateLocation(mapping.getSupply().getCandidateLocation());
				populateSupplyMappingTO(mapping, supplyTO);
				supplyTO.setMapped(true);
				supplyTOs.add(supplyTO);
			}
			demandTO.setSupply(supplyTOs);
		}
	}

	private void populateSupplyMappingTO(DemandSupplyMapping mapping, SupplyTO supplyTO) {
		List<SupplyMappingTO> supplyMappingTOs = new ArrayList<>();
		SupplyMappingTO supplyMappingTO = new SupplyMappingTO();
		supplyMappingTO.setMappingId(mapping.getMappingId());
		supplyMappingTO.setClientInterviewDate(mapping.getClientInterviewDate());
		supplyMappingTO.setInterviewLocation(mapping.getInterviewLocation());
		supplyMappingTO.setSelectionStatus(mapping.getSelectionStatus());
		supplyMappingTO.setRemarks(mapping.getRemarks());
		supplyMappingTOs.add(supplyMappingTO);
		supplyTO.setSupplyMapping(supplyMappingTOs);
	}

	private DemandDetail convertDemandTOToDemandDetail(String emailId, DemandTO demandTO) {
		DemandDetail demandDetail = new DemandDetail();
		demandDetail.setDemandId(demandTO.getDemandId());
		demandDetail.setRole(demandTO.getRole());
		demandDetail.setSkills(demandTO.getSkills());
		demandDetail.setAdditionalSkills(demandTO.getAdditionalSkills());
		demandDetail.setExperience(demandTO.getExperience());
		demandDetail.setDemandType(demandTO.getDemandType());
		demandDetail.setDemandStatus(demandTO.getDemandStatus());
		demandDetail.setPriority(demandTO.getPriority());
		demandDetail.setLocation(demandTO.getLocation());
		demandDetail.setDemandOnOffshore(demandTO.getDemandOnOffshore());
		demandDetail.setAppleManager(demandTO.getAppleManager());
		demandDetail.setPortfolioAnchor(demandTO.getPortfolioAnchor());
		demandDetail.setSuggestedPanel(demandTO.getSuggestedPanel());
		demandDetail.setJobDescription(demandTO.getJobDescription());
		demandDetail.setBanjoRfr(demandTO.getBanjoRfr());
		demandDetail.setOppty(demandTO.getOppty());
		demandDetail.setRrOnshore(demandTO.getRrOnshore());
		demandDetail.setSfOnOffshore(demandTO.getSfOnOffshore());
		demandDetail.setClosureDate(demandTO.getClosureDate());
		demandDetail.setCreatedDate(demandTO.getCreatedDate());
		demandDetail.setModifiedDate(demandTO.getModifiedDate());
		demandDetail.setCreatedBy(populateUser(emailId));
		demandDetail.setSubmittedBy(populateUser(emailId));
		demandDetail.setArchived(demandTO.isArchived());

		Set<SupplyTO> selectedSupply = demandTO.getSupply();
		if(CollectionUtils.isNotEmpty(selectedSupply)){
			Set<DemandSupplyMapping> supplyMappings = new HashSet<>();
			for(SupplyTO supplyTO: selectedSupply){
				DemandSupplyMapping demandSupplyMapping = new DemandSupplyMapping();
				SupplyDetail supplyDetail = new SupplyDetail();
				supplyDetail.setSupplyId(supplyTO.getSupplyId());
				demandSupplyMapping.setSupply(supplyDetail);
				demandSupplyMapping.setDemand(demandDetail);
				// There will always be one record per demand for one supply
				populateSupplyMapping(supplyTO.getSupplyMapping().get(0), demandSupplyMapping);
				supplyMappings.add(demandSupplyMapping);
			}
			demandDetail.setSupplyMappings(supplyMappings);
		}
		return demandDetail;
	}

	private void populateSupplyMapping(SupplyMappingTO supplyMappingTO, DemandSupplyMapping demandSupplyMapping) {
			if(supplyMappingTO.getMappingId() != null)
				demandSupplyMapping.setMappingId(supplyMappingTO.getMappingId());
			demandSupplyMapping.setClientInterviewDate(supplyMappingTO.getClientInterviewDate());
			demandSupplyMapping.setInterviewLocation(supplyMappingTO.getInterviewLocation());
			demandSupplyMapping.setSelectionStatus(supplyMappingTO.getSelectionStatus());
			demandSupplyMapping.setRemarks(supplyMappingTO.getRemarks());
	}

	private User populateUser(String emailId) {
		User user = new User();
		user.setEmailId(emailId);
		return user;
	}

}