/**
 * 
 */
package io.interfaz.training.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
