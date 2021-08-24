/**
 * 
 */
package io.interfaz.training.dto;

import io.interfaz.training.pojos.OrdersDetailsWrapper;
import lombok.Data;

/**
 * @author María
 *
 */
@Data
public class OrderDetailsDTO {

	private OrdersDetailsWrapper _embedded;

	public OrdersDetailsWrapper get_embedded() {
		return _embedded;
	}

	public void set_embedded(OrdersDetailsWrapper _embedded) {
		this._embedded = _embedded;
	}
}
