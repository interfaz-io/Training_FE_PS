/**
 * 
 */
package io.interfaz.training.controllers;

import java.awt.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import io.interfaz.training.services.ProductService;

import io.interfaz.training.pojos.Products;

/**
 * @author Nacho
 *
 */
@RequestMapping("/product")
@Controller
public class ProductController {

	@Autowired
	private ProductService serviceProduct;

	@GetMapping()
	public String getAllProducts(Model model) {

		ArrayList<Products> listProducts = new ArrayList<>();

		listProducts.add(new Products(1, "name 1", "desc 1", 5.5, "available"));
		listProducts.add(new Products(2, "name 2", "desc 1", 5.5, "available"));
		listProducts.add(new Products(3, "name 3", "desc 3", 5.5, "available"));

		model.addAttribute("products", listProducts);
		return "web/product/productAdmin";
	}

	@GetMapping("/add")
	public String addProduct() {
		return "web/product/addProduct";
	}

	@GetMapping("/{id}/update")
	public String updateProduct(@PathVariable int id, Model model) {

		model.addAttribute("product", new Products(id, "name 1", "desc 1", 5.5, "available"));
		return "web/product/updateProduct";
	}
}
