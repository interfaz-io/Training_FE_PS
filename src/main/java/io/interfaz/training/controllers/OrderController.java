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

/**
 * @author Nacho
 *
 */
@RequestMapping("/order")
@Controller
public class OrderController {

	@Autowired
	private OrderService serviceOrder;
	

	public String getAllProducts(Model model) {
		ArrayList<Products> listProducts = new ArrayList<>();
		listProducts.add(new Products(1,"name 1","desc 1", 5.5,"available" ));
		listProducts.add(new Products(2,"name 2","desc 1", 5.5,"available" ));
		listProducts.add(new Products(3,"name 3","desc 3", 5.5,"available" ));
		model.addAttribute("products", listProducts);
		return "web/product/productAdmin";
	}

	@GetMapping()
	public String getAllOrders(Model model) {
		ArrayList<Orders> listOrders = new ArrayList<>();
		LocalDateTime purchaseDate = LocalDateTime.now();
		listOrders.add(new Orders(1, purchaseDate, 1, BigDecimal.valueOf(5234), BigDecimal.valueOf(0.13), null, null));
		listOrders.add(new Orders(2, purchaseDate, 2, BigDecimal.valueOf(7784), BigDecimal.valueOf(0.13), null, null));
		listOrders.add(new Orders(3, purchaseDate, 3, BigDecimal.valueOf(1425), BigDecimal.valueOf(0.13), null, null));
		model.addAttribute("orders", listOrders);
		return "web/order/orderAdmin";
	}
	
	//el model lo puse para poder pasar la lista de productos quemada
	@GetMapping("/add")
	public String addOrder(Model model){
		getAllProducts(model);
		return "web/order/addOrder";
	}
}
