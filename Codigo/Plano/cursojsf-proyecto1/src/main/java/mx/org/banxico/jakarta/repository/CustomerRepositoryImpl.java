package mx.org.banxico.jakarta.repository;

import jakarta.enterprise.context.RequestScoped;
import jakarta.transaction.Transactional;
import mx.org.banxico.jakarta.entity.Customer;

@Transactional(Transactional.TxType.REQUIRED)
@RequestScoped
public class CustomerRepositoryImpl extends AbstractRepository<Customer>
	implements Repository<Customer> {

	public CustomerRepositoryImpl() {
		super(Customer.class);
	}
}
