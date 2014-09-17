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
import pl.pawel.extranet.model.GetFromDB;
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
	public List<GetFromDB> getStatistics() {
		Query query = getCurrentSession()
				.createSQLQuery(
						"select c.name as club, sum(win) as ile from statistic s inner join club c "
						+ "on s.club_id = c.id group by c.name order by 2 desc")
				.addScalar("club")
				.addScalar("ile", IntegerType.INSTANCE)
				.setResultTransformer(Transformers.aliasToBean(GetFromDB.class));

		return query.list();
	}

}
