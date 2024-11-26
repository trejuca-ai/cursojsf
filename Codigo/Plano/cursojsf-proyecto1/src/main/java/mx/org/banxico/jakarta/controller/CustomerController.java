package mx.org.banxico.jakarta.controller;

import java.util.List;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.inject.Model;
import jakarta.inject.Inject;
import lombok.Getter;
import lombok.Setter;
import mx.org.banxico.jakarta.entity.Customer;
import mx.org.banxico.jakarta.service.CustomerService;

@Model
@Getter
@Setter
//@Transactional
public class CustomerController {

	@Inject
	private CustomerService customerService;
	private List<Customer> customerList;
	private String name;
	
	@PostConstruct
	public void init() {
		setCustomerList(customerService.findAll());
	}
	
	public void delete(Integer id) {
		System.out.println("id: " + id);
		customerService.delete(id);
		setCustomerList(customerService.findAll());
		//return "indexpf1.xhtml";
	}
	
	public void findByName() {
		setCustomerList(customerService.findByName(name));
	}
}
