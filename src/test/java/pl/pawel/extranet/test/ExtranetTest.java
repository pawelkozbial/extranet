package pl.pawel.extranet.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

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
import pl.pawel.extranet.model.Game;
import pl.pawel.extranet.model.League;
import pl.pawel.extranet.model.Queue;
import pl.pawel.extranet.model.Role;
import pl.pawel.extranet.model.Round;
import pl.pawel.extranet.model.User;
import pl.pawel.extranet.service.IClubService;
import pl.pawel.extranet.service.IDistrictService;
import pl.pawel.extranet.service.IGameService;
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
	private IGameService gameService;

	@Autowired
	private IGenericService<Round> roundService;

	@Autowired
	private IGenericService<Queue> queueService;

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
	Game game;
	Round round;
	Queue queue;

	@Before
	public void init() {

		log.info("Before\n");
		log.info("GAME by league ID: " + gameService.findByLeague(1));
		log.info("ROUND: " + roundService.findAll());
		log.info("Queue: " + queueService.findAll());

		round = new Round();
		round.setName("Runda wiosenna 2015");
		roundService.create(round);

		queue = new Queue();
		// queue.setNumber(7);
		queue.setRound(round);
		queueService.create(queue);

		List<User> playerOne = new ArrayList<User>();
		playerOne.add(userService.findOne(5));
		playerOne.add(userService.findOne(8));

		List<User> playerTwo = new ArrayList<User>();
		playerTwo.add(userService.findOne(4));
		playerTwo.add(userService.findOne(8));

		List<User> referees = new ArrayList<User>();
		referees.add(userService.findOne(2));
		referees.add(userService.findOne(3));

		List<Club> clubs = new ArrayList<Club>();
		clubs.add(0, clubService.findOne(3));
		clubs.add(1, clubService.findOne(1));

		game = new Game();
		game.setQueue(queue);
		game.setPlayerClubOne(playerOne);
		game.setPlayerClubTwo(playerTwo);
		game.setReferee(referees);
		game.setClub(clubs);
		sdf = new SimpleDateFormat("yyyy-MM-dd");
		dateInString = "2014-11-01";
		try {
			date = sdf.parse(dateInString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		game.setDateOfGame(sqlDate);

		gameService.create(game);

		List<Game> games = gameService.findByLeague(1);
		// for (Game g : games) {
		// clubs = g.getClub();
		// queue = g.getQueue();
		// if (queue != null)
		// log.info("Games: " + g.getDateOfGame() + " "
		// + clubs.get(0).getName() + " - "
		// + clubs.get(1).getName() + " queue: " + queue.getId());
		// }

		log.info("After:\n");
		log.info("GAME by league ID: " + gameService.findByLeague(1));

		log.error("ONE: " + gameService.findPlayersOneByGame(1));
		log.error("TWO: " + gameService.findPlayersTwoByGame(1));
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

	@SuppressWarnings("unused")
	private void createUserTable() {
		String[] imiona = { "Piotr", "Paweł", "Marcin", "Henryk", "Marek",
				"Kamil", "Grzegorz", "Dariusz", "Zbigniew", "Krzysztof",
				"Ireneusz", "Andrzej", "Jacek", "Artur", "Karol" };
		String[] nazwiska = { "Nowakowski", "Kowalski", "Nowak", "Czyżyk",
				"Błaszczyk", "Sowa", "Czarny", "Szulc", "Bąkowski", "Bąk",
				"Biały", "Nowak", "Kania", "Krzywda", "Góral", "Lolek",
				"Janik", "Janikowski" };
		Random rand = new Random();
		int randIm, randNaz, randMonth, randDay, randDate;
		for (int i = 0; i < 200; i++) {
			randIm = rand.nextInt(imiona.length);
			randNaz = rand.nextInt(nazwiska.length);
			randMonth = rand.nextInt(12) + 1;
			randDay = rand.nextInt(30) + 1;
			randDate = rand.nextInt(18);
			// log.info("WYLOSOWANO: " + randIm + " " + randNaz + " - 'user"+
			// (18 + i) + "@user.pl'");
			System.out
					.println("INSERT INTO users (id, firstname, lastname, email, password, dateofbirth, enabled) VALUES "
							+ "("
							+ (42 + i)
							+ ", '"
							+ imiona[randIm]
							+ "', '"
							+ nazwiska[randNaz]
							+ "', 'user"
							+ (38 + i)
							+ "@user.pl', '76d95e58766715225a65b9651769f9f409d77616d2f860cd32e55669f2a81d30', '19"
							+ (80 + randDate)
							+ "-"
							+ randMonth
							+ "-"
							+ randDay
							+ "', true)");
		}

		int role;
		for (int i = 14; i < 242; i++) {
			role = rand.nextInt(2) + 1;
			System.out
					.println("insert into user_roles (user_id, role_id) values ("
							+ i + ", " + role + ")");
		}
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
