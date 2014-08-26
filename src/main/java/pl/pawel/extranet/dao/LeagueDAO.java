package pl.pawel.extranet.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import pl.pawel.extranet.abstracts.GenericHibernateDAO;
import pl.pawel.extranet.model.League;

@Repository
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class LeagueDAO extends GenericHibernateDAO<League> implements
		ILeagueDAO {

	public LeagueDAO(Class<League> entityClass) {
		super(entityClass);
	}

	@Override
	public void deleteById(long entityId) {
		Query query = getCurrentSession().createSQLQuery(
				"delete from league_district where league_id = ?");
		query.setLong(0, entityId);
		query.executeUpdate();
		super.deleteById(entityId);
	}

	@SuppressWarnings("unchecked")
	public List<Long> findDistricts(League league) {
		Query query = getCurrentSession().createSQLQuery(
				"select district_id from league_district where league_id = ?");
		query.setLong(0, league.getId());
		return query.list();
	}
}
