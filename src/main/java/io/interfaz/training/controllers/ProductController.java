/**
 * 
 */
package io.interfaz.training.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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

		// model.addAttribute("product", new Products(id, "name 1", "desc 1", 5.5,
		// "available"));
		model.addAttribute("product", this.serviceProduct.getProduct(id));
		return "web/product/updateProduct";
	}

	@PostMapping("/add")
	public String createProduct(@ModelAttribute("product") @Valid Products products, BindingResult result, Model model) {

		if (result.hasErrors()) {

			Map<String, String> errores = new HashMap<>();
			result.getFieldErrors().forEach(err -> {
				errores.put(err.getField(), err.getDefaultMessage());
			});
			model.addAttribute("error", errores);
			return "web/product/addProduct";
		}

		serviceProduct.addProduct(products);
		return "redirect:/product";
	}

	@PostMapping("/{id}/updateProduct")
	public String updateProduct(@PathVariable int id, @ModelAttribute("product") @Valid Products product, BindingResult result,
			Model model) {

		if (result.hasErrors()) {
			
			return "web/product/updateProduct";
		}

		String success = "redirect:/product";
		this.serviceProduct.modifyProduct(id, product);
		return success;
	}

}
