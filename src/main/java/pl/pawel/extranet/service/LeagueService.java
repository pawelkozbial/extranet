package pl.pawel.extranet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.pawel.extranet.abstracts.IGenericDAO;
import pl.pawel.extranet.abstracts.IGenericService;
import pl.pawel.extranet.model.League;

@Service
@Transactional
public class LeagueService implements IGenericService<League> {
	
	@Autowired
	private IGenericDAO<League> leagueDAO;

	@Override
	public League findOne(long id) {
		return leagueDAO.findOne(id);
	}

	@Override
	public List<League> findAll() {
		return leagueDAO.findAll();
	}

	@Override
	public void create(League entity) {
		leagueDAO.create(entity);
		
	}

	@Override
	public void update(League entity) {
		leagueDAO.update(entity);		
	}

	@Override
	public void delete(League entity) {
		leagueDAO.delete(entity);
		
	}

	@Override
	public void deleteById(long entityId) {
		leagueDAO.deleteById(entityId);
		
	}

}
