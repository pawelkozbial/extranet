package pl.pawel.extranet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.pawel.extranet.dao.IStatisticDAO;
import pl.pawel.extranet.model.Game;
import pl.pawel.extranet.model.GetFromDB;
import pl.pawel.extranet.model.Statistic;

@Service
@Transactional
public class StatisticService implements IStatisticService {

	@Autowired
	private IStatisticDAO statisticDAO;

	@Override
	public Statistic findOne(long id) {
		return statisticDAO.findOne(id);
	}

	@Override
	public List<Statistic> findAll() {
		return statisticDAO.findAll();
	}

	@Override
	public void create(Statistic entity) {
		statisticDAO.create(entity);
	}

	@Override
	public void update(Statistic entity) {
		statisticDAO.update(entity);
	}

	@Override
	public void delete(Statistic entity) {
		statisticDAO.delete(entity);
	}

	@Override
	public void deleteById(long entityId) {
		Statistic stat = findOne(entityId);
		delete(stat);
	}

	@Override
	public List<Statistic> findByGame(Game game) {
		return statisticDAO.findByGame(game);
	}

	@Override
	public List<GetFromDB> getStatistics() {
		return statisticDAO.getStatistics();
	}

}
