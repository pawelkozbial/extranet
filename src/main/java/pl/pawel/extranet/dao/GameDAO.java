package pl.pawel.extranet.dao;

import pl.pawel.extranet.abstracts.GenericHibernateDAO;
import pl.pawel.extranet.model.Game;

public class GameDAO extends GenericHibernateDAO<Game> implements IGameDAO {

	public GameDAO(Class<Game> entityClass) {
		super(entityClass);
	}
}
