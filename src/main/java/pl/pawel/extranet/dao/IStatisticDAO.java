package pl.pawel.extranet.dao;

import java.util.List;

import pl.pawel.extranet.abstracts.IGenericDAO;
import pl.pawel.extranet.model.Game;
import pl.pawel.extranet.model.GetFromDB;
import pl.pawel.extranet.model.Statistic;

public interface IStatisticDAO extends IGenericDAO<Statistic> {

	public List<Statistic> findByGame(Game game);

	public List<GetFromDB> getStatistics();
}
