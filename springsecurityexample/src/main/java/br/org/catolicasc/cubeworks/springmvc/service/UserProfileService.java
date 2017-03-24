package br.org.catolicasc.cubeworks.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.org.catolicasc.cubeworks.springmvc.dao.UserProfileDao;
import br.org.catolicasc.cubeworks.springmvc.model.UserProfile;

public class UserProfileService implements IUserProfileService {

	@Autowired
    UserProfileDao dao;
	
	public UserProfile findById(int id) {
        return dao.findById(id);
    }
 
    public UserProfile findByType(String type){
        return dao.findByType(type);
    }
 
    public List<UserProfile> findAll() {
        return dao.findAll();
    }

}
