package pl.pawel.extranet.dao;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import pl.pawel.extranet.abstracts.GenericHibernateDAO;
import pl.pawel.extranet.model.Statistic;

@Repository
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class StatisticDAO extends GenericHibernateDAO<Statistic> implements
		IStatisticDAO {

	public StatisticDAO(Class<Statistic> entityClass) {
		super(entityClass);
	}
}
