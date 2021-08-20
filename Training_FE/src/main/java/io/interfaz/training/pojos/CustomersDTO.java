/**
 * 
 */
package io.interfaz.training.pojos;

import lombok.Data;

/**
 * @author María
 *
 */
@Data
public class CustomersDTO {
	private CustomerWrapper _embedded;

	public CustomerWrapper get_embedded() {
		return _embedded;
	}

	public void set_embedded(CustomerWrapper _embedded) {
		this._embedded = _embedded;
	}

}
