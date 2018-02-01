package com.hospital.ems.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 
 * This class is configured for all doctor entity validations & hibernate table
 * mapping configurations for patient entity.
 * 
 * @author munirathinavel
 *
 */
@Entity
@Table(name = "patient")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Patient extends BaseModel {

	private static final long serialVersionUID = 4192997147639777673L;

	@NotNull
	@Column(name = "name")
	@Size(min = 2, max = 50)
	private String name;

	@Column(name = "age")
	@Min(2)
	private int age;

	@Email
	@Column(name = "email")
	private String email;

	@Column(name = "mobile_no")
	private String mobileNo;

	@Column(name = "website")
	private String website;

	@OneToOne
	@MapsId
	private Doctor doctor;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

}
