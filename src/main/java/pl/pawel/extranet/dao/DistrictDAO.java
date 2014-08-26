package pl.pawel.extranet.dao;

import pl.pawel.extranet.abstracts.GenericHibernateDAO;
import pl.pawel.extranet.model.District;

public class DistrictDAO extends GenericHibernateDAO<District> implements
		IDistrictDAO {

	public DistrictDAO(Class<District> entityClass) {
		super(entityClass);
	}
}
