/**
 * 
 */
package io.interfaz.training.pojos;

import java.math.BigDecimal;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;

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

	public Products(Integer id, @NotBlank(message = "El nombre del producto es requerido") String name,
			@NotBlank(message = "La descripción del producto es requerido") String description,
			@NotNull(message = "El precio del producto es requerido") @Digits(integer = 18, fraction = 0, message = "Valor no soportado, máximo 18 dígitos") BigDecimal price,
			@NotBlank(message = "El estado del producto es requerido") String status) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.status = status;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
	
}
