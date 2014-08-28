package pl.pawel.extranet;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.pawel.extranet.model.Club;
import pl.pawel.extranet.model.Game;
import pl.pawel.extranet.model.League;
import pl.pawel.extranet.model.Queue;
import pl.pawel.extranet.service.IGameService;
import pl.pawel.extranet.service.ILeagueService;

@Controller
@RequestMapping(value = "/game")
public class GameController {

	private static final Logger log = LoggerFactory
			.getLogger(GameController.class);

	@Autowired
	private IGameService gameService;

	@Autowired
	private ILeagueService leagueService;

	Game game = null;
	List<Game> games = null;
	List<Club> clubs = null;
	Queue queue = null;

	@RequestMapping(value = "/league/{leagueId}")
	public String list(@PathVariable("leagueId") long leagueId, ModelMap map) {
		// games = gameService.findAll();
		// for (Game g : games) {
		// clubs = g.getClub();
		// queue = g.getQueue();
		// if (queue != null)
		// log.info("Games: " + clubs + " queue: " + queue.getId());
		// }

		map.put("gameList", gameService.findByLeague(leagueId));

		return "game/list";
	}

	@RequestMapping(value = "/new")
	public String newLeague(ModelMap map) {

		map.put("league", new League());
		// map.put("leagueList", leagueService.findAll());

		return "league/new";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addGame(@ModelAttribute("game") @Valid Game game,
			BindingResult result, ModelMap map) {

		if (result.hasErrors()) {

			return "game/new";
		}

		gameService.create(game);

		return "redirect:/game";

	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addGame() {
		return "redirect:/game";
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
}
