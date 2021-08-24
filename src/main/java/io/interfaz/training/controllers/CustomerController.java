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
		ArrayList<Customers> listCustomers = new ArrayList<>();
		
		listCustomers.add(new Customers(1,"Oscar","Ulate","oscar@ulate.com",1,"Active"));
		listCustomers.add(new Customers(2,"Maria","Rodriguez","maria@rodriguez.com",1,"Active"));
		listCustomers.add(new Customers(3,"Jose","Zamora","jose@zamroa.com",1,"Active"));
		
		model.addAttribute("customers", listCustomers);
		return "web/customer/allCustomer";
	}
}
