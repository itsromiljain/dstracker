package com.tracker.admin.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tracker.admin.model.PanelList;
import com.tracker.admin.repo.PanelListRepo;
import com.tracker.admin.service.PanelListService;

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
