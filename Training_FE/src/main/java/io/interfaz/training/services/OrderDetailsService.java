/**
 * 
 */
package io.interfaz.training.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.interfaz.training.daos.OrderDetailDAO;
import io.interfaz.training.pojos.OrdersDetails;
import io.interfaz.training.pojos.Products;

/**
 * @author Nacho
 *
 */
@Service
public class OrderDetailsService {

	@Autowired
	private OrderDetailDAO orderDetailDAO;
	
	public List<OrdersDetails> getAllOrderDetails() {
		return orderDetailDAO.getAll();		
	}
	
	
	public OrdersDetails getProduct(int id) {
		return orderDetailDAO.getById(id);
	}
	
	public OrdersDetails addProduct(OrdersDetails ordersDetail) {
		return orderDetailDAO.createOrderDetail(ordersDetail);
	}
	
	public OrdersDetails modifyProduct(int id, OrdersDetails ordersDetail) {
		return orderDetailDAO.updateOrderDetail(id, ordersDetail);
	}
}
