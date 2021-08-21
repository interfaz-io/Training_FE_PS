/**
 * 
 */
package io.interfaz.training.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.interfaz.training.daos.CustomerDAO;
import io.interfaz.training.pojos.Customers;


/**
 * @author Nacho
 *
 */
@Service
public class CustomerService {

	@Autowired
	private CustomerDAO customer;
	
	public List<Customers> getAllCustomer() {
		return customer.getAll();		
	}
}
