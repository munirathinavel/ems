package com.hospital.ems.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 
 * This class is configured for all doctor entity validations & hibernate table
 * mapping configurations for doctor sub-entity.
 * 
 * @author munirathinavel
 *
 */
@Entity
@Table(name = "doctor")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Doctor extends BaseModel {

	private static final long serialVersionUID = 8602662017185237907L;

	@NotNull
	@Column(name = "name")
	@Size(max = 100)
	private String name;

	@Column(name = "email")
	private String email;

	@NotNull
	@Column(name = "mobile_no")
	private String mobileNo;

	@NotNull
	@Column(name = "department")
	private String department;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

}