package pl.pawel.extranet.dao;

import java.util.List;

import pl.pawel.extranet.model.Role;

public interface RoleDAO {

	public List<Role> listRole();
	public Role getRoleById(int id);
}
