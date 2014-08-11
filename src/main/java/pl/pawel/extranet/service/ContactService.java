package pl.pawel.extranet.service;

import java.util.List;

import pl.pawel.extranet.model.Contact;

public interface ContactService {

	public void addContact(Contact contact);
	public List<Contact> listContact();
	public void removeContact(Long id);
}
