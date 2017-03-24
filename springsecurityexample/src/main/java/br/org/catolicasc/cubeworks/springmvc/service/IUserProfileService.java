package br.org.catolicasc.cubeworks.springmvc.service;

import java.util.List;

import br.org.catolicasc.cubeworks.springmvc.model.UserProfile;

public interface IUserProfileService {

	UserProfile findById(int id);
	 
    UserProfile findByType(String type);
     
    List<UserProfile> findAll();
    
}
