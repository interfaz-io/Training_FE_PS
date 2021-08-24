/**
 * 
 */
package io.interfaz.training.pojos;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;

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
public class Orders {

	private int id;
	private LocalDateTime purchaseDate;
	private int customerId;
	private BigDecimal subtotal;
	private BigDecimal iva;
	private BigDecimal total;
	
	private ArrayList<OrdersDetails> details ;
}
