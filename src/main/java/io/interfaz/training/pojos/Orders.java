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
	private BigDecimal subtotal;
	private BigDecimal iva;
	private BigDecimal total;
	
	
	public Orders(int id, Date purchaseDate, int customerId, BigDecimal subtotal, BigDecimal iva) {
		this.id = id;
		this.purchaseDate = purchaseDate;
		this.customerId = customerId;
		this.subtotal = subtotal;
		this.iva = iva;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Date getPurchaseDate() {
		return purchaseDate;
	}


	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}


	public int getCustomerId() {
		return customerId;
	}


	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}


	public BigDecimal getSubtotal() {
		return subtotal;
	}


	public void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}


	public BigDecimal getIva() {
		return iva;
	}


	public void setIva(BigDecimal iva) {
		this.iva = iva;
	}


	public BigDecimal getTotal() {
		return total;
	}


	public void setTotal(BigDecimal total) {
		this.total = total;
	}
	
//	public String dateFormat () {
//		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
//		String formatDateTime = purchaseDate.format(format);
//		return formatDateTime;
//		
//	}
	public BigDecimal totalIva() {
		BigDecimal resultado= subtotal.multiply(iva);
		return subtotal.add(resultado) ;
	}
	
	
}
