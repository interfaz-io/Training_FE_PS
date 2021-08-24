/**
 * 
 */
package io.interfaz.training.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import io.interfaz.training.daos.ProductDAO;
import io.interfaz.training.pojos.Products;

/**
 * @author Nacho
 *
 */
@Service
public class ProductService {
	@Autowired
	private ProductDAO product;
	
	public List<Products> getAllProduct() {
		return product.getAll();		
	}
}
