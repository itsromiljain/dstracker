package com.tracker.model.projectTracker;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PanelList")
public class PanelList {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long PanelList_id;
	private String PanelList;
	public long getPanelList_id() {
		return PanelList_id;
	}
	public void setPanelList_id(long panelList_id) {
		PanelList_id = panelList_id;
	}
	public String getPanelList() {
		return PanelList;
	}
	public void setPanelList(String panelList) {
		PanelList = panelList;
	}
	

}
