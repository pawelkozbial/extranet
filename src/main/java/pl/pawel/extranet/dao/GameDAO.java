package pl.pawel.extranet.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.type.LongType;

import pl.pawel.extranet.abstracts.GenericHibernateDAO;
import pl.pawel.extranet.model.Game;
import pl.pawel.extranet.model.User;

public class GameDAO extends GenericHibernateDAO<Game> implements IGameDAO {

	public GameDAO(Class<Game> entityClass) {
		super(entityClass);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Game> findByLeague(long leagueId) {
		Query gameIdQeury = getCurrentSession()
				.createSQLQuery(
						"select distinct game_id from game_club where club_id in "
								+ "(select id from club where district_id in "
								+ "(select district_id from league_district where league_id = ?))")
				.addScalar("game_id", LongType.INSTANCE);

		gameIdQeury.setLong(0, leagueId);
		Query query = getCurrentSession().createQuery(
				"from Game where id in (:gameId)");
		query.setParameterList("gameId", gameIdQeury.list());
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findPlayersOneByGame(long gameId) {
		Query gameIdQuery = getCurrentSession().createSQLQuery(
				"select user_id from game_playerone where game_id = ?")
				.addScalar("user_id", LongType.INSTANCE);
		gameIdQuery.setLong(0, gameId);
		Query query = getCurrentSession().createQuery(
				"from User where id in (:userId)");
		query.setParameterList("userId", gameIdQuery.list());
		
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findPlayersTwoByGame(long gameId) {
		Query gameIdQuery = getCurrentSession().createSQLQuery(
				"select user_id from game_playertwo where game_id = ?")
				.addScalar("user_id", LongType.INSTANCE);
		gameIdQuery.setLong(0, gameId);
		Query query = getCurrentSession().createQuery(
				"from User where id in (:userId)");
		query.setParameterList("userId", gameIdQuery.list());

		return query.list();
	}

	@SuppressWarnings("unchecked")
	public List<User> findRefereesByGame(long gameId){
		Query gameIdQuery = getCurrentSession().createSQLQuery(
				"select user_id from game_referee where game_id = ?")
				.addScalar("user_id", LongType.INSTANCE);
		gameIdQuery.setLong(0, gameId);
		Query query = getCurrentSession().createQuery(
				"from User where id in (:userId)");
		query.setParameterList("userId", gameIdQuery.list());

		return query.list();
	}
}
