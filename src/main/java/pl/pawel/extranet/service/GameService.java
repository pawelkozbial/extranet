package pl.pawel.extranet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.pawel.extranet.dao.IGameDAO;
import pl.pawel.extranet.model.Game;

@Service
@Transactional
public class GameService implements IGameService {

	@Autowired
	private IGameDAO gameDAO;

	@Override
	public Game findOne(long id) {
		return gameDAO.findOne(id);
	}

	@Override
	public List<Game> findAll() {
		return gameDAO.findAll();
	}

	@Override
	public void create(Game entity) {
		gameDAO.create(entity);
	}

	@Override
	public void update(Game entity) {
		gameDAO.update(entity);
	}

	@Override
	public void delete(Game entity) {
		gameDAO.delete(entity);
	}

	@Override
	public void deleteById(long entityId) {
		Game game = findOne(entityId);
		delete(game);
	}

}
