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
	
	  
	  
	  public Orders(Integer id, Date purchaseDate, int customerId, BigDecimal subtotal, BigDecimal iva,
			BigDecimal total) {
		super();
		this.id = id;
		this.purchaseDate = purchaseDate;
		this.customerId = customerId;
		this.subtotal = subtotal;
		this.iva = iva;
		this.total = total;
	}


	public int getId() { return id; }
	  
	  
	  public void setId(int id) { this.id = id; }
	  
	  
	  public Date getPurchaseDate() { return purchaseDate; }
	  
	  
	  public void setPurchaseDate(Date purchaseDate) { this.purchaseDate =
	  purchaseDate; }
	  
	  
	  public int getCustomerId() { return customerId; }
	  
	  
	  public void setCustomerId(int customerId) { this.customerId = customerId; }
	  
	  
	  public BigDecimal getSubtotal() { return subtotal; }
	  
	  
	  public void setSubtotal(BigDecimal subtotal) { this.subtotal = subtotal; }
	  
	  
	  public BigDecimal getIva() { return iva; }
	  
	  
	  public void setIva(BigDecimal iva) { this.iva = iva; }
	  
	  
	  public BigDecimal getTotal() { return total; }
	  
	  
	  public void setTotal(BigDecimal total) { this.total = total; }
	 

	
}
