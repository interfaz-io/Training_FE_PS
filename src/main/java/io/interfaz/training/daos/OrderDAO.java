/**
 * 
 */
package io.interfaz.training.daos;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import io.interfaz.training.dto.OrdersDTO;
import io.interfaz.training.pojos.Orders;
import io.interfaz.training.pojos.Products;
import reactor.core.publisher.Mono;

/**
 * @author María
 *
 */

@Component
public class OrderDAO {
	private final WebClient client;

	public OrderDAO(WebClient.Builder builder) {
		this.client = builder.baseUrl("http://localhost:9080").build();
	}

	public List<Orders> getAll() {
		Mono<OrdersDTO> pdt = this.client.get().uri("/orders").accept(MediaType.APPLICATION_JSON).retrieve()
				.bodyToMono(OrdersDTO.class);
		return pdt.block().get_embedded().getOrder();

	}
	
	public Orders getById(int id) {
		return this.client.get().uri("/orders/" + id).accept(MediaType.APPLICATION_JSON).retrieve()
				.bodyToMono(Orders.class).block();
	}
	
	public Orders createOrder(Orders order) {
		return this.client.post().uri("/orders").header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE).body(Mono.just(order), Orders.class).retrieve().bodyToMono(Orders.class).block();
	}
	
	public Orders updateOrder(int id, Orders order) {
		return this.client.patch().uri("/orders/"+id).header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE).body(Mono.just(order), Orders.class).retrieve().bodyToMono(Orders.class).block();
	}

}
