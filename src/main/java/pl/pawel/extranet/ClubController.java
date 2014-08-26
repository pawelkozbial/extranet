package pl.pawel.extranet;

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

import pl.pawel.extranet.model.Club;
import pl.pawel.extranet.model.District;
import pl.pawel.extranet.model.League;
import pl.pawel.extranet.service.IClubService;
import pl.pawel.extranet.service.IDistrictService;

@Controller
@RequestMapping(value = "/club")
public class ClubController {

	private static final Logger log = LoggerFactory
			.getLogger(ClubController.class);

	@Autowired
	private IClubService clubService;

	@Autowired
	private IDistrictService districtService;

	private Club club = null;
	private District district = null;

	@RequestMapping(value = "")
	public String list(ModelMap map) {

		map.put("clubList", clubService.findAll());
		map.put("districtList", districtService.findAll());

		return "club/list";
	}

	@RequestMapping(value = "/new")
	public String newClub(ModelMap map) {

		map.put("club", new Club());
		map.put("districtList", districtService.findAll());

		return "club/new";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addClub(@ModelAttribute("club") @Valid Club club,
			BindingResult result, ModelMap map, HttpServletRequest request) {

		long districtId = Long.parseLong(request.getParameter("districtId"));

		if (result.hasErrors()) {

			map.put("districtList", districtService.findAll());

			return "club/new";
		}

		club.setDistrict(districtService.findOne(districtId));
		clubService.create(club);

		return "redirect:/club";

	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addClub() {
		return "redirect:/club";
	}

	@RequestMapping(value = "/delete/{clubId}", method = RequestMethod.GET)
	public String deleteleague(@PathVariable("clubId") long clubId) {

		clubService.deleteById(clubId);

		return "redirect:/club";
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "/edit/{clubId}", method = RequestMethod.GET)
	public String editClub(@PathVariable("clubId") long clubId, ModelMap map) {

		club = clubService.findOne(clubId);
		district = club.getDistrict();

		map.put("districtId", district.getId());
		map.put("club", club);
		map.put("districtList", districtService.findAll());

		return "club/edit";
	}

	@RequestMapping(value = "/updateClub", method = RequestMethod.POST)
	public String updateClub(@Valid League league, BindingResult result,
			ModelMap map, HttpServletRequest request) {

		long districtId = Long.parseLong(request.getParameter("districtId"));

		if (result.hasErrors()) {
			map.put("districtList", districtService.findAll());

			return "club/edit";
		}

		club.setDistrict(districtService.findOne(districtId));
		clubService.update(club);

		return "redirect:/club";
	}

	@RequestMapping(value = "/updateClub", method = RequestMethod.GET)
	public String updateClub() {
		return "redirect:/club";
	}

	// @RequestMapping(value = "/addDistrictToLeague/{leagueId}")
	// public String addDistrictToLeague(@PathVariable("leagueId") long
	// leagueId,
	// ModelMap map) {
	//
	// league = leagueService.findOne(leagueId);
	// log.info("Districts: " + leagueService.findDistricts(league));
	//
	// map.put("league", league.getName());
	// map.put("leagueList", leagueService.findAll());
	// map.put("districtList", districtService.findAll());
	// map.put("addedDistrictsList", leagueService.findDistricts(league));
	//
	// return "league/addDistrictToLeague";
	// }
	//
	// @RequestMapping(value = "/updateDistricts")
	// public String updateDistricts(HttpServletRequest request) {
	//
	// String[] districts = request.getParameterValues("districts");
	// List<District> list = new ArrayList<District>();
	//
	// for (String d : districts) {
	// district = districtService.findOne(Long.parseLong(d));
	// list.add(district);
	// }
	//
	// log.info("SELECTED: " + list);
	//
	// league.setDistrict(list);
	// leagueService.update(league);
	// return "redirect:/league";
	// }
}
