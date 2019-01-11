package com.tracker.service.projectTracker;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tracker.model.projectTracker.PanelList;
import com.tracker.repository.projectTracker.PanelListRepo;

@Service
@Transactional
public class PanelListServiceImpl implements  PanelListService {

	@Autowired
	PanelListRepo panelListRepo;
	@Override
	public PanelList addPanelList(PanelList panelList) {
		return panelListRepo.save(panelList);
	}
	@Override
	public List<PanelList> getAllPanelList() {
		return panelListRepo.findAll();
	}
	

}
