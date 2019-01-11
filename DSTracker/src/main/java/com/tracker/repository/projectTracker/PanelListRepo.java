package com.tracker.repository.projectTracker;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tracker.model.projectTracker.PanelList;

@Repository
public interface PanelListRepo extends JpaRepository<PanelList, Long> {

}
