package pl.pawel.extranet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.pawel.extranet.abstracts.GenericHibernateDAO;
import pl.pawel.extranet.abstracts.IGenericDAO;
import pl.pawel.extranet.model.Queue;

@Service
@Transactional
public class QueueService extends GenericHibernateDAO<Queue> implements
		IQueueService {

	@Autowired
	private IGenericDAO<Queue> queueDAO;

	@Override
	public Queue findOne(long id) {
		return queueDAO.findOne(id);
	}

	@Override
	public List<Queue> findAll() {
		return queueDAO.findAll();
	}

	@Override
	public void create(Queue entity) {
		queueDAO.create(entity);
	}

	@Override
	public void update(Queue entity) {
		queueDAO.update(entity);
	}

	@Override
	public void delete(Queue entity) {
		queueDAO.delete(entity);

	}

	@Override
	public void deleteById(long entityId) {
		Queue queue = findOne(entityId);
		delete(queue);
	}

}
