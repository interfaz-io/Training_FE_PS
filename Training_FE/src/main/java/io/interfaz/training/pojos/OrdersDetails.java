/**
 * 
 */
package io.interfaz.training.pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author María
 *
 */
 @Data
 @AllArgsConstructor
 @NoArgsConstructor
public class OrdersDetails {
	 
	 private int id;
	 private int orderId;
	 private int productId;
	 private int quantity;
	 private double price;
	 private int totalAmount;

}
