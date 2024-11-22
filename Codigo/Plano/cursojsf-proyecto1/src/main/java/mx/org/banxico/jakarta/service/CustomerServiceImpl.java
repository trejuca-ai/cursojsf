package mx.org.banxico.jakarta.service;

import java.util.List;
import java.util.Optional;

import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.transaction.Transactional;
import mx.org.banxico.jakarta.entity.Address;
import mx.org.banxico.jakarta.entity.Customer;
import mx.org.banxico.jakarta.repository.CustomerRepository;
import mx.org.banxico.jakarta.repository.Repository;

@RequestScoped
@Named
//@Transactional
public class CustomerServiceImpl implements CustomerService {

	//@Inject
	@EJB(beanName = "customerRepositoryImpl")
	private CustomerRepository customerRepository;
	
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
	public Customer findById(Integer id) {

		Optional<Customer> customer = customerRepository.findById(id);
//		Customer c = customer.orElseThrow(() -> new RuntimeException(
//				"No se encontro el customer con el id"));
//		
		return customer.get();
	}

	@Override
	public void save(Customer customer) {
		//customer.setAddressId(1);
		Address direccion = new Address();
		direccion.setId(1);
		
		customer.setAddress(direccion);
		customer.setStoreId(1);
		customer.setActive('1');
		
		if (customer.getId() != null) {
			customerRepository.update(customer);
		} else {
			customerRepository.save(customer);
		}
		
	}

	@Override
	public List<Customer> findByName(String name) {
		return customerRepository.findByName(name);
	}


}
