package ec.group.bits.web.restful;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.EJBTransactionRolledbackException;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ec.group.bits.service.UserService;
import ec.group.bits.web.restful.error.RestfulException;

@Path ("/users")
@Stateless
@LocalBean
public class UsersRestfulService {
	
	@EJB
	UserService userService;
	
	@GET
	@Path ("/{realm}/role/{roleName}")
	@Produces (MediaType.APPLICATION_JSON)
	@TransactionAttribute (TransactionAttributeType.NOT_SUPPORTED)
	public List<String> getUsers (@PathParam (value="realm") String realm, @PathParam (value="roleName") String roleName) throws RestfulException {
		try {
			return userService.searchUsers(realm, roleName);
		}
		catch (EJBTransactionRolledbackException e) {
			System.out.println("ejb rollback " + e.getMessage());
//			e.printStackTrace();
			throw new RestfulException(e);
		}
		
	}
}
