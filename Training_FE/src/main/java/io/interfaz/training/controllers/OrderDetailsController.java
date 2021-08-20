/**
 * 
 */
package io.interfaz.training.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import io.interfaz.training.services.OrderDetailsService;

/**
 * @author Nacho
 *
 */
@RequestMapping("/orderDetail")
@Controller
public class OrderDetailsController {

	@Autowired
	private OrderDetailsService serviceOrderDetail;
}
