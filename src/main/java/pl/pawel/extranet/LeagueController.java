package pl.pawel.extranet;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
import pl.pawel.extranet.service.ILeagueService;

@Controller
@RequestMapping(value = "/league")
public class LeagueController {

	private static final Logger log = LoggerFactory
			.getLogger(DistrictController.class);

	@Autowired
	private ILeagueService leagueService;
	@Autowired
	private IGenericService<District> districtService;

	private League league = null;
	private District district = null;

	@RequestMapping(value = "")
	public String list(ModelMap map) {
		map.put("leagueList", leagueService.findAll());

		return "league/list";
	}

	@RequestMapping(value = "/new")
	public String newLeague(ModelMap map) {

		map.put("league", new League());
		//map.put("leagueList", leagueService.findAll());

		return "league/new";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addLeague(@ModelAttribute("league") @Valid League league,
			BindingResult result, ModelMap map) {

		if (result.hasErrors()) {

			return "league/new";
		}

		leagueService.create(league);

		return "redirect:/league";

	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addLeague() {
		return "redirect:/league";
	}

	@RequestMapping(value = "/delete/{leagueId}", method = RequestMethod.GET)
	public String deleteleague(@PathVariable("leagueId") long leagueId) {

		leagueService.deleteById(leagueId);

		return "redirect:/league";
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "/edit/{leagueId}", method = RequestMethod.GET)
	public String editLeague(@PathVariable("leagueId") long leagueId,
			ModelMap map) {

		league = leagueService.findOne(leagueId);
		map.put("league", league);

		return "league/edit";
	}

	@RequestMapping(value = "/updateLeague", method = RequestMethod.POST)
	public String updateLeague(@Valid League league, BindingResult result,
			ModelMap map, HttpServletRequest request) {
		if (result.hasErrors()) {

			return "league/edit";
		}

		leagueService.update(league);

		return "redirect:/league";
	}

	@RequestMapping(value = "/updateLeague", method = RequestMethod.GET)
	public String updateDistrict() {
		return "redirect:/league";
	}

	@RequestMapping(value = "/addDistrictToLeague/{leagueId}")
	public String addDistrictToLeague(@PathVariable("leagueId") long leagueId,
			ModelMap map) {

		league = leagueService.findOne(leagueId);
		log.info("Districts: " + leagueService.findDistricts(league));

		map.put("league", league.getName());
		map.put("leagueList", leagueService.findAll());
		map.put("districtList", districtService.findAll());
		map.put("addedDistrictsList", leagueService.findDistricts(league));

		return "league/addDistrictToLeague";
	}

	@RequestMapping(value = "/updateDistricts")
	public String updateDistricts(HttpServletRequest request) {

		String[] districts = request.getParameterValues("districts");
		List<District> list = new ArrayList<District>();

		for (String d : districts) {
			district = districtService.findOne(Long.parseLong(d));
			list.add(district);
		}

		log.info("SELECTED: " + list);

		league.setDistrict(list);
		leagueService.update(league);
		return "redirect:/league";
	}
}
