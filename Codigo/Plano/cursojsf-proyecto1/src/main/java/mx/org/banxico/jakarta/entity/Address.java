package mx.org.banxico.jakarta.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@Entity
@Table(name = "address")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "address_id")
	private Integer id;
	@Column(name = "address")
	private String address;
	@Column(name = "city_id")
	private Integer cityId;
	@Column(name = "postal_code")
	private String postalCode;
	@Column(name = "phone")
	private String phone;
	@Column(name = "district")
	private String district;
	@OneToOne(
		fetch = FetchType.LAZY,
		mappedBy = "address"
	)
	private Customer customer;
}
