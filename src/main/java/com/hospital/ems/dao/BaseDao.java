package com.hospital.ems.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospital.ems.model.BaseModel;

/**
 * <p>
 * 
 * This class is used as a base Dao to facilitate the basic database actions
 * (like insert, select, update, delete) data on any table we've configured
 * through the model classes with Hibernate annotations.
 * 
 * </p>
 * 
 * @author munirathinavel
 *
 * @param <T>
 */
public interface BaseDao<T extends BaseModel> extends JpaRepository<T, Serializable> {

}
