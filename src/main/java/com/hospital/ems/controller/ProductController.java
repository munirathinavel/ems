package com.hospital.ems.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.ems.model.Product;

/**
 * <p>
 * 
 * This class represents all actions (create, update, delete, fetch) related to
 * the product entity </>
 * 
 * @author munirathinavel
 *
 */
@RestController
@RequestMapping("/products")
public class ProductController extends GenericRestController<Product> {

}
