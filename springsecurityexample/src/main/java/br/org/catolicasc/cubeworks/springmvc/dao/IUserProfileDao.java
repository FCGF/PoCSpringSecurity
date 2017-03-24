package br.org.catolicasc.cubeworks.springmvc.dao;

import java.util.List;
import br.org.catolicasc.cubeworks.springmvc.model.UserProfile;

public interface IUserProfileDao {

	 	List<UserProfile> findAll();
     
	    UserProfile findByType(String type);
	     
	    UserProfile findById(int id);
	    
}
