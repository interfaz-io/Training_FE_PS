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
public class Products {
	private int id;
	private String name;
	private String description;
	private double price;
	private String status;

}
