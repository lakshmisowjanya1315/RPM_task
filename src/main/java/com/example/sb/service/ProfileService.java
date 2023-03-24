package com.example.sb.service;

import java.util.List;

import com.example.sb.model.Profile;

public interface ProfileService {
	
	List<Profile> getAllProfiles();

	Profile getProfile(Long id);

	void saveProfile(Profile profile);

	void deleteEmployeeById(long id);


}
