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
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.pawel.extranet.model.Club;
import pl.pawel.extranet.model.Game;
import pl.pawel.extranet.model.Queue;
import pl.pawel.extranet.model.Statistic;
import pl.pawel.extranet.model.User;
import pl.pawel.extranet.service.IClubService;
import pl.pawel.extranet.service.IGameService;
import pl.pawel.extranet.service.ILeagueService;
import pl.pawel.extranet.service.IQueueService;
import pl.pawel.extranet.service.IStatisticService;
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

	@Autowired
	private IStatisticService statisticService;

	Game game = null;
	List<Game> games = null;
	List<Club> clubs = null;
	Queue queue = null;
	int team1, team2;
	User user = null;
	List<User> playerOne = null, playerTwo = null, referees = null;

	@RequestMapping(value = "/league/{leagueId}")
	public String list(@PathVariable("leagueId") long leagueId, ModelMap map) {

		List<Game> gameList = gameService.findByLeague(leagueId);

		map.put("gameList", gameList);

		List<Statistic> statList = new ArrayList<Statistic>();
		for (Game g : gameList) {
			// statList = statisticService.findByGame(g);
			// log.info("Statystyka: " + statList.get(0).getGoalsScored());
		}
		// map.put("statList", statList.get(0));

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

		repeatError("dateOfGame", result, request);

		if (result.hasErrors()) {

			map.put("isNull", true);
			map.put("dateIsNull", "Należy podać datę rozgrywki");

			map.put("clubList", clubService.findAll());
			map.put("club1", clubService.findOne(team1));
			map.put("club2", clubService.findOne(team2));
			map.put("queueList", queueService.findAll());

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

		if (statisticService.findByGame(game).size() != 0) {
			log.info("Statystyka: "
					+ statisticService.findByGame(game).get(0).getGoalsScored()
					+ " "
					+ statisticService.findByGame(game).get(1).getGoalsScored());
			map.put("scoreClub1", statisticService.findByGame(game).get(0)
					.getGoalsScored());
			map.put("scoreClub2", statisticService.findByGame(game).get(1)
					.getGoalsScored());
			map.put("isStatistics", true);
		} else {
			map.put("isStatistics", false);
		}
		log.info("Club1: " + game.getClub().get(0).getId() + " " + ", club2: "
				+ game.getClub().get(1).getId());

		map.put("game", game);
		map.put("playersOneList", gameService.findPlayersOneByGame(gameId));
		map.put("playersTwoList", gameService.findPlayersTwoByGame(gameId));
		map.put("refereeList", gameService.findRefereesByGame(gameId));

		return "game/info";
	}

	@RequestMapping(value = "/addScore/{gameId}")
	public String gameAddScore(@PathVariable("gameId") long gameId, ModelMap map) {
		game = gameService.findOne(gameId);
		map.put("game", game);
		map.put("playersOneList", gameService.findPlayersOneByGame(gameId));
		map.put("playersTwoList", gameService.findPlayersTwoByGame(gameId));
		map.put("refereeList", gameService.findRefereesByGame(gameId));

		return "game/addScore";
	}

	@RequestMapping(value = "/addScore/save", method = RequestMethod.POST)
	public String addGame(ModelMap map, HttpServletRequest request) {

		int scoreClub1 = Integer.parseInt(request.getParameter("scoreClub1"));
		int scoreClub2 = Integer.parseInt(request.getParameter("scoreClub2"));

		Statistic stat1, stat2;

		stat1 = new Statistic();
		stat1.setGame(game);
		stat1.setClub(clubService.findOne(game.getClub().get(0).getId()));
		stat1.setGoalsScored(scoreClub1);
		stat1.setGoalsAgainst(scoreClub2);

		stat2 = new Statistic();
		stat2.setGame(game);
		stat2.setClub(clubService.findOne(game.getClub().get(1).getId()));
		stat2.setGoalsScored(scoreClub2);
		stat2.setGoalsAgainst(scoreClub1);

		if (scoreClub1 > scoreClub2) {
			stat1.setWin(1);
			stat2.setLose(1);
		} else if (scoreClub1 < scoreClub2) {
			stat1.setLose(1);
			stat2.setWin(1);
		} else {
			stat1.setDraw(1);
			stat2.setDraw(1);
		}

		statisticService.create(stat1);
		statisticService.create(stat2);

		return "redirect:/";
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		sdf.setLenient(true);
		binder.registerCustomEditor(Date.class, new CustomSQLDateEditor(sdf,
				false, 10));
	}

	private void repeatError(String primaryField, BindingResult result,
			HttpServletRequest request) {
		String primField = request.getParameter(primaryField);
		ObjectError error = new ObjectError(primaryField, null);
		if (primField.equals(""))
			result.addError(error);
	}
}
