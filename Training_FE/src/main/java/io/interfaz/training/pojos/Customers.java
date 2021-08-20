/**
 * 
 */
package io.interfaz.training.pojos;

import com.fasterxml.jackson.annotation.JsonInclude;

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
public class Customers {
	
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private int countryId;
	private String status;
	
	
	

}
