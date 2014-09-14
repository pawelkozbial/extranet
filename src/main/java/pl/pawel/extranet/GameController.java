package pl.pawel.extranet;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.pawel.extranet.model.Club;
import pl.pawel.extranet.model.Game;
import pl.pawel.extranet.model.Queue;
import pl.pawel.extranet.model.User;
import pl.pawel.extranet.service.IClubService;
import pl.pawel.extranet.service.IGameService;
import pl.pawel.extranet.service.ILeagueService;
import pl.pawel.extranet.service.IQueueService;
import pl.pawel.extranet.service.UserService;
import pl.pawel.extranet.validator.CustomSQLDateEditor;

@Controller
@RequestMapping(value = "/game")
public class GameController {

	private static final Logger log = LoggerFactory
			.getLogger(GameController.class);

	@Autowired
	private IGameService gameService;

	@Autowired
	private ILeagueService leagueService;

	@Autowired
	private IClubService clubService;

	@Autowired
	private UserService userService;

	@Autowired
	private IQueueService queueService;

	Game game = null;
	List<Game> games = null;
	List<Club> clubs = null;
	Queue queue = null;
	int team1, team2;
	User user = null;
	List<User> playerOne = null, playerTwo = null, referees = null;

	@RequestMapping(value = "/league/{leagueId}")
	public String list(@PathVariable("leagueId") long leagueId, ModelMap map) {

		map.put("gameList", gameService.findByLeague(leagueId));

		return "game/list";
	}

	@RequestMapping(value = "/new")
	public String newGame(ModelMap map, HttpServletRequest request) {

		map.put("game", new Game());
		map.put("clubList", clubService.findAll());
		map.put("club1", clubService.findOne(team1));
		map.put("club2", clubService.findOne(team2));
		map.put("queueList", queueService.findAll());

		return "game/new";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addGame(@ModelAttribute("game") @Valid Game game,
			BindingResult result, ModelMap map, HttpServletRequest request) {

		int queueId = Integer.parseInt(request.getParameter("queueId"));

		if (result.hasErrors()) {

			return "game/new";
		}

		map.put("club1", clubService.findOne(team1));
		map.put("club2", clubService.findOne(team2));
		map.put("referees", referees);
		map.put("queueList", queueService.findAll());

		clubs = new ArrayList<Club>();
		clubs.add(clubService.findOne(team1));
		clubs.add(clubService.findOne(team2));

		queue = queueService.findOne(queueId);

		game.setClub(clubs);
		game.setPlayerClubOne(playerOne);
		game.setPlayerClubTwo(playerTwo);
		game.setReferee(referees);
		game.setQueue(queue);
		gameService.create(game);

		return "redirect:/";

	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addGame() {
		return "redirect:/game";
	}

	@RequestMapping(value = "/addPlayers/1", method = RequestMethod.GET)
	public String addPlayers1(ModelMap map, HttpServletRequest request) {

		map.put("clubList", clubService.findAll());
		map.put("userList", userService.findAll());

		return "game/addPlayers1";
	}

	@RequestMapping(value = "/createClubOne")
	public String createClubOne(ModelMap map, HttpServletRequest request) {
		team1 = Integer.parseInt(request.getParameter("team1"));

		String[] players = request.getParameterValues("players");
		playerOne = new ArrayList<User>();

		for (String d : players) {
			user = userService.findOne(Long.parseLong(d));
			playerOne.add(user);
		}

		map.put("club1", clubService.findOne(team1));
		map.put("club2", clubService.findOne(team2));
		map.put("queueList", queueService.findAll());

		return "game/new";
	}

	@RequestMapping(value = "/addPlayers/2", method = RequestMethod.GET)
	public String addPlayers2(ModelMap map) {

		map.put("clubList", clubService.findAll());
		map.put("userList", userService.findAll());

		return "game/addPlayers2";
	}

	@RequestMapping(value = "/createClubTwo")
	public String createClubTwo(ModelMap map, HttpServletRequest request) {
		team2 = Integer.parseInt(request.getParameter("team2"));

		String[] players = request.getParameterValues("players");
		playerTwo = new ArrayList<User>();

		for (String d : players) {
			user = userService.findOne(Long.parseLong(d));
			playerTwo.add(user);
		}

		map.put("club1", clubService.findOne(team1));
		map.put("club2", clubService.findOne(team2));
		map.put("queueList", queueService.findAll());

		return "game/new";
	}

	@RequestMapping(value = "/addReferees", method = RequestMethod.GET)
	public String addReferees(ModelMap map) {

		map.put("userList", userService.findAll());

		return "game/addReferees";
	}

	@RequestMapping(value = "/createReferees")
	public String createReferees(ModelMap map, HttpServletRequest request) {

		String[] ref = request.getParameterValues("referees");
		referees = new ArrayList<User>();

		for (String d : ref) {
			user = userService.findOne(Long.parseLong(d));
			referees.add(user);
		}

		log.info("REFERES" + referees);

		map.put("club1", clubService.findOne(team1));
		map.put("club2", clubService.findOne(team2));
		map.put("referees", referees);
		map.put("queueList", queueService.findAll());

		return "game/new";
	}

	@RequestMapping(value = "/info/{gameId}")
	public String gameInfo(@PathVariable("gameId") long gameId, ModelMap map) {

		game = gameService.findOne(gameId);

		map.put("game", game);
		map.put("playersOneList", gameService.findPlayersOneByGame(gameId));
		map.put("playersTwoList", gameService.findPlayersTwoByGame(gameId));
		map.put("refereeList", gameService.findRefereesByGame(gameId));

		return "game/info";
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		sdf.setLenient(true);
		binder.registerCustomEditor(Date.class, new CustomSQLDateEditor(sdf,
				false, 10));
	}
}
