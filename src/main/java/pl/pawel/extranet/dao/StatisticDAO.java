package pl.pawel.extranet.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.hibernate.type.IntegerType;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import pl.pawel.extranet.abstracts.GenericHibernateDAO;
import pl.pawel.extranet.model.Game;
import pl.pawel.extranet.model.TableGames;
import pl.pawel.extranet.model.Statistic;

@Repository
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class StatisticDAO extends GenericHibernateDAO<Statistic> implements
		IStatisticDAO {

	public StatisticDAO(Class<Statistic> entityClass) {
		super(entityClass);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Statistic> findByGame(Game game) {
		Query query = getCurrentSession().createQuery(
				"from Statistic where game_id = :game_id");
		query.setLong("game_id", game.getId());
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TableGames> getStatistics() {
		Query query = getCurrentSession()
				.createSQLQuery(
						"select c.name as club, sum(win+draw+lose) as games, sum(win) as wins, sum(draw) as draws, sum(lose) as loses, sum(goalsscored) as goalsScored, "
						+ "sum(goalsagainst) as goalsAgainst, sum(win)*3+sum(draw)*1 as points from statistic s inner join club c on s.club_id = c.id group by c.name "
						+ "order by 8 desc, 3 desc, 6 desc")
				.addScalar("club")
				.addScalar("games", IntegerType.INSTANCE)
				.addScalar("wins", IntegerType.INSTANCE)
				.addScalar("draws", IntegerType.INSTANCE)
				.addScalar("loses", IntegerType.INSTANCE)
				.addScalar("goalsScored", IntegerType.INSTANCE)
				.addScalar("goalsAgainst", IntegerType.INSTANCE)
				.addScalar("points", IntegerType.INSTANCE)
				.setResultTransformer(Transformers.aliasToBean(TableGames.class));

		return query.list();
	}

}
