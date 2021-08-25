/**
 * 
 */
package io.interfaz.training.controllers;

import java.awt.List;
import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

		model.addAttribute("products", serviceProduct.getAllProduct());
		return "web/product/productAdmin";
	}

	@GetMapping("/add")
	public String addProduct() {
		return "web/product/addProduct";
	}

	@GetMapping("/{id}/update")
	public String updateProductForm(@PathVariable int id, Model model) {

	//	model.addAttribute("product", new Products(id, "name 1", "desc 1", 5.5, "available"));
		model.addAttribute("product", this.serviceProduct.getProduct(id));
		return "web/product/updateProduct";
	}
	
	@PostMapping("/{id}/updateProduct")
	public String updateProduct(@PathVariable int id,@ModelAttribute @Valid Products product,Model model) {
		System.out.println("valor nuevo: "+product.toString()+" id: "+id);
		String success = "redirect:/product";
		this.serviceProduct.modifyProduct(id, product);
		return success;
	}
	
}
