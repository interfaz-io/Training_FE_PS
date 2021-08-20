/**
 * 
 */
package io.interfaz.training.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import io.interfaz.training.services.ProductService;

/**
 * @author Nacho
 *
 */
@RequestMapping("/product")
@Controller
public class ProductController {

	@Autowired
	private ProductService serviceProduct;
}
