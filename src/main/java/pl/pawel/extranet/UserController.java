package pl.pawel.extranet;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.pawel.extranet.abstracts.IGenericService;
import pl.pawel.extranet.model.Role;
import pl.pawel.extranet.model.User;
import pl.pawel.extranet.service.RoleService;
import pl.pawel.extranet.service.UserService;
import pl.pawel.extranet.validator.CustomSQLDateEditor;
import pl.pawel.main.MailMail;

@Controller
@RequestMapping("/user")
public class UserController {

	private static final Logger log = LoggerFactory
			.getLogger(UserController.class);

	@Autowired
	public UserService userService;

	@Autowired
	public RoleService roleService;

	@Autowired
	private IGenericService<User> fooService;

	@Autowired
	public MailMail mail;

	@Autowired
	ShaPasswordEncoder passwordEncoder;

	User user = null;
	String encodedPasswd = null;
	Role role = null;
	Boolean enabled = null;

	@RequestMapping(value = "")
	public String list(ModelMap map) {

		map.put("userList", userService.findAll());

		return "user/list";
	}

	@RequestMapping(value = "/new")
	public String listUsers(ModelMap map) {

		map.put("user", new User());
		map.put("userList", userService.findAll());
		map.put("roleList", roleService.listRole());

		return "user/user";
	}

	// @PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addUser(@ModelAttribute("user") @Valid User user,
			BindingResult result, ModelMap map, HttpServletRequest request) {

		int roleId = Integer.parseInt(request.getParameter("options"));
		Boolean enabled = Boolean.parseBoolean(request
				.getParameter("enableOptions"));

		repeatError("password", "repeatPassword", result, request);

		if (result.hasErrors()) {

			user.setPassword(null);
			map.put("equalFields", false);
			map.put("passwordRepeatError", "Hasła muszą być takie same");
			map.put("userList", userService.findAll());
			map.put("roleList", roleService.listRole());

			return "user/user";
		}

		mail.sendMail(
				"pk_82@wp.pl",
				"pk_82@wp.pl",
				"Konto w systemie EXTRANET zostało utworzone",
				"Witamy w systemie EXTRANET,"
						+ "\n\nTwoje dane do logowania to:\nLogin: "
						+ user.getEmail() + "\nHasło: " + user.getPassword()
						+ "\n\nŻyczymy bezproblemowego użytkowania systemu");

		user.setRole(roleService.getRoleById(roleId));
		encodedPasswd = passwordEncoder.encodePassword(user.getPassword(),
				user.getEmail());
		user.setPassword(encodedPasswd);
		user.setEnabled(enabled);

		map.put("userList", userService.findAll());
		map.put("roleList", roleService.listRole());

		userService.create(user);

		return "redirect:/user";

	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addUser() {
		return "redirect:/user";
	}

	@RequestMapping(value = "/delete/{userId}", method = RequestMethod.GET)
	public String deleteUser(@PathVariable("userId") int userId) {

		userService.deleteById(userId);

		return "redirect:/user";
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "/edit/{userId}", method = RequestMethod.GET)
	public String editUser(@PathVariable("userId") int userId, ModelMap map) {

		user = userService.findOne(userId);
		role = user.getRole();
		enabled = user.getEnabled();
		user.setPassword(null);

		map.put("enabled", enabled);
		map.put("roleId", role.getId());
		map.put("user", user);
		map.put("roleList", roleService.listRole());

		return "user/edit";
	}

	@PreAuthorize("isAuthenticated()")
	@RequestMapping(value = "/edit")
	public String edit(ModelMap map, Principal principal,
			HttpServletRequest request) {

		user = userService.findOne(principal.getName());
		role = user.getRole();
		enabled = user.getEnabled();
		user.setPassword(null);

		map.put("enabled", enabled);
		map.put("roleId", role.getId());
		map.put("user", user);
		map.put("roleList", roleService.listRole());
		return "user/edit";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@Valid User user, BindingResult result, ModelMap map,
			HttpServletRequest request) {

		repeatError("password", "repeatPassword", result, request);
		if (result.hasErrors()) {

			user.setPassword(null);
			map.put("equalFields", false);
			map.put("passwordRepeatError", "Hasła muszą być takie same");
			map.put("roleList", roleService.listRole());
			user.setPassword(null);

			return "user/edit";
		}

		mail.sendMail(
				"pk_82@wp.pl",
				"pk_82@wp.pl",
				"Zmiana hasła w systemie EXTRANET",
				"Witamy w systemie EXTRANET,"
						+ "\n\nTwoje dane do logowania to:\nLogin: "
						+ user.getEmail() + "\nHasło: " + user.getPassword()
						+ "\n\nŻyczymy bezproblemowego użytkowania systemu");

		user.setRole(role);
		encodedPasswd = passwordEncoder.encodePassword(user.getPassword(),
				user.getEmail());
		user.setPassword(encodedPasswd);

		map.put("roleList", roleService.listRole());
		userService.updateUser(user);

		return "redirect:/";
	}

	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String update() {
		return "redirect:/user";
	}

	@RequestMapping(value = "/updateUser", method = RequestMethod.POST)
	public String updateUser(@Valid User user, BindingResult result,
			ModelMap map, HttpServletRequest request) {

		int roleId = Integer.parseInt(request.getParameter("options"));
		Boolean enabled = Boolean.parseBoolean(request
				.getParameter("enableOptions"));
		repeatError("password", "repeatPassword", result, request);
		if (result.hasErrors()) {

			user.setPassword(null);
			map.put("equalFields", false);
			map.put("passwordRepeatError", "Hasła muszą być takie same");
			map.put("roleList", roleService.listRole());
			user.setPassword(null);

			return "user/edit";
		}
		
		mail.sendMail(
				"pk_82@wp.pl",
				"pk_82@wp.pl",
				"Zmiana hasła w systemie EXTRANET",
				"Witamy w systemie EXTRANET,"
						+ "\n\nTwoje dane do logowania to:\nLogin: "
						+ user.getEmail() + "\nHasło: " + user.getPassword()
						+ "\n\nŻyczymy bezproblemowego użytkowania systemu");

		user.setEnabled(enabled);
		user.setRole(roleService.getRoleById(roleId));
		encodedPasswd = passwordEncoder.encodePassword(user.getPassword(),
				user.getEmail());
		user.setPassword(encodedPasswd);

		map.put("roleList", roleService.listRole());
		userService.updateUser(user);

		return "redirect:/";
	}

	@RequestMapping(value = "/updateUser", method = RequestMethod.GET)
	public String updateUser() {
		return "redirect:/user";
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		sdf.setLenient(true);
		binder.registerCustomEditor(Date.class, new CustomSQLDateEditor(sdf,
				false, 10));
	}

	private void repeatError(String primaryField, String repeatField,
			BindingResult result, HttpServletRequest request) {
		String primField = request.getParameter(primaryField);
		String repField = request.getParameter(repeatField);
		ObjectError error = new ObjectError(repeatField, null);
		if (!primField.equals(repField) && !repField.equals(primField))
			result.addError(error);
	}

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test(ModelMap map) {
		map.put("userList", userService.findAll());
		map.put("roleList", roleService.listRole());
		return "test";
	}
}
