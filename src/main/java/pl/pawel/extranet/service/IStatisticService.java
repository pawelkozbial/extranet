package pl.pawel.extranet.service;

import java.util.List;

import pl.pawel.extranet.abstracts.IGenericService;
import pl.pawel.extranet.model.Game;
import pl.pawel.extranet.model.TableGames;
import pl.pawel.extranet.model.Statistic;

public interface IStatisticService extends IGenericService<Statistic> {

	public List<Statistic> findByGame(Game game);

	public List<TableGames> getStatistics();
}
