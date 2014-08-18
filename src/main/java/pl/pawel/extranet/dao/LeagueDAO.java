package pl.pawel.extranet.dao;

import org.hibernate.Query;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import pl.pawel.extranet.abstracts.GenericHibernateDAO;
import pl.pawel.extranet.model.League;

@Repository
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class LeagueDAO extends GenericHibernateDAO<League> {

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
}
