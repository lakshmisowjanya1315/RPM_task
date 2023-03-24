package com.example.sb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sb.model.Profile;
import com.example.sb.repository.ProfileRepository;

@Service
public class ProfileServiceImpl implements ProfileService {
	
	@Autowired
	private ProfileRepository pr;

	@Override
	public List<Profile> getAllProfiles() {
		
		return pr.findAll();
	}

	@Override
	public Profile getProfile(Long id){
		return  pr.findById(id).orElse(null);
	}

	@Override
	public void saveProfile(Profile profile) {
		this.pr.save(profile);

	}

	@Override
	public void deleteEmployeeById(long id) {
		this.pr.deleteById(id);
	}

}
