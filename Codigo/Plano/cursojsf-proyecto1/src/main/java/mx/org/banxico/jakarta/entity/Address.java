package mx.org.banxico.jakarta.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


public class Address {

	private Integer id;
	private String address;
	private Integer cityId;
	private String postalCode;
	private String phone;
	private String district;
	private Date lastUpdate;
	private Customer customer;

}
