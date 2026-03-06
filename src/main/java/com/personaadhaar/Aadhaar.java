package com.personaadhaar;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name ="aadhars")
public class Aadhaar {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long aid;


	@Column(nullable = false, unique = true)
	private String anum;


	private String address;


	@OneToOne(mappedBy = "aadhaar")
	private Person person; // optional back-reference


	public Aadhaar() {}


	public Aadhaar(String anum, String address) {
	this.anum = anum;
	this.address = address;
	}


	public Long getAid() {
		return aid;
	}


	public void setAid(Long aid) {
		this.aid = aid;
	}


	public String getAnum() {
		return anum;
	}


	public void setAnum(String anum) {
		this.anum = anum;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public Person getPerson() {
		return person;
	}


	public void setPerson(Person person) {
		this.person = person;
	}
	
	

}
