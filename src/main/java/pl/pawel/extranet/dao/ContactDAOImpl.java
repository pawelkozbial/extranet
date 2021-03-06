package pl.pawel.extranet.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pl.pawel.extranet.model.Contact;

@Repository
public class ContactDAOImpl implements ContactDAO {

	@Autowired
	public SessionFactory sessionFactory;

	@Override
	public void addContact(Contact contact) {
		sessionFactory.getCurrentSession().save(contact);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Contact> listContact() {
		return sessionFactory.getCurrentSession().createQuery("from Contact")
				.list();
	}

	@Override
	public void removeContact(Long id) {
		Contact contact = (Contact) sessionFactory.getCurrentSession().load(
				Contact.class, id);
		if (contact != null) {
			sessionFactory.getCurrentSession().delete(contact);
		}
	}

}
