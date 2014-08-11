package pl.pawel.extranet.abstracts;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.pawel.extranet.model.User;

@Service
@Transactional
public class FooService implements IFooService{

	@Autowired
	IGenericDAO<User> genFooDAO;

	public User findOne(long id) {
		return genFooDAO.findOne(id);
	}

	public List<User> findAll() {
		return genFooDAO.findAll();
	}

	public void create(User entity) {
		genFooDAO.create(entity);
	}

	public void update(User entity) {
		genFooDAO.update(entity);
	}

	public void delete(User entity) {
		genFooDAO.delete(entity);
	}

	public void deleteById(long entityId) {
		User entity = findOne(entityId);
		delete(entity);
	}

	public int count(long id) {
		genFooDAO.count(id);
		return 0;
	}

	public void setGenFooDAO(IGenericDAO<User> genFooDAO) {
		this.genFooDAO = genFooDAO;
	}
}
