package com.hospital.ems.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.ems.model.Patient;

/**
 * <p>
 * 
 * This class represents all actions (create, update, delete, fetch) related to
 * the patient entity </>
 * 
 * @author munirathinavel
 *
 */
@RestController
@RequestMapping("/patients")
public class PatientController extends GenericRestController<Patient> {

}
