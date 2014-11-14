package pl.pawel.extranet;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.pawel.extranet.model.TableGames;
import pl.pawel.extranet.service.IStatisticService;

@Controller
@RequestMapping(value = "/statistics")
public class StatisticsController {

	private static final Logger log = LoggerFactory
			.getLogger(StatisticsController.class);

	@Autowired
	private IStatisticService statisticService;

	@RequestMapping(value = "")
	public String list(ModelMap map) {

		List<TableGames> statisticList = statisticService.getStatistics();

		map.put("statisticList", statisticList);

		return "statistics/test";
	}
}
