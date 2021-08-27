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

	@GetMapping("/add")
	public String addOrder(Model model, String keyword, @ModelAttribute("orderNew") Orders orderNew,
			@ModelAttribute("customer2") Customers customer2) {
		if (keyword != null && !keyword.equalsIgnoreCase("")) {
			model.addAttribute("products", productOrder.searchProductByName(keyword));
		} else {
			model.addAttribute("products", productOrder.getAllProduct());
		}
		model.addAttribute("orderNew", orderNew);
		return "web/order/addOrder";
	}

	@PostMapping("/addNewOrder")
	public String addNewOrder(Model model, @ModelAttribute("customer2") Customers customer2) {
		Orders newOrder = serviceOrder.addOrder(new Orders(0, new Date(), customer2.getId(), BigDecimal.valueOf(0),
				BigDecimal.valueOf(0), BigDecimal.valueOf(0)));
		model.addAttribute("orderNew", newOrder);
		return "web/order/addOrder";
	}

	@PostMapping("/addOrderDetail")
	public String addOrderDetails(Integer idProduct, @ModelAttribute("orderNew") Orders orderNew, Model model, Integer quantity, Integer productPrice) {
		OrdersDetails newOrderDetail = serviceOrderDetail.addOrderDetails(new OrdersDetails(0, orderNew.getId(),
				idProduct, quantity, BigDecimal.valueOf(productPrice), 0, productOrder.getProduct(idProduct)));
		return "web/order/addOrder";
	}

	@GetMapping("/{id}")
	public String getDetails(@PathVariable int id, Model model) {
		model.addAttribute("orderDetails", serviceOrder.getAllDetails(id));
		return "web/order/orderInfo";
	}

	@GetMapping("/getCustomer")
	public String getCustomer(String email, Model model) {
		try {
			if (!email.isEmpty()) {
				model.addAttribute("customer2", serviceCustomer.getCustomerByEmail(email));
				model.addAttribute("orders",serviceOrder.getOrderByCustomer(serviceCustomer.getCustomerByEmail(email).getId()));
			}
			
		} catch (Exception e) {
			return "web/order/orderAdmin";
		}
		
		return "web/order/orderAdmin";
	}
	@GetMapping("/return")
	public String status(SessionStatus status) {
		status.setComplete();
		return "web/home";
	}
}
