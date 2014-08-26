package pl.pawel.extranet.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
import pl.pawel.extranet.model.District;
import pl.pawel.extranet.model.League;
import pl.pawel.extranet.model.Role;
import pl.pawel.extranet.model.User;
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

	@Before
	public void init() {

		log.info("LEAGUE: " + leagueService.findAll());
		log.info("DISTRICT: " + districtService.findAll());

		log.info(roleService.getRoleById(1).toString());
		district = new District();

		// district.setLeague(league);
		district.setName("Wschodnio-północna");
		district.setDescription("Testowy opis grupy");
		districtService.create(district);

		league = leagueService.findOne(3);
		// league.setName("IV liga");
		// leagueService.create(league);

		List<District> list = new ArrayList<District>();
		list.add(districtService.findOne(2));
		list.add(districtService.findOne(5));
		list.add(districtService.findOne(9));

		List<Long> listD = leagueService.findDistricts(league);

		log.info("DISTRICTS ID: " + listD);

		league.setDistrict(list);
		log.info("DISTRICTS: " + league.getName());
		leagueService.update(league);
		// district.setLeague(league);
		// districtService.update(district);
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
