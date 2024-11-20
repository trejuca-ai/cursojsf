package mx.org.banxico.jakarta.repository;

import jakarta.ejb.Stateless;
import jakarta.enterprise.context.RequestScoped;
import jakarta.transaction.Transactional;
import mx.org.banxico.jakarta.entity.Customer;

//@Transactional(Transactional.TxType.REQUIRED)
//@RequestScoped
@Stateless(name = "customerRepositoryImpl")
public class CustomerRepositoryImpl extends AbstractRepository<Customer>
	implements Repository<Customer> {

	public CustomerRepositoryImpl() {
		super(Customer.class);
	}
}
