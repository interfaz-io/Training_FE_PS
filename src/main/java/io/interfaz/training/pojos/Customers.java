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
@AllArgsConstructor
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

	public Customers(Integer id, String firstName, String lastName, String email, Integer countryID, String status,
			ArrayList<Orders> orders) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.countryID = countryID;
		this.status = status;
		this.orders = orders;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getCountryID() {
		return countryID;
	}

	public void setCountryID(Integer countryID) {
		this.countryID = countryID;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public ArrayList<Orders> getOrders() {
		return orders;
	}

	public void setOrders(ArrayList<Orders> orders) {
		this.orders = orders;
	}
	
	

}
