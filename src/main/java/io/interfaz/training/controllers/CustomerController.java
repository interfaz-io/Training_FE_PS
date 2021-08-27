/**
 * 
 */
package io.interfaz.training.controllers;
import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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

	@GetMapping()
	public String allCustomer(Model model) {
		model.addAttribute("customers", serviceCustomer.getAllCustomer());
		return "web/customer/allCustomer";
	}
	
	@GetMapping("/add")
	public String newCustomer() {
		return "web/customer/addCustomer";
	}
	
	
	@PostMapping("/add")
	public String addCustomer(@ModelAttribute  @Valid Customers customers,BindingResult result, Model model) {
		
		if (result.hasErrors()) {

			Map<String, String> errores = new HashMap<>();
			result.getFieldErrors().forEach(err -> {
				errores.put(err.getField(), err.getDefaultMessage());
			});
			model.addAttribute("error", errores);
			return "web/customer/addCustomer";
		}
		
		//System.out.print(customers);
		serviceCustomer.addCustomer(customers);
		return "redirect:/customer";
	}
	
}
