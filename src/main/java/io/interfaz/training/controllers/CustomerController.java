/**
 * 
 */
package io.interfaz.training.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import io.interfaz.training.pojos.Customers;
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
	
	@GetMapping("/add")
	public String newCustomer() {
		return "web/customer/addCustomer";
	}
	
	@GetMapping()
	public String allCustomer(Model model) {
		
		model.addAttribute("customers", serviceCustomer.getAllCustomer());
		return "web/customer/allCustomer";
	}
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable int id,Model model) {
		
		model.addAttribute("customer", serviceCustomer.getCustomer(id));
		return "web/customer/updateCustomer";
	}
	
	@PostMapping("/add")
	public String addCustomer(@ModelAttribute Customers customers) {
		
		System.out.print(customers);
		serviceCustomer.addCustomer(customers);
		return "redirect:/customer";
	}
	
	@PostMapping("/updateCustomer/{id}")
	public String updateCustomer(@PathVariable int id, @ModelAttribute Customers customers) {
		
		System.out.print(customers);
		serviceCustomer.updateCustomer(id,customers);
		return "redirect:/customer";
	}
	
}

