package pl.pawel.extranet;

import javax.servlet.http.HttpServletRequest;
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

import pl.pawel.extranet.abstracts.IGenericService;
import pl.pawel.extranet.model.District;
import pl.pawel.extranet.model.League;

@Controller
@RequestMapping(value = "/league")
public class LeagueController {

	private static final Logger log = LoggerFactory
			.getLogger(DistrictController.class);

	@Autowired
	private IGenericService<League> leagueService;

	League league = null;

	@RequestMapping(value = "")
	public String list(ModelMap map) {
		map.put("leagueList", leagueService.findAll());

		return "league/list";
	}

	@RequestMapping(value = "/new")
	public String listLeagues(ModelMap map) {

		map.put("league", new League());
		map.put("leagueList", leagueService.findAll());

		return "league/new";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addLeague(@ModelAttribute("district") @Valid League league,
			BindingResult result, ModelMap map, HttpServletRequest request) {

		if (result.hasErrors()) {

			return "district/new";
		}

		leagueService.create(league);

		return "redirect:/league";

	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addLeague() {
		return "redirect:/league";
	}

	@RequestMapping(value = "/delete/{leagueId}", method = RequestMethod.GET)
	public String deleteDistrict(@PathVariable("leagueId") long leagueId) {

		leagueService.deleteById(leagueId);

		return "redirect:/league";
	}
}
