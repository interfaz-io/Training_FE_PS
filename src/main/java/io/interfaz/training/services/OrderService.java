/**
 * 
 */
package io.interfaz.training.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.interfaz.training.daos.OrderDAO;
import io.interfaz.training.pojos.Orders;
import io.interfaz.training.pojos.Products;

/**
 * @author Nacho
 *
 */
@Service
public class OrderService {
	@Autowired
	private OrderDAO orderDAO;
	
	public List<Orders> getAllOrder() {
		return orderDAO.getAll();		
	}
	
	public Orders getProduct(int id) {
		return orderDAO.getById(id);
	}
	
	public Orders addProduct(Orders product) {
		return orderDAO.createOrder(product);
	}
	
	public Orders modifyProduct(int id, Orders product) {
		return orderDAO.updateOrder(id, product);
	}
}
