/**
 * 
 */
package io.interfaz.training.controllers;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import io.interfaz.training.pojos.Customers;
import io.interfaz.training.pojos.Orders;
import io.interfaz.training.pojos.Products;
import io.interfaz.training.services.CustomerService;
import io.interfaz.training.services.OrderService;
import io.interfaz.training.services.ProductService;

/**
 * @author Nacho
 *
 */
@RequestMapping("/order")
@Controller
public class OrderController {

	@Autowired
	private OrderService serviceOrder;

	@Autowired
	private CustomerService serviceCustomer;

	@Autowired
	private ProductService serviceProduct;


	@GetMapping()
	public String getAllOrders(Model model) {
		model.addAttribute("customer2", "-----");
		model.addAttribute("orders", serviceOrder.getAllOrder());
		model.addAttribute("customers", serviceCustomer.getAllCustomer());
		return "web/order/orderAdmin";
	}

	@GetMapping("/add")
	public String addOrder(Model model) {
		model.addAttribute("products", serviceProduct.getAllProduct());
		return "web/order/addOrder";
	}

	@GetMapping("/getCustomer")
	public String getCustomer(String customers, Model model) {
		System.out.println( customers);
		if(customers==null) {
			model.addAttribute("customer2", "hola");
			
		}else {
			
			model.addAttribute("customer2", serviceCustomer.getCustomerByEmail(customers).getEmail());
		}
		model.addAttribute("orders", serviceOrder.getOrderByCustomer(serviceCustomer.getCustomerByEmail(customers).getId()));
		model.addAttribute("customers", serviceCustomer.getAllCustomer());
		model.addAttribute("customer2", customers);
		return "web/order/orderAdmin";
	}
	}

