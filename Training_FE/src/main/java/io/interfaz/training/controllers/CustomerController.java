/**
 * 
 */
package io.interfaz.training.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import io.interfaz.training.services.CustomerService;

/**
 * @author Nacho
 *
 */

@RequestMapping("/customer")
@Controller
public class CustomerController {

	@Autowired
	private CustomerService serviceCustomer;
}
