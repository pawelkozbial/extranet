package pl.pawel.extranet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.pawel.extranet.dao.IClubDAO;
import pl.pawel.extranet.model.Club;

@Service
@Transactional
public class ClubService implements IClubService {

	@Autowired
	private IClubDAO clubDAO;

	@Override
	public Club findOne(long id) {
		return clubDAO.findOne(id);
	}

	@Override
	public List<Club> findAll() {
		return clubDAO.findAll();
	}

	@Override
	public void create(Club entity) {
		clubDAO.create(entity);
	}

	@Override
	public void update(Club entity) {
		clubDAO.update(entity);
	}

	@Override
	public void delete(Club entity) {
		clubDAO.delete(entity);
	}

	@Override
	public void deleteById(long entityId) {
		Club club = findOne(entityId);
		delete(club);
	}

}
