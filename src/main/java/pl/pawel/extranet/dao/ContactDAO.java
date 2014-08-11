package pl.pawel.extranet.dao;

import java.util.List;

import pl.pawel.extranet.model.Contact;

public interface ContactDAO {

	public void addContact(Contact contact);

	public List<Contact> listContact();

	public void removeContact(Long id);
}
