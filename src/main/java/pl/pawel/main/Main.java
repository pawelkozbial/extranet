package pl.pawel.main;

import javax.inject.Inject;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;

import pl.pawel.extranet.model.Role;
import pl.pawel.extranet.model.User;
import pl.pawel.extranet.service.RoleService;
import pl.pawel.extranet.service.UserService;

public class Main {

	ApplicationContext context = new ClassPathXmlApplicationContext(
			"/META-INF/spring/spring-context.xml");
	UserService userService = (UserService) context.getBean("userServiceImpl");
	RoleService roleService = (RoleService) context.getBean("roleServiceImpl");
	MailMail mail = (MailMail) context.getBean("mailMail");

	@Inject
	ShaPasswordEncoder passwordEncoder;

	public static void main(String[] args) {

		new Main().getUsers();
	}

	private void getUsers() {

		Role role = roleService.getRoleById(2);

		User user = new User();
		user.setEmail("user1");
		user.setPassword("user");
		user.setRole(role);
		// userService.addUser(user);

		User test = userService.findOne(2);
		System.out.println(test);
		test.setPassword("nowe haslo");
		userService.updateUser(test);
		System.out.println(test);

		// userService.removeUser(3);
	}

}
