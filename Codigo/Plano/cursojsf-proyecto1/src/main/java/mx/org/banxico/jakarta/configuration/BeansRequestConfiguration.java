package mx.org.banxico.jakarta.configuration;

import jakarta.enterprise.context.Dependent;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Named;
import mx.org.banxico.jakarta.entity.Customer;
import mx.org.banxico.jakarta.service.AddressServiceImpl;

@RequestScoped
public class BeansRequestConfiguration {

	@Produces
	@Dependent
	@Named("customAddress")
	public AddressServiceImpl addressServiceImpl() {
		return new AddressServiceImpl("hola desde cdi");
	}
	
	@Produces
	@Dependent
	@Named("customAddressCustomer")
	public AddressServiceImpl addressServiceImpl2() {
		return new AddressServiceImpl(new Customer());
	}
}
