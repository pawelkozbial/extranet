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

import pl.pawel.extranet.abstracts.IGenericService;
import pl.pawel.extranet.model.Club;
import pl.pawel.extranet.model.District;
import pl.pawel.extranet.model.League;
import pl.pawel.extranet.model.Role;
import pl.pawel.extranet.model.User;
import pl.pawel.extranet.service.IClubService;
import pl.pawel.extranet.service.IDistrictService;
import pl.pawel.extranet.service.ILeagueService;
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

	@Autowired
	private IDistrictService districtService;

	@Autowired
	private ILeagueService leagueService;

	@Autowired
	private IClubService clubService;

	@Autowired
	private IGenericService<User> fooService;

	private static final Logger log = LoggerFactory
			.getLogger(ExtranetTest.class);

	User test, user1;
	Role role;
	Date date;
	SimpleDateFormat sdf;
	String encodedPasswd, dateInString, passwd;
	District district;
	League league;
	Club club;

	@Before
	public void init() {

		log.info("Club: " + clubService.findAll());

		district = districtService.findOne(3);

		club = new Club();
		club.setName("Jura Kotowice");
		club.setDistrict(district);
		clubService.create(club);

		log.info("Club: " + clubService.findAll());
	}

	@Test
	public void testPassword() {

		user1 = userService.findOne(2);
		user1.setPassword(passwordEncoder.encodePassword("12345678",
				user1.getEmail()));
		userService.updateUser(user1);

		Assert.assertEquals("Hasła nie są poprawne", user1.getPassword(),
				passwordEncoder.encodePassword("12345678", user1.getEmail()));

		// sendEmail();
	}

	public void testCreateUser() {
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
		try {
			date = sdf.parse(dateInString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());

		test.setDateOfBirth(sqlDate);
		test.setRole(role);
		userService.create(test);
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
		// districtService.delete(district);
	}
}
