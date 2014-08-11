package pl.pawel.extranet.service;

import java.util.List;

import pl.pawel.extranet.model.Role;

public interface RoleService {

	public List<Role> listRole();
	public Role getRoleById(int id);
}
