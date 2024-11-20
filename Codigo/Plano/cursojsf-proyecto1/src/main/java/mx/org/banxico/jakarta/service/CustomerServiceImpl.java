package mx.org.banxico.jakarta.service;

import java.util.List;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.transaction.Transactional;
import mx.org.banxico.jakarta.entity.Customer;
import mx.org.banxico.jakarta.repository.Repository;

@RequestScoped
@Named
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Inject
	private Repository<Customer> customerRepository;
	
	@Override
	public List<Customer> findAll() {
		return customerRepository.findAll();
	}

	@Override
	public void update(Customer customer) {
		customerRepository.update(customer);
	}

	@Override
	public void delete(Integer id) {
		customerRepository.delete(id);
	}

	@Override
	public Customer findById() {
		// TODO Auto-generated method stub
		return null;
	}
}
