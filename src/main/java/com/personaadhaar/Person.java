package com.personaadhaar;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "persons")
public class Person {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long pid;


	private String name;
	private Integer age;
	private String gender;


	@OneToOne
	@JoinColumn(name = "aadhaar_id", referencedColumnName = "aid")
	private Aadhaar aadhaar;


	public Person() {}


	public Person(String name, Integer age, String gender) {
	this.name = name;
	this.age = age;
	this.gender = gender;
	}


	public Long getPid() {
		return pid;
	}


	public void setPid(Long pid) {
		this.pid = pid;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Integer getAge() {
		return age;
	}


	public void setAge(Integer age) {
		this.age = age;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public Aadhaar getAadhaar() {
		return aadhaar;
	}


	public void setAadhaar(Aadhaar aadhaar) {
		this.aadhaar = aadhaar;
	}
	
	
	 
	

}
