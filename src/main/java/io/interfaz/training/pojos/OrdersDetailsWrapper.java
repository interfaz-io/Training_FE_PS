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
public class OrdersDetailsWrapper {

	private List<OrdersDetails> ordersDetails;

	public List<OrdersDetails> getOrdersDetails() {
		return ordersDetails;
	}

	public void setOrdersDetails(List<OrdersDetails> ordersDetails) {
		this.ordersDetails = ordersDetails;
	}
}
