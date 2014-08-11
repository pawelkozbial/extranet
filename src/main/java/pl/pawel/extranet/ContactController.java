package pl.pawel.extranet;

import java.security.Principal;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.pawel.extranet.model.Contact;
import pl.pawel.extranet.model.User;
import pl.pawel.extranet.service.ContactService;
import pl.pawel.extranet.service.RoleService;
import pl.pawel.extranet.service.UserService;

@Controller
@RequestMapping("/")
public class ContactController {

	private static Log log = LogFactory.getLog(ContactController.class);

	@Autowired
	private ContactService contactService;

	@Autowired
	private RoleService roleService;

	@Autowired
	private UserService userService;

	@RequestMapping("")
	public String listContacts(Map<String, Object> map) {

		map.put("contact", new Contact());
		map.put("contactList", contactService.listContact());
		map.put("roleList", roleService.listRole());

		return "contact";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addContact(@ModelAttribute("contact") @Valid Contact contact,
			BindingResult result, ModelMap map, HttpServletRequest request) {

		String email = request.getParameter("email");
		String email1 = request.getParameter("email1");
		ObjectError emailRepeatError = new ObjectError("email1",
				"Adresy email muszą się zgadzać");

		if (!email.equals(email1) || !email1.equals(email))
			result.addError(emailRepeatError);

		if (result.hasErrors()) {

			map.put("rowne", false);
			map.put("emailRepeatError", emailRepeatError.getDefaultMessage());
			map.put("contactList", contactService.listContact());
			map.put("roleList", roleService.listRole());
			return "contact";
		}
		contactService.addContact(contact);
		map.put("contactList", contactService.listContact());
		map.put("roleList", roleService.listRole());

		// contact.clear();

		return "redirect:/contact";

	}

	@RequestMapping(value = "/delete/{contactId}", method = RequestMethod.GET)
	public String deleteContact(@PathVariable("contactId") Long contactId) {

		contactService.removeContact(contactId);

		return "redirect:/";
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping("/welcome")
	public String welcome(Principal principal) {
		List<User> userList = userService.findAll();
		for (User u : userList) {
			if (u.getEmail().equals(principal.getName()))
				log.info("Zalogowany jako: " + principal.getName() + " id: "
						+ u.getId());
		}

		return "welcome";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(ModelMap model) {

		return "login";

	}

	@RequestMapping(value = "/loginfailed", method = RequestMethod.GET)
	public String loginerror(ModelMap model) {
		model.addAttribute("error", "true");

		return "login";

	}

	@RequestMapping(value = "/contact", method = RequestMethod.GET)
	public String displayCustomerForm(ModelMap model) {

		model.addAttribute("contact", new Contact());
		return "redirect:/";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(ModelMap model) {
		return "login";
	}

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test(ModelMap model) {
		return "test";
	}

	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public String accessDenied(ModelMap model, Principal principal) {
		String username = principal.getName();
		model.put("author", username);
		return "403";
	}
}
