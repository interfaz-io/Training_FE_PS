/**
 * 
 */
package io.interfaz.training.pojos;

import java.math.BigDecimal;

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
	 private int order;
	 private int productId;
	 private int quantity;
	 private BigDecimal price;
	 private int totalAmount;
	 
	 private Products products;
}
