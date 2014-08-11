package pl.pawel.extranet.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pl.pawel.extranet.model.Role;

@Repository
public class RoleDAOImpl implements RoleDAO {

	@Autowired
	public SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Role> listRole() {
		return sessionFactory.getCurrentSession().createQuery("from Role")
				.list();
	}

	@Override
	public Role getRoleById(int id) {
		Role role = (Role) sessionFactory.getCurrentSession().load(Role.class,
				id);
		return role;
	}
}
