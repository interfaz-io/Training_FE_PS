/**
 * 
 */
package io.interfaz.training.pojos;

import java.util.List;

import lombok.Data;



/**
 * @author María
 *
 */
@Data
public class ProductWrapper {
	private List<Products> product;

	public List<Products> getProduct() {
		return product;
	}

	public void setProduct(List<Products> product) {
		this.product = product;
	}

}
