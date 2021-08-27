/**
 * 
 */
package io.interfaz.training.pojos;

import java.util.ArrayList;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author María
 *
 */

@Data
//@AllArgsConstructor
@NoArgsConstructor
public class Customers {

	private Integer id;
	
	@NotBlank(message = "El Primer Nombre del cliente es requerido")
	private String firstName;
	
	@NotBlank(message = "Los Apellidos del cliente es requerido")
	private String lastName;
	
	@NotBlank(message = "El Email del cliente es requerido")
	private String email;
	
	@NotNull(message = "El Numero de Pais del cliente es requerido")
	private Integer countryID;
	
	private String status;

	private ArrayList<Orders> orders;
}
