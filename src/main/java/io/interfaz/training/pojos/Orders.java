/**
 * 
 */
package io.interfaz.training.pojos;

import java.util.Date;
import java.math.BigDecimal;
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

/**
 * @author María
 *
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Orders {

	 
	private Integer id;
	
	private Date purchaseDate;
	
	private int customerId;
	
	private BigDecimal subtotal;
	
	private BigDecimal iva;
	
	private BigDecimal total;
	
}
