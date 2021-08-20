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
public class OrdersDTO {
	private OrdersWrapper _embedded;

	public OrdersWrapper get_embedded() {
		return _embedded;
	}

	public void set_embedded(OrdersWrapper _embedded) {
		this._embedded = _embedded;
	}

}
