package pl.pawel.extranet.dao;

import pl.pawel.extranet.abstracts.GenericHibernateDAO;
import pl.pawel.extranet.model.Club;

public class ClubDAO extends GenericHibernateDAO<Club> implements IClubDAO {

	public ClubDAO(Class<Club> entityClass) {
		super(entityClass);
	}
}
