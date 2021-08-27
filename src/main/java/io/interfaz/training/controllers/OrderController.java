/**
 * 
 */
package io.interfaz.training.controllers;

import java.math.BigDecimal;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import io.interfaz.training.pojos.Customers;
import io.interfaz.training.pojos.Orders;
import io.interfaz.training.pojos.OrdersDetails;

import io.interfaz.training.services.CustomerService;
import io.interfaz.training.services.OrderDetailsService;
import io.interfaz.training.services.OrderService;
import io.interfaz.training.services.ProductService;

/**
 * @author Nacho
 *
 */
@SessionAttributes({ "customer2", "orderNew" })
@RequestMapping("/order")
@Controller
public class OrderController {

	@Autowired
	private OrderService serviceOrder;

	@Autowired
	private ProductService productOrder;

	@Autowired
	private CustomerService serviceCustomer;

	@Autowired
	private OrderDetailsService serviceOrderDetail;

	@ModelAttribute("customer2")
	public Customers customer2() {
		return new Customers(null, "", "", null, null, null, null);
	}
	@GetMapping()
	public String getAllOrders(Model model, @ModelAttribute("customer2") Customers customer2) {
		
		if ((null != customer2.getEmail()) && (!customer2.getEmail().isBlank())) {
			model.addAttribute("orders",serviceOrder.getOrderByCustomer(serviceCustomer.getCustomerByEmail(customer2.getEmail()).getId()));
		}

		return "web/order/orderAdmin";
	}

//	@GetMapping("/all")
//	public String all (Model model,@ModelAttribute("customer2") Customers customer2, HttpSession session){
//		if (!customer2.getEmail().equalsIgnoreCase("")) {
//			model.addAttribute("orders",serviceOrder.getOrderByCustomer(serviceCustomer.getCustomerByEmail(customer2.getEmail()).getId()));
//		}
//		session.setAttribute("name", "Anthony");
//		return "web/order/orderAdmin";
//	}
	
	/*
	 * @GetMapping("/add") public String addOrder(Model model, String keyword){
	 * if(keyword != null && !keyword.equalsIgnoreCase("")) {
	 * model.addAttribute("products", productOrder.searchProductByName(keyword));
	 * }else { model.addAttribute("products", productOrder.getAllProduct()); }
	 * 
	 * //getAllProducts(model); return "web/order/addOrder"; }
	 */

	/*
	 * @GetMapping("/addNewOrder") public String addNewOrder(Model
	 * model, @ModelAttribute("customer2") Customers customer2, String keyword) {
	 * 
	 * Orders newOrder = serviceOrder.addOrder(new Orders(null, new Date(),
	 * customer2.getId(), BigDecimal.valueOf(0), BigDecimal.valueOf(0),
	 * BigDecimal.valueOf(0))); model.addAttribute("orderNew", newOrder.getId());
	 * 
	 * if (keyword != null && !keyword.equalsIgnoreCase("")) {
	 * model.addAttribute("products", productOrder.searchProductByName(keyword)); }
	 * else { model.addAttribute("products", productOrder.getAllProduct()); }
	 * 
	 * return "web/order/addOrder"; }
	 */

	@GetMapping("/add")
	public String addOrder(Model model, String keyword, @ModelAttribute("orderNew") Orders orderNew,
			@ModelAttribute("customer2") Customers customer2) {
		System.out.println("order id para meter: " + orderNew.getId());
		// System.out.println("customer "+ customer2.getFirstName());
		if (keyword != null && !keyword.equalsIgnoreCase("")) {
			model.addAttribute("products", productOrder.searchProductByName(keyword));
		} else {
			model.addAttribute("products", productOrder.getAllProduct());
		}
//
//		if (orderNew.getId() == null) {
//			Orders newOrder = serviceOrder.addOrder(new Orders(null, new Date(), customer2.getId(),
//					BigDecimal.valueOf(0), BigDecimal.valueOf(0), BigDecimal.valueOf(0)));
//			model.addAttribute("orderNew", newOrder);
//		} else {
//			model.addAttribute("orderNew", orderNew);
//		}
		model.addAttribute("orderNew", orderNew);
		// System.out.println(newOrder.toString());
		// getAllProducts(model);
		return "web/order/addOrder";
	}

	@PostMapping("/addNewOrder")
	public String addNewOrder(Model model, @ModelAttribute("customer2") Customers customer2) {
		Orders newOrder = serviceOrder.addOrder(new Orders(0, new Date(), customer2.getId(), BigDecimal.valueOf(0),
				BigDecimal.valueOf(0), BigDecimal.valueOf(0)));
		model.addAttribute("orderNew", newOrder);
		System.out.println(newOrder);
		return "web/order/addOrder";
	}

	@PostMapping("/addOrderDetail")
	public String addOrderDetails(Integer idProduct, @ModelAttribute("orderNew") Orders orderNew, Model model) {
		System.out.println("id product: " + idProduct);
		OrdersDetails newOrderDetail = serviceOrderDetail.addOrderDetails(new OrdersDetails(0, orderNew.getId(),
				idProduct, 0, BigDecimal.valueOf(0), 0, productOrder.getProduct(idProduct)));
		// model.addAttribute("orderNew", idOrder);
		return "web/order/addOrder";
	}

	@GetMapping("/{id}")
	public String getDetails(@PathVariable int id, Model model) {
		model.addAttribute("orderDetails", serviceOrder.getAllDetails(id));
		return "web/order/orderInfo";
	}

	@GetMapping("/getCustomer")
	public String getCustomer(String email, Model model) {
		
		model.addAttribute("customer2", serviceCustomer.getCustomerByEmail(email));
		model.addAttribute("orders",serviceOrder.getOrderByCustomer(serviceCustomer.getCustomerByEmail(email).getId()));

		return "web/order/orderAdmin";
	}
	@GetMapping("/return")
	public String status(SessionStatus status) {
		status.setComplete();
		return "web/home";
	}
}
