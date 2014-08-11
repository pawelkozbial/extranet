package pl.pawel.extranet.abstracts;

import org.springframework.stereotype.Repository;

import pl.pawel.extranet.model.User;

@Repository
public class FooDAO extends GenericHibernateDAO<User> {

	//public FooDAO() {
	//	setEntityClass(User.class);
	//}
}
