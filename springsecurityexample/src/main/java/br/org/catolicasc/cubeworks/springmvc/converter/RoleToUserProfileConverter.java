package br.org.catolicasc.cubeworks.springmvc.converter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
 
import br.org.catolicasc.cubeworks.springmvc.model.UserProfile;
import br.org.catolicasc.cubeworks.springmvc.service.IUserProfileService;
 
/**
 * Uma classe Converter utilizada para converter o id do usuário em um UserProfile
 */
@Component
public class RoleToUserProfileConverter implements Converter<Object, UserProfile>{
 
    static final Logger logger = LoggerFactory.getLogger(RoleToUserProfileConverter.class);
     
    @Autowired
    IUserProfileService userProfileService;
 
    /**
     * Retorna um UserProfile pelo id
     * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
     */
    public UserProfile convert(Object element) {
        Integer id = Integer.parseInt((String)element);
        UserProfile profile= userProfileService.findById(id);
        logger.info("Profile : {}",profile);
        return profile;
    }
     
}
