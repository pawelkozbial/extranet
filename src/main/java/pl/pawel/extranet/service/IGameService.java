package pl.pawel.extranet.service;

import java.util.List;

import pl.pawel.extranet.abstracts.IGenericService;
import pl.pawel.extranet.model.Game;
import pl.pawel.extranet.model.User;

public interface IGameService extends IGenericService<Game> {

	public List<Game> findByLeague(long leagueId);

	public List<User> findPlayersOneByGame(long gameId);

	public List<User> findPlayersTwoByGame(long gameId);
	
	public List<User> findRefereesByGame(long gameId);
}
