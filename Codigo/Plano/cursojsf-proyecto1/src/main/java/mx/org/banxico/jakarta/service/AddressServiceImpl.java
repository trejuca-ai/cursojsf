package mx.org.banxico.jakarta.service;

import jakarta.inject.Inject;
import lombok.Getter;
import lombok.Setter;
import mx.org.banxico.jakarta.entity.Customer;

@Getter
@Setter
public class AddressServiceImpl implements AddressService {

	private String saludo;
	private Customer customer;
	
	@Inject
	public AddressServiceImpl(String saludo) {
		this.saludo = saludo;
	}

	@Inject
	public AddressServiceImpl(Customer customer) {
		this.customer = customer;
	}
	
	@Override
	public void saludar() {
		System.out.println("el saludo es: " + saludo);	
	}

	@Override
	public void imprimirCustomer() {
		System.out.println(customer);
		
	}
}
