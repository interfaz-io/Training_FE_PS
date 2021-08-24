/**
 * 
 */
package io.interfaz.training.daos;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import io.interfaz.training.dto.CustomersDTO;
import io.interfaz.training.pojos.Customers;
import reactor.core.publisher.Mono;

/**
 * @author María
 *
 */
@Component
public class CustomerDAO {
	private final WebClient client;

	public CustomerDAO(WebClient.Builder builder) {
		this.client = builder.baseUrl("http://localhost:9080").build();
	}

	public List<Customers> getAll() {
		Mono<CustomersDTO> pdt = this.client.get().uri("/customers").accept(MediaType.APPLICATION_JSON).retrieve()
				.bodyToMono(CustomersDTO.class);
		return pdt.block().get_embedded().getCustomer();

	}
	
	public Customers getById(int id) {
		return this.client.get().uri("/customers/" + id).accept(MediaType.APPLICATION_JSON).retrieve()
				.bodyToMono(Customers.class).block();
	}
	
	public Customers createCustomer(Customers customer) {
		return this.client.post().uri("/customers").header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE).body(Mono.just(customer), Customers.class).retrieve().bodyToMono(Customers.class).block();
	}

}
