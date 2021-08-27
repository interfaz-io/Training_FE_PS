/**
 * 
 */
package io.interfaz.training.daos;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

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
		this.client = builder.baseUrl("http://be-training.us-east-1.elasticbeanstalk.com").build();
	}

	public List<Customers> getAll() {
		Mono<Customers[]> pdt = this.client.get().uri("/customers").accept(MediaType.APPLICATION_JSON).retrieve()
				.bodyToMono(Customers[].class);
		return Arrays.asList(pdt.block());

	}

	public Customers getByEmail(String email) {
		Mono<Customers[]> pdt = this.client.get().uri("/customers/searchEmail/" + email)
				.accept(MediaType.APPLICATION_JSON).retrieve().bodyToMono(Customers[].class);
		return pdt.block()[0];
	}

	public Customers getById(int id) {
		return this.client.get().uri("/customers/" + id).accept(MediaType.APPLICATION_JSON).retrieve()
				.bodyToMono(Customers.class).block();
	}

	public Customers createCustomer(Customers customer) {
		return this.client.post().uri("/customers").header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
				.body(Mono.just(customer), Customers.class).retrieve().bodyToMono(Customers.class).block();
	}
	
	public Customers updateCustomer(int id,Customers customer) {
		return this.client.patch().uri("/customers/"+id)
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
				.body(Mono.just(customer),Customers.class)
				.retrieve()
				.bodyToMono(Customers.class)
				.block();
	}

}
