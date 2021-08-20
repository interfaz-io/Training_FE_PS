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
public class CustomerWrapper {
	private List<Customers> customer;

	public List<Customers> getCustomer() {
		return customer;
	}

	public void setCustomer(List<Customers> customer) {
		this.customer = customer;
	}

}
