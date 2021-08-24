/**
 * 
 */
package io.interfaz.training.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import io.interfaz.training.daos.ProductDAO;
import io.interfaz.training.pojos.Customers;
import io.interfaz.training.pojos.Orders;
import io.interfaz.training.pojos.Products;

/**
 * @author Nacho
 *
 */
@Service
public class ProductService {
	@Autowired
	private ProductDAO productDAO;
	
	public List<Products> getAllProduct() {
		return productDAO.getAll();		
	}
	
	public Products getProduct(int id) {
		return productDAO.getById(id);
	}
	
	public Products addProduct(Products product) {
		return productDAO.createProduct(product);
	}
	
	public Products modifyProduct(int id, Products product) {
		return productDAO.updateProduct(id, product);
	}
}
