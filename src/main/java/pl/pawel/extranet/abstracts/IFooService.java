package pl.pawel.extranet.abstracts;

import java.util.List;

import pl.pawel.extranet.model.User;

public interface IFooService {

	public abstract User findOne(long id);

	public abstract List<User> findAll();

	public abstract void create(User entity);

	public abstract void update(User entity);

	public abstract void delete(User entity);

	public abstract void deleteById(long entityId);

	public abstract int count(long id);

}