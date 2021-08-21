/**
 * 
 */
package io.interfaz.training.daos;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import io.interfaz.training.dto.OrdersDTO;
import io.interfaz.training.pojos.Orders;
import reactor.core.publisher.Mono;

/**
 * @author María
 *
 */


@Component
public class OrderDAO {
	private final WebClient client;

	public OrderDAO (WebClient.Builder builder) {
		this.client = builder.baseUrl("http://localhost:9080").build();
	}
	
	public List<Orders> getAll() {
		Mono<OrdersDTO> pdt= this.client.get().uri("/people").accept(MediaType.APPLICATION_JSON)
		 .retrieve()
	     .bodyToMono(OrdersDTO.class);
		return pdt.block().get_embedded().getOrder();
		
}

}
