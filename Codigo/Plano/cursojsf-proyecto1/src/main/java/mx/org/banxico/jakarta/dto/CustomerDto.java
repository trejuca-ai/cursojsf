package mx.org.banxico.jakarta.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class CustomerDto {

	private Integer id;
	private Integer storeId;
	private String firstName;
	private String lastName;
	private String email;
	private Character active;
	private Integer addressId;
}
