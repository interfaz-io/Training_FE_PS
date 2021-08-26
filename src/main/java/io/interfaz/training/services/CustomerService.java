/**
 * 
 */
package io.interfaz.training.services;

import java.util.Iterator;
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
	private CustomerDAO customerDAO;
	
	public List<Customers> getAllCustomer() {
		return customerDAO.getAll();		
	}
	
	public Customers getCustomer(int id) {
		return customerDAO.getById(id);
	}
	
	public Customers addCustomer(Customers customer) {
		return customerDAO.createCustomer(customer);
	}
	public Customers getCustomerByEmail(String email) {
		return customerDAO.getByEmail(email);

	}
	
}
