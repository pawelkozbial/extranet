package pl.pawel.extranet.dao;

import java.util.List;

import pl.pawel.extranet.abstracts.IGenericDAO;
import pl.pawel.extranet.model.Game;
import pl.pawel.extranet.model.User;

public interface IGameDAO extends IGenericDAO<Game> {

	public List<Game> findByLeague(long leagueId);

	public List<User> findPlayersOneByGame(long gameId);

	public List<User> findPlayersTwoByGame(long gameId);
	
	public List<User> findRefereesByGame(long gameId);
}
