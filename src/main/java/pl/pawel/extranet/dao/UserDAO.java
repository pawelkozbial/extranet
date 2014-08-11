package pl.pawel.extranet.dao;

import java.util.List;

import pl.pawel.extranet.model.User;

public interface UserDAO {

	public void create(User user);
	public void update(long id);
	public void updateUser(User user);
	public User findOne(long id);
	public User findOne(String email);
	public List<User> findAll();
	public List<User> findAll(int page);
	public void delete(User user);
	public void deleteById(long id);
}
