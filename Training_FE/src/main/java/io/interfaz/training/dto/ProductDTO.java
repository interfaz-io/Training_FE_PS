/**
 * 
 */
package io.interfaz.training.dto;

import io.interfaz.training.pojos.ProductWrapper;
import lombok.Data;

/**
 * @author María
 *
 */
@Data
public class ProductDTO {

	private ProductWrapper _embedded;

	public ProductWrapper get_embedded() {
		return _embedded;
	}

	public void set_embedded(ProductWrapper _embedded) {
		this._embedded = _embedded;
	}
}