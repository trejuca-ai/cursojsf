package mx.org.banxico.jakarta.controller;

import java.util.List;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.inject.Model;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import lombok.Getter;
import lombok.Setter;
import mx.org.banxico.jakarta.entity.Customer;
import mx.org.banxico.jakarta.service.AddressService;
import mx.org.banxico.jakarta.service.CustomerService;

@Model
@Getter
@Setter
//@Transactional
public class CustomerModalController {

	@Inject
	private CustomerService customerService;
	private List<Customer> customerList;
	private String name;
	private Customer customer = new Customer();
	
	@PostConstruct
	public void init() {
		setCustomerList(customerService.findAll());
	}
	
	public void delete(Integer id) {
		if (true) {
			throw new RuntimeException("Error ocurrido al eliminar");
		}
		System.out.println("id: " + id);
		customerService.delete(id);
		setCustomerList(customerService.findAll());
	}
	
	public void save() {
		customerService.save(customer);
		setCustomerList(customerService.findAll());
		customer = new Customer();
	}
	
	public void edit(Integer id) {
		
		Customer customer = customerService.findById(id);
		setCustomer(customer);

	}
	
	public void findByName() {
		setCustomerList(customerService.findByName(name));
	}
	
	public void reset() {
		customer = new Customer();
	}
}
