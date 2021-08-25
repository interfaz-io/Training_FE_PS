/**
 * 
 */
package io.interfaz.training.controllers;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import io.interfaz.training.pojos.Customers;
import io.interfaz.training.pojos.Products;
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
	
	@GetMapping("/addCustomer")
	public String newCustomer() {
		
		return "web/customer/addCustomer";
	}
	
	@GetMapping("/allCustomer")
	public String allCustomer(Model model) {
		
		model.addAttribute("customers", serviceCustomer.getAllCustomer());
		return "web/customer/allCustomer";
	}
}
