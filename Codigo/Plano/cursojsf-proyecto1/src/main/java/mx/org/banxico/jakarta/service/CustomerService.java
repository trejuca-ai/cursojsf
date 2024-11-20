package mx.org.banxico.jakarta.service;

import java.util.List;
import mx.org.banxico.jakarta.entity.Customer;

public interface CustomerService {

	public List<Customer> findAll();
	public void update(Customer customer);
	public void delete(Integer id);
	public Customer findById(Integer id);
	public void save(Customer customer);
}
