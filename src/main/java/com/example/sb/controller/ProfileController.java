package com.example.sb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.sb.model.Profile;
import com.example.sb.service.ProfileService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Controller
public class ProfileController {
	
	@Autowired
	private ProfileService ps;
	

	@RequestMapping("/")
	public String viewHomePage(Model m) throws ParseException {
	//	System.out.print(new Date());
		String pattern = "yyyy-MM-dd HH:mm:ss";
		List<Profile> profiles = ps.getAllProfiles();
		@SuppressWarnings("unused")
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

	for (Profile profile: profiles) {
			if(profile.getBlockTime() != null){
	//	Date tem = simpleDateFormat.parse("2022-09-18 20:10:25");
				long diffInMillies1 = Math.abs(new Date().getTime() - profile.getBlockTime().getTime());
			long diff1 = TimeUnit.DAYS.convert(diffInMillies1, TimeUnit.MILLISECONDS);
			if(diff1 >= 2){
					profile.setBlockTime(null);
					profile.setBlock("false");
					ps.saveProfile(profile);
				}
		
			}
		}
		m.addAttribute("listProfiles", profiles);
		return "index";
	}
	
	@GetMapping("/showNewEmployeeForm")
	 public String showNewEmployeeForm(Model model) {
	  Profile profile = new Profile();
	  model.addAttribute("profile", profile);
	  return "new_profile";
	 }
	
	 @PostMapping("/saveProfile")
	 public String saveProfile(@ModelAttribute("profile") Profile profile) throws ParseException {
	  ps.saveProfile(profile);
	  return "redirect:/";
	 }

	 @GetMapping("/deleteProfile/{id}")
	 public String deleteEmployee(@PathVariable (value = "id") long id) 
	 {
	  this.ps.deleteEmployeeById(id);
	  return "redirect:/";
	 }

@GetMapping("/updateBlock/{id}")
	public String updateBlock(@PathVariable (value = "id") long id, Model model)
	{
	Profile profile = ps.getProfile(id);
		profile.setBlockTime(new Date());
		profile.setBlock("true");
		this.ps.saveProfile(profile);
		return "redirect:/";
	}


@GetMapping("/enableBlock/{id}")
public String enableBlock(@PathVariable (value = "id") long id, Model model)
{
Profile profile = ps.getProfile(id);
	profile.setBlockTime(null);
	profile.setBlock("false");
	this.ps.saveProfile(profile);
	return "redirect:/";
 }
}
