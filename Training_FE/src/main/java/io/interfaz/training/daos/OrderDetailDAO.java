/**
 * 
 */
package io.interfaz.training.daos;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import io.interfaz.training.dto.OrderDetailsDTO;
import io.interfaz.training.pojos.OrdersDetails;
import reactor.core.publisher.Mono;

/**
 * @author María
 *
 */

@Component
public class OrderDetailDAO {
	private final WebClient client;

	public OrderDetailDAO (WebClient.Builder builder) {
		this.client = builder.baseUrl("http://localhost:9080").build();
	}
	
	public List<OrdersDetails> getAll() {
		Mono<OrderDetailsDTO> pdt= this.client.get().uri("/people").accept(MediaType.APPLICATION_JSON)
		 .retrieve()
	     .bodyToMono(OrderDetailsDTO.class);
		return pdt.block().get_embedded().getOrdersDetails();
		
}
}
