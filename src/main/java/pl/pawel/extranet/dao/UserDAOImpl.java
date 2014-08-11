package pl.pawel.extranet.dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pl.pawel.extranet.model.User;

@SuppressWarnings("unchecked")
@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void create(User user) {
		sessionFactory.getCurrentSession().save(user);
	}

	@Override
	public void update(long id) {
		User user = (User) sessionFactory.getCurrentSession().load(User.class,
				id);
		if (user != null)
			sessionFactory.getCurrentSession().update(user);
	}

	@Override
	public void updateUser(User user) {
		/*
		 * User tmp = (User) sessionFactory.getCurrentSession().load(User.class,
		 * user.getId()); if (tmp != null)
		 */
		sessionFactory.getCurrentSession().update(user);
	}

	@Override
	public User findOne(long id) {

		Query query = sessionFactory.getCurrentSession().createQuery(
				"from User where id = :id");
		query.setLong("id", id);
		User user = (User) query.uniqueResult();
		Hibernate.initialize(user.getRole());
		return user;
	}

	@Override
	public User findOne(String email) {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"from User where email = :email");
		query.setString("email", email);
		User user = (User) query.uniqueResult();
		Hibernate.initialize(user.getRole());
		return user;
	}

	@Override
	public List<User> findAll() {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"from User order by id");
		List<User> users = query.list();
		for (User u : users)
			Hibernate.initialize(u.getRole());
		return users;
	}

	@Override
	public List<User> findAll(int page) {
		int limitResultsPerPage = 2;
		Query query = sessionFactory.getCurrentSession().createQuery(
				"from User order by id");
		query.setFirstResult(page * limitResultsPerPage);
		query.setMaxResults(limitResultsPerPage);
		List<User> users = query.list();
		for (User u : users)
			Hibernate.initialize(u.getRole());
		return users;
	}

	@Override
	public void delete(User user) {
		sessionFactory.getCurrentSession().delete(user);

	}

	@Override
	public void deleteById(long id) {
		// User user = (User)
		// sessionFactory.getCurrentSession().load(User.class,
		// id);
		User user = findOne(id);
		if (user != null)
			sessionFactory.getCurrentSession().delete(user);
	}

}