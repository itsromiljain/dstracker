package com.tracker.admin.service;

import java.util.List;

import com.tracker.admin.model.Experience;

public interface ExperienceService {

	Experience addYrOfExp(Experience experience);
	List<Experience> getAllyrOfExp();

}
