/**
 * 
 */
package io.interfaz.training.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.interfaz.training.daos.OrderDetailDAO;
import io.interfaz.training.pojos.OrdersDetails;

/**
 * @author Nacho
 *
 */
@Service
public class OrderDetailsService {

	@Autowired
	private OrderDetailDAO orderDetail;
	
	public List<OrdersDetails> getAllOrderDetails() {
		return orderDetail.getAll();		
	}
}
