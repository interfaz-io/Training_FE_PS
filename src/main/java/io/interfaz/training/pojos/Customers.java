/**
 * 
 */
package io.interfaz.training.pojos;

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
public class Customers {

	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private int countryID;
	private String status;

	private ArrayList<Orders> orders;

	
	  public Customers(int id, String firstName, String lastName, String email, int
	  countryId, String status, ArrayList<Orders> orders) { super(); this.id = id;
	  this.firstName = firstName; this.lastName = lastName; this.email = email;
	  this.countryID = countryId; this.status = status; this.orders = orders; }
	  
	  public int getId() { return id; }
	  
	  public void setId(int id) { this.id = id; }
	  
	  public String getFirstName() { return firstName; }
	  
	  public void setFirstName(String firstName) { this.firstName = firstName; }
	  
	  public String getLastName() { return lastName; }
	  
	  public void setLastName(String lastName) { this.lastName = lastName; }
	  
	  public String getEmail() { return email; }
	  
	  public void setEmail(String email) { this.email = email; }
	  
	  public int getCountryId() { return countryID; }
	  
	  public void setCountryId(int countryId) { this.countryID = countryId; }
	  
	  public String getStatus() { return status; }
	  
	  public void setStatus(String status) { this.status = status; }
	  
	  public ArrayList<Orders> getOrders() { return orders; }
	  
	  public void setOrders(ArrayList<Orders> orders) { this.orders = orders; }
	 
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public int getCountryId() {
		return countryID;
	}

	public void setCountryId(int countryId) {
		this.countryID = countryId;
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
