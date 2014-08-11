package pl.pawel.extranet.abstracts;

import java.io.Serializable;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractHibernateDAO<T extends Serializable> {

	@Autowired
	private SessionFactory sessionFactory;

	private Class<T> entityClass;

	@SuppressWarnings("unchecked")
	public T findOne(long id) {
		System.out.println(entityClass);
		return (T) getCurrentSession().get(entityClass, id);
	}

	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		System.out.println(entityClass.getName());
		return getCurrentSession().createQuery("from " + entityClass.getName())
				.list();
	}

	public void create(T entity) {
		getCurrentSession().persist(entity);
	}

	public void update(T entity) {
		getCurrentSession().merge(entity);
	}

	public void delete(T entity) {
		getCurrentSession().delete(entity);
	}

	public void deleteById(long entityId) {
		T entity = findOne(entityId);
		delete(entity);
	}

	@SuppressWarnings("unchecked")
	public int count(long id) {
		System.out.println(getCurrentSession());
		SQLQuery querySQL = getCurrentSession()
				.createSQLQuery(
						"select u.username from user_roles ur join users u on ur.user_id=u.id join roles r on ur.role_id=r.id where r.id = :id");
		querySQL.setLong("id", id);
		List<T> list = querySQL.list();
		System.out.println(list);

		List<Object[]> roleUsers = getCurrentSession().createQuery(
				"from User u join u.role r where r.id = 1").list();
		// for (int i = 0; i < roleUsers.size(); i++)
		// System.out.println("\nroleUsers" + roleUsers.get(i)[1]
		// + "\n");
		
		System.out.println("\nroleUsers: " + roleUsers.get(0)[0] + "\n");
		System.out.println("\nroleUsers: " + roleUsers.get(0)[1] + "\n");
		
		return 0;
	}

	protected final Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	public void setEntityClass(Class<T> entityClass) {
		this.entityClass = entityClass;
	}
}
