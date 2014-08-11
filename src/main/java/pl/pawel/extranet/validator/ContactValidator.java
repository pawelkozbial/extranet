package pl.pawel.extranet.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import pl.pawel.extranet.model.Contact;

public class ContactValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Contact.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Contact contact = (Contact) target;
		if (contact.getLastname().length() < 5) {
			errors.rejectValue("lastname", "pole musi być większe od 5");
		}
	}
}
