/**
 * 
 */
package io.interfaz.training.daos;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import io.interfaz.training.dto.OrderDetailsDTO;
import io.interfaz.training.pojos.OrdersDetails;
import io.interfaz.training.pojos.Products;
import reactor.core.publisher.Mono;

/**
 * @author María
 *
 */

@Component
public class OrderDetailDAO {
	private final WebClient client;

	public OrderDetailDAO(WebClient.Builder builder) {
		this.client = builder.baseUrl("http://be-training.us-east-1.elasticbeanstalk.com").build();
	}

	public List<OrdersDetails> getAll() {
		Mono<OrderDetailsDTO> pdt = this.client.get().uri("/ordersDetails").accept(MediaType.APPLICATION_JSON).retrieve()
				.bodyToMono(OrderDetailsDTO.class);
		return pdt.block().get_embedded().getOrdersDetails();

	}
	
	public OrdersDetails getById(int id) {
		return this.client.get().uri("/ordersDetails/" + id).accept(MediaType.APPLICATION_JSON).retrieve()
				.bodyToMono(OrdersDetails.class).block();
	}
	
	public OrdersDetails createOrderDetail(OrdersDetails ordersDetail) {
		return this.client.post().uri("/ordersDetails").header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE).body(Mono.just(ordersDetail), OrdersDetails.class).retrieve().bodyToMono(OrdersDetails.class).block();
	}
	
	public OrdersDetails updateOrderDetail(int id, OrdersDetails ordersDetail) {
		return this.client.patch().uri("/ordersDetails/"+id).header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE).body(Mono.just(ordersDetail), OrdersDetails.class).retrieve().bodyToMono(OrdersDetails.class).block();
	}
}
