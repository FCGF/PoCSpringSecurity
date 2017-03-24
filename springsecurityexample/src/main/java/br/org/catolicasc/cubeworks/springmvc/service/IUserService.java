package br.org.catolicasc.cubeworks.springmvc.service;

import java.util.List;
import br.org.catolicasc.cubeworks.springmvc.model.User;

public interface IUserService {

	User findById(int id);
    
    User findBySSO(String sso);
     
    void saveUser(User user);
     
    void updateUser(User user);
     
    void deleteUserBySSO(String sso);
 
    List<User> findAllUsers(); 
     
    boolean isUserSSOUnique(Integer id, String sso);
    
}
