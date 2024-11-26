package mx.org.banxico.jakarta.repository;

import java.util.List;
import java.util.Optional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public abstract class AbstractRepository<T> {

	private Class<T> entityClass;
	
	//@Inject
	@PersistenceContext(unitName = "default-pu")
	private EntityManager em;
	
	public AbstractRepository(Class<T> entityClass) {
		this.entityClass = entityClass;
	}
	
	public EntityManager getEntityManager() {
		return em;
	}
	
	public void save(T entity) {
		getEntityManager().persist(entity);
	}
	
	public void update(T entity) {
		getEntityManager().merge(entity);
	}
	
	public void delete(Integer id) {
		getEntityManager().remove(
			getEntityManager().find(entityClass, id));	
	}
	
	public Optional<T> findById(Integer id) {
		return Optional.ofNullable(
			getEntityManager().find(entityClass, id));
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<T> findAll() {
		
		CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();
		CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(entityClass);
		Root root = criteriaQuery.from(entityClass);
		
		criteriaQuery.select(root).orderBy(criteriaBuilder.desc(root.get("id")));
		return getEntityManager().createQuery(criteriaQuery).getResultList();
	}
	

}
