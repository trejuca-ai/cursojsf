package mx.org.banxico.jakarta.entity;

import jakarta.enterprise.inject.Model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@Entity
@Table(name = "customer")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customer_id")
	private Integer id;
	
	@Column(name = "store_id")
	private Integer storeId;
	
	@NotEmpty(message = "{catalogo.customer.firstName.notEmpty}")
	@Size(min = 5, message = "{catalogo.customer.firstName.size}")
	@Column(name = "first_name")
	private String firstName;
	
	@NotEmpty(message = "{catalogo.customer.lastName.notEmpty}")
	@Size(min = 5, message = "{catalogo.customer.lastName.size}")
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "email")
	@NotEmpty(message = "{catalogo.customer.email.notEmpty}")
	@Email(message = "{catalogo.customer.email.format}")
	private String email;
	
	@Column(name = "active")
	private Character active;
	
	@Column(name = "address_id")
	private Integer addressId;

	
	
}
