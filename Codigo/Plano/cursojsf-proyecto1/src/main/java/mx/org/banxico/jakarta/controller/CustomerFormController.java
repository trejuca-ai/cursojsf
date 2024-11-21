package mx.org.banxico.jakarta.controller;

import java.io.Serializable;

import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Model;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.transaction.Transactional;
import lombok.Getter;
import lombok.Setter;
import mx.org.banxico.jakarta.entity.Customer;
import mx.org.banxico.jakarta.service.AddressService;
import mx.org.banxico.jakarta.service.CustomerService;
import mx.org.banxico.jakarta.service.CustomerServiceImpl;

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
		return "index-bootstrap.xhtml?faces-redirect=true";
	}
	
	public String edit(Integer id) {
		
		Customer customer = customerService.findById(id);
		setCustomer(customer);
		return "form-bootstrap.xhtml";
	}
}
