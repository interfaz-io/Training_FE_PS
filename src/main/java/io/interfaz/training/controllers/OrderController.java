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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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
	private ProductController productController;
	
	@Autowired
	private CustomerController customerController;


	
	public void getAllProducts(Model model) {
		productController.getAllProducts(model);
	
	}
	public void allCustomer(Model model) {
		customerController.allCustomer(model);
	}
	
//	@GetMapping("/getById/{id}")
//	public String getById(@PathVariable int id, Model model){
//		 model.addAttribute("customers",this.service.getById(id)) ;
//		 return "people/information";
//	}
	//<td><a th:href="'/people/getById/' + ${person.id}" th:text="${person.id}"></a></td>

	@GetMapping()
	public String getAllOrders(Model model) {
		model.addAttribute("orders", serviceOrder.getAllOrder());
		allCustomer(model);
		return "web/order/orderAdmin";
	}
	
	//el model lo puse para poder pasar la lista de productos quemada
	@GetMapping("/add")
	public String addOrder(Model model){
		getAllProducts(model);
		return "web/order/addOrder";
	}
}
