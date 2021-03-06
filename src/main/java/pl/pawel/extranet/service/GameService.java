package pl.pawel.extranet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.pawel.extranet.dao.IGameDAO;
import pl.pawel.extranet.model.Game;
import pl.pawel.extranet.model.User;

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

	@Override
	public List<Game> findByLeague(long leagueId) {
		return gameDAO.findByLeague(leagueId);
	}

	@Override
	public List<User> findPlayersOneByGame(long gameId) {
		return gameDAO.findPlayersOneByGame(gameId);
	}

	@Override
	public List<User> findPlayersTwoByGame(long gameId) {
		return gameDAO.findPlayersTwoByGame(gameId);
	}

	@Override
	public List<User> findRefereesByGame(long gameId) {
		return gameDAO.findRefereesByGame(gameId);
	}
}
