package com.example.sb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sb.model.Profile;

public interface ProfileRepository extends JpaRepository<Profile, Long>{

}
