package mx.org.banxico.jakarta.repository;

import java.util.List;

import mx.org.banxico.jakarta.entity.Customer;

public interface CustomerRepository extends Repository<Customer> {

	public List<Customer> findByName(String name);
}
