package ec.group.bits.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;

@Local (UserDAO.class)
@Stateless
public class UserDAO {
	
	public List<String> searchUsers(String realm, String role) {
		List<String> listaUsuarios = new ArrayList<String>();
		listaUsuarios.add("Adriana");
		listaUsuarios.add("Galo");
		listaUsuarios.add("Alex");
		listaUsuarios.add("Dustin");
		return listaUsuarios;
	}

}


