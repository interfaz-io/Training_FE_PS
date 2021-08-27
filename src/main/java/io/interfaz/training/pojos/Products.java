/**
 * 
 */
package io.interfaz.training.pojos;

import java.math.BigDecimal;

import javax.validation.constraints.Digits;
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
@AllArgsConstructor
@NoArgsConstructor
public class Products {
	
	
	private Integer id;
	
	@NotBlank(message = "El nombre del producto es requerido")
	private String name;
	
	@NotBlank(message = "La descripción del producto es requerido")
	private String description;
	
	@NotNull(message = "El precio del producto es requerido")
	@Digits(integer = 18, fraction = 0, message = "Valor no soportado, máximo 18 dígitos")
	private BigDecimal price;
	
	@NotBlank(message = "El estado del producto es requerido")
	private String status;
	
}
