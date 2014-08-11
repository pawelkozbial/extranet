package pl.pawel.extranet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.pawel.extranet.dao.ContactDAO;
import pl.pawel.extranet.model.Contact;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactDAO contactDAO;

	//@Autowired
	//private PasswordEncoder passwordEncoder;

	/*@Autowired
	private SaltSource saltSource;*/

	@Transactional
	public void addContact(Contact contact) {
		contactDAO.addContact(contact);
	}

	@Transactional
	public List<Contact> listContact() {
		//System.out.println(passwordEncoder.encodePassword("pawel", saltSource));
		return contactDAO.listContact();
	}

	@Transactional
	public void removeContact(Long id) {
		contactDAO.removeContact(id);
	}
}
