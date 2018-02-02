package com.hospital.ems.controller;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

	// @Autowired
	// private IPatientDao patientDao;

	/**
	 * Fetch Entity from Database
	 * 
	 * @return
	 */
	@GetMapping
	public ResponseEntity<List<T>> list() {
		logger.debug("In List all method!");
		/*
		 * if (entity instanceof Patient) { return (T) patientDao.save((Patient)
		 * entity); } else {
		 */
		return ResponseEntity.ok().body(dao.findAll());
		// }
	}

	/**
	 * Create Entity into the database
	 * 
	 * @return
	 */
	@PostMapping
	public ResponseEntity<T> create(@RequestBody T entity) {
		logger.debug("Creating entity into DB");

		return ResponseEntity.ok().body(dao.save(entity));

	}

	/**
	 * Update Entity based on given id
	 * 
	 * @return
	 */
	@PutMapping(value = "{id}")
	public ResponseEntity<T> update(@PathVariable(value = "id") long id, @RequestBody T entity) {
		logger.debug("Updating entity with id:" + id);
		return ResponseEntity.ok().body(dao.save(entity));
	}

	/**
	 * Delete Entity based on given Id
	 * 
	 * @return
	 */
	@DeleteMapping(value = "{id}")
	public ResponseEntity<String> delete(@PathVariable(value = "id") long id) {
		logger.debug("Deleting entity with id:" + id);
		dao.delete(id);
		return ResponseEntity.ok().body("Entity deleted successfully for id:" + id);
	}

	/**
	 * Fetch Entity on given id
	 * 
	 * @return
	 */
	@GetMapping(value = "{id}")
	public ResponseEntity<T> get(@PathVariable(value = "id") long id) {
		logger.debug("Fetching entity with id:" + id);
		return ResponseEntity.ok().body(dao.getOne(id));
	}
}
