package pl.pawel.extranet.abstracts;

import java.util.List;

public interface IGenericService<T> {

	public abstract T findOne(long id);

	public abstract List<T> findAll();

	public abstract void create(T entity);

	public abstract void update(T entity);

	public abstract void delete(T entity);

	public abstract void deleteById(long entityId);

}