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
public class CustomerController {

	@Inject
	private CustomerService customerService;
	
	private List<Customer> customerList;
	
	@PostConstruct
	public void init() {
		setCustomerList(customerService.findAll());
	}
	
	public String delete(Integer id) {
		System.out.println("id: " + id);
		customerService.delete(id);
		return "index.xhtml?faces-redirect=true";
	}
}
