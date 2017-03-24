package br.org.catolicasc.cubeworks.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.org.catolicasc.cubeworks.springmvc.dao.IUserProfileDao;
import br.org.catolicasc.cubeworks.springmvc.model.UserProfile;

@Service("userProfileService")
@Transactional
public class UserProfileService implements IUserProfileService {

	@Autowired
    IUserProfileDao dao;
	
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
