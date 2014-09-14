package pl.pawel.extranet;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.pawel.extranet.model.District;
import pl.pawel.extranet.service.IDistrictService;

@Controller
@RequestMapping("/district")
public class DistrictController {

	// private static final Logger log = LoggerFactory
	// .getLogger(DistrictController.class);

	@Autowired
	private IDistrictService districtService;

	District district = null;

	@RequestMapping(value = "")
	public String list(ModelMap map) {
		map.put("districtList", districtService.findAll());

		return "district/list";
	}

	@RequestMapping(value = "/new")
	public String newDistrict(ModelMap map) {

		map.put("district", new District());
		map.put("districtList", districtService.findAll());

		return "district/new";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addDistrict(
			@ModelAttribute("district") @Valid District district,
			BindingResult result, ModelMap map, HttpServletRequest request) {

		if (result.hasErrors()) {

			return "district/new";
		}

		districtService.create(district);

		return "redirect:/district";

	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addDistrict() {
		return "redirect:/district";
	}

	@RequestMapping(value = "/delete/{districtId}", method = RequestMethod.GET)
	public String deleteDistrict(@PathVariable("districtId") long districtId) {

		districtService.deleteById(districtId);

		return "redirect:/district";
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "/edit/{districtId}", method = RequestMethod.GET)
	public String editDistrict(@PathVariable("districtId") long districtId,
			ModelMap map) {

		district = districtService.findOne(districtId);
		map.put("district", district);

		return "district/edit";
	}

	@RequestMapping(value = "/updateDistrict", method = RequestMethod.POST)
	public String updateDistrict(@Valid District district,
			BindingResult result, ModelMap map) {
		if (result.hasErrors()) {

			return "district/edit";
		}

		districtService.update(district);

		return "redirect:/";
	}

	@RequestMapping(value = "/updateDistrict", method = RequestMethod.GET)
	public String updateDistrict() {
		return "redirect:/district";
	}
}
