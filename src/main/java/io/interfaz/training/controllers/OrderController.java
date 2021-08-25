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
import org.springframework.web.bind.annotation.RequestMapping;

import io.interfaz.training.pojos.Orders;
import io.interfaz.training.pojos.Products;
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
	private ProductService serviceProduct;

	
	public String getAllProducts(Model model) {
		model.addAttribute("products", serviceProduct.getAllProduct());
		return "web/product/productAdmin";
	}

	@GetMapping()
	public String getAllOrders(Model model) {

		model.addAttribute("orders", serviceOrder.getAllOrder());
		return "web/order/orderAdmin";
	}
	
	//el model lo puse para poder pasar la lista de productos quemada
	@GetMapping("/add")
	public String addOrder(Model model){
		getAllProducts(model);
		return "web/order/addOrder";
	}
}
