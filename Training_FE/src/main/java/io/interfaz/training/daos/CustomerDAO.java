/**
 * 
 */
package io.interfaz.training.daos;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;


import io.interfaz.training.pojos.Customers;
import io.interfaz.training.pojos.CustomersDTO;
import reactor.core.publisher.Mono;

/**
 * @author María
 *
 */
@Component
public class CustomerDAO {
	private final WebClient client;

	public CustomerDAO (WebClient.Builder builder) {
		this.client = builder.baseUrl("http://localhost:9080").build();
	}
	
	public List<Customers> getAll() {
		Mono<CustomersDTO> pdt= this.client.get().uri("/people").accept(MediaType.APPLICATION_JSON)
		 .retrieve()
	     .bodyToMono(CustomersDTO.class);
		return pdt.block().get_embedded().getCustomer();
		
}
//
}