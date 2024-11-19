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
public class CustomerController {

	@Inject
	private CustomerService customerService;
	
	private List<Customer> customerList;
	
	@PostConstruct
	public void init() {
		setCustomerList(customerService.findAll());
	}
}
