/**
 * 
 */
package io.interfaz.training.pojos;

import java.math.BigDecimal;

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
public class OrdersDetails {
	 
	 private Integer id;
	 private int order;
	 private int productId;
	 private int quantity;
	 private BigDecimal price;
	 private int totalAmount; 
	 private Products products;
	public OrdersDetails(Integer id, int order, int productId, int quantity, BigDecimal price, int totalAmount,
			Products products) {
		super();
		this.id = id;
		this.order = order;
		this.productId = productId;
		this.quantity = quantity;
		this.price = price;
		this.totalAmount = totalAmount;
		this.products = products;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public int getOrder() {
		return order;
	}
	public void setOrder(int order) {
		this.order = order;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public int getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}
	public Products getProducts() {
		return products;
	}
	public void setProducts(Products products) {
		this.products = products;
	}
	 
	 
	 
}
