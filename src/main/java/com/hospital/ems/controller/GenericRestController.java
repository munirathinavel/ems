package com.hospital.ems.controller;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.hospital.ems.dao.BaseDao;
import com.hospital.ems.model.BaseModel;

/**
 * This is Generic Entity Rest Point which is going to be extended by other
 * entities (eg. Patient, Products) to fulfill the basic HTTP actions (GET,
 * POST, PUT, UPDATE, DELETE)
 * 
 * @author munirathinavel
 *
 * @param <T>
 *            - This T will be entity
 */
public class GenericRestController<T extends BaseModel> {

	private static final Logger logger = LogManager.getLogger(GenericRestController.class);

	@Autowired
	private BaseDao<T> dao;

	/**
	 * Fetch Entity from Database
	 * 
	 * @return
	 */
	@GetMapping
	public List<T> list() {
		logger.debug("In List all method!");
		return dao.findAll();
	}

	/**
	 * Create Entity into the database
	 * 
	 * @return
	 */
	@PostMapping
	public T create(@RequestBody T entity) {
		return dao.save(entity);
	}

	/**
	 * Update Entity based on given id
	 * 
	 * @return
	 */
	@PutMapping(value = "{id}")
	public T update(@PathVariable(value = "id") long id, @RequestBody T entity) {
		return dao.save(entity);
	}

	/**
	 * Delete Entity based on given Id
	 * 
	 * @return
	 */
	@DeleteMapping(value = "{id}")
	public void delete(@PathVariable(value = "id") long id) {
		dao.delete(id);
	}

	/**
	 * Fetch Entity on given id
	 * 
	 * @return
	 */
	@GetMapping(value = "{id}")
	public T get(@PathVariable(value = "id") long id) {
		return dao.getOne(id);
	}
}
