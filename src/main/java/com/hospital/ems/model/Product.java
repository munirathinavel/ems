package com.hospital.ems.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 
 * This class is configured for all doctor entity validations & hibernate table
 * mapping configurations for product entity.
 * 
 * @author munirathinavel
 *
 */

@Entity
@Table(name = "product")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Product extends BaseModel {

	private static final long serialVersionUID = -1938567246027507296L;

	@Column(name = "name")
	private String name;

	@Column(name = "code")
	private String code;

	@Column(name = "price")
	private boolean price;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public boolean isPrice() {
		return price;
	}

	public void setPrice(boolean price) {
		this.price = price;
	}

}
