package mx.org.banxico.jakarta.controller;

import java.io.Serializable;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;
import mx.org.banxico.jakarta.entity.Customer;
import mx.org.banxico.jakarta.service.CustomerService;

@Getter
@Setter
@RequestScoped
@Named("customerFormController")
public class CustomerFormController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 613972406078099373L;
	@Inject
	private CustomerService customerService;
	private Customer customer = new Customer();
	
	public String save() {
		customerService.save(customer);
		return "indexpf1.xhtml";
	}
	
	public String edit(Integer id) {
		
		Customer customer = customerService.findById(id);
		setCustomer(customer);
		return "formpf1.xhtml";
	}
}
