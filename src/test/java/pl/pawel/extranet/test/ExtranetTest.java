package pl.pawel.extranet.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.pawel.extranet.model.Role;
import pl.pawel.extranet.model.User;
import pl.pawel.extranet.service.RoleService;
import pl.pawel.extranet.service.UserService;
import pl.pawel.main.MailMail;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/extranet-servlet.xml" })
public class ExtranetTest {

	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private MailMail mail;
	@Autowired
	private ShaPasswordEncoder passwordEncoder;
	// @Autowired
	// private FooService fooService;

	private static final Logger log = LoggerFactory
			.getLogger(ExtranetTest.class);

	User test, user1;
	Role role;
	Date date;
	SimpleDateFormat sdf;
	String encodedPasswd, dateInString, passwd;

	@Before
	public void init() throws ParseException {

		role = roleService.getRoleById(2);

		test = new User();
		test.setFirstName("testowy");
		test.setLastName("testowy");
		test.setEmail("test@test.pl");
		passwd = "test";
		passwordEncoder.setIterations(1000);
		encodedPasswd = passwordEncoder.encodePassword(passwd, test.getEmail());

		test.setPassword(encodedPasswd);
		sdf = new SimpleDateFormat("dd-MM-yyyy");
		dateInString = "31-08-1982";
		date = sdf.parse(dateInString);
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());

		log.info("MY DATE: " + sqlDate);

		test.setDateOfBirth(sqlDate);
		test.setRole(role);
		// System.out.println(fooService.findOne(3));

		// fooService.count(1);

		// fooService.create(test);
		userService.create(test);

		user1 = userService.findOne(2);
		// user1 = fooService.findOne(2);
		user1.setPassword(passwordEncoder.encodePassword("12345678",
				user1.getEmail()));
		userService.updateUser(user1);
		// fooService.update(user1);

		log.info("SIZE ALL: " + userService.findAll().size() / 5);

	}

	@Test
	public void test() {

		Assert.assertEquals("Hasła nie są poprawne", user1.getPassword(),
				passwordEncoder.encodePassword("12345678", user1.getEmail()));

		// sendEmail();
	}

	public void sendEmail() {
		mail.sendMail("paw.koz@gmail.com", "pk_82@wp.pl", "Konto użytkownika: "
				+ user1.getEmail() + " zostało utworzone",
				"Testing only - sender: "
						+ "Paweł\n\nHello Spring Email Sender\nUżytkownik: "
						+ user1.getEmail() + "\nHasło: " + passwd);
	}

	@After
	public void remove() {
		// fooService.deleteById(new Long(3));
	}
}
