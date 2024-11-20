package mx.org.banxico.jakarta.repository;

import java.util.List;
import java.util.Optional;

import jakarta.ejb.Local;

@Local
public interface Repository<T> {
	public void save(T entity);
	public void update(T entity);
	public void delete(Integer id);
	public Optional<T> findById(Integer id);
	public List<T> findAll();
}
