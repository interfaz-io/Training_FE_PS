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

import io.interfaz.training.pojos.Orders;
import reactor.core.publisher.Mono;

/**
 * @author María
 *
 */

@Component
public class OrderDAO {
	private final WebClient client;

	public OrderDAO(WebClient.Builder builder) {
		this.client = builder.baseUrl("http://be-training.us-east-1.elasticbeanstalk.com").build();
	}

	public List<Orders> getAll() {
		Mono<Orders[]> pdt = this.client.get().uri("/orders").accept(MediaType.APPLICATION_JSON).retrieve()
				.bodyToMono(Orders[].class);
		return Arrays.asList(pdt.block());
	}

	public Orders getById(int id) {
		return this.client.get().uri("/orders/" + id).accept(MediaType.APPLICATION_JSON).retrieve()
				.bodyToMono(Orders.class).block();
	}

	public Orders createOrder(Orders order) {
		return this.client.post().uri("/orders").header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
				.body(Mono.just(order), Orders.class).retrieve().bodyToMono(Orders.class).block();
	}

	public Orders updateOrder(int id, Orders order) {
		return this.client.patch().uri("/orders/" + id)
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE).body(Mono.just(order), Orders.class)
				.retrieve().bodyToMono(Orders.class).block();
	}
	
	public  List<Orders> orderByCustomer (int id) {
		Mono<Orders[]> pdt = this.client.get().uri("/orders/customer/" + id).accept(MediaType.APPLICATION_JSON).retrieve()
				.bodyToMono(Orders[].class);
		return Arrays.asList(pdt.block());
	}

}
