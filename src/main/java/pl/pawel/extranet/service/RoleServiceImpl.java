package pl.pawel.extranet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.pawel.extranet.dao.RoleDAO;
import pl.pawel.extranet.model.Role;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

	@Autowired
	public RoleDAO roleDAO;

	public List<Role> listRole() {
		return roleDAO.listRole();
	}

	public Role getRoleById(int id) {
		return roleDAO.getRoleById(id);
	}
}
