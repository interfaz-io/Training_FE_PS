/**
 * 
 */
package io.interfaz.training.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.interfaz.training.daos.OrderDAO;
import io.interfaz.training.pojos.Orders;

/**
 * @author Nacho
 *
 */
@Service
public class OrderService {
	@Autowired
	private OrderDAO order;
	
	public List<Orders> getAllOrder() {
		return order.getAll();		
	}
}
