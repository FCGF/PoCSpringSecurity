package br.org.catolicasc.cubeworks.springmvc.dao;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import br.org.catolicasc.cubeworks.springmvc.model.UserProfile;

@Repository("userProfileDao")
public class UserProfileDao extends AbstractDao<Integer, UserProfile> implements IUserProfileDao {

	@Override
	@SuppressWarnings("unchecked")
    public List<UserProfile> findAll(){
        Criteria crit = createEntityCriteria();
        crit.addOrder(Order.asc("type"));
        return (List<UserProfile>)crit.list();
    }

	@Override
	public UserProfile findByType(String type) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("type", type));
        return (UserProfile) crit.uniqueResult();
    }

	@Override
	public UserProfile findById(int id) {
        return getByKey(id);
    }

}
