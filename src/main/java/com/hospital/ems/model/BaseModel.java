package com.hospital.ems.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * <P>
 * This class is used as a base class to all models such that other entity
 * classes class extend in the future to adapt to any new entity
 * </P>
 * 
 * @author munirathinavel
 *
 */
@MappedSuperclass
@SuppressWarnings("serial")
public class BaseModel implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id", nullable = false, columnDefinition = "BIGINT")
	private long id;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
