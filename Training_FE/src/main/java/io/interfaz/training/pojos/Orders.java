/**
 * 
 */
package io.interfaz.training.pojos;




import java.util.Date;

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
	private Date purchaseDate;
	private int customerId;
	private double subtotal;
	private double iva;
	private double total;
}
