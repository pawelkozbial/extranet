package pl.pawel.extranet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.pawel.extranet.dao.UserDAO;
import pl.pawel.extranet.model.User;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	public UserDAO userDAO;

	public void create(User user) {
		userDAO.create(user);
	}

	public void update(long id) {
		userDAO.update(id);
	}

	public void updateUser(User user) {
		userDAO.updateUser(user);

	}

	public User findOne(long id) {
		return userDAO.findOne(id);
	}
	
	@Override
	public User findOne(String email) {
		return userDAO.findOne(email);
	}

	public List<User> findAll() {
		return userDAO.findAll();
	}

	public List<User> findAll(int page) {
		return userDAO.findAll(page);
	}

	public void delete(User user) {
		userDAO.delete(user);

	}

	public void deleteById(long id) {
		userDAO.deleteById(id);
	}
}
