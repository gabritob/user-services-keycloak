package ec.group.bits.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import ec.group.bits.dao.UserDAO;

@Stateless
@LocalBean
public class UserService {
	
	@EJB
	UserDAO userDAO;
	
	@TransactionAttribute (TransactionAttributeType.REQUIRED)
	public List<String> searchUsers (String realm, String roleName) {
		return this.userDAO.searchUsers(realm, roleName);
	}

}




