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
public class OrdersWrapper {
	private List<Orders> order;

	public List<Orders> getOrder() {
		return order;
	}

	public void setOrder(List<Orders> order) {
		this.order = order;
	}

}
