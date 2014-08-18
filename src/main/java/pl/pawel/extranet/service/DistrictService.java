package pl.pawel.extranet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.pawel.extranet.abstracts.IGenericDAO;
import pl.pawel.extranet.abstracts.IGenericService;
import pl.pawel.extranet.model.District;

@Service
@Transactional
public class DistrictService implements IGenericService<District> {

	@Autowired
	public IGenericDAO<District> districtDAO;

	@Override
	public District findOne(long id) {
		return districtDAO.findOne(id);
	}

	@Override
	public List<District> findAll() {
		return districtDAO.findAll();
	}

	@Override
	public void create(District entity) {
		districtDAO.create(entity);

	}

	@Override
	public void update(District entity) {
		districtDAO.update(entity);

	}

	@Override
	public void delete(District entity) {
		districtDAO.delete(entity);

	}

	@Override
	public void deleteById(long entityId) {
		District entity = findOne(entityId);
		delete(entity);
	}

}
