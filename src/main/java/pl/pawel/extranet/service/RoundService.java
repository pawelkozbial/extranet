package pl.pawel.extranet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.pawel.extranet.abstracts.GenericHibernateDAO;
import pl.pawel.extranet.abstracts.IGenericDAO;
import pl.pawel.extranet.model.Round;

@Service
@Transactional
public class RoundService extends GenericHibernateDAO<Round> implements
		IRoundService {

	@Autowired
	private IGenericDAO<Round> roundDAO;

	@Override
	public Round findOne(long id) {
		return roundDAO.findOne(id);
	}

	@Override
	public List<Round> findAll() {
		return roundDAO.findAll();
	}

	@Override
	public void create(Round entity) {
		roundDAO.create(entity);

	}

	@Override
	public void update(Round entity) {
		roundDAO.update(entity);
	}

	@Override
	public void delete(Round entity) {
		roundDAO.delete(entity);
	}

	@Override
	public void deleteById(long entityId) {
		Round round = findOne(entityId);
		delete(round);

	}

}
