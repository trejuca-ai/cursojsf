package mx.org.banxico.jakarta.repository;

import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.persistence.Query;
import mx.org.banxico.jakarta.entity.Customer;

//@Transactional(Transactional.TxType.REQUIRED)
//@RequestScoped
@Stateless(name = "customerRepositoryImpl")
public class CustomerRepositoryImpl extends AbstractRepository<Customer>
	implements CustomerRepository {

	public CustomerRepositoryImpl() {
		super(Customer.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> findByName(String name) {
		String queryString = """
					FROM Customer c
					WHERE (concat(c.firstName, ' ', c.lastName))
						LIKE concat('%', :nombre, '%')
					OR c.firstName LIKE concat('%', :nombre, '%')
					OR c.lastName LIKE concat('%', :nombre, '%')
				""";
		
		Query query = getEntityManager().createQuery(queryString, Customer.class);
		query.setParameter("nombre", name);
		
		return query.getResultList();
	}
}
