/**
 * 
 */
package io.interfaz.training.daos;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;


import io.interfaz.training.pojos.ProductDTO;
import io.interfaz.training.pojos.Products;
import reactor.core.publisher.Mono;

/**
 * @author María
 *
 */
public class ProductDAO {
	private final WebClient client;

	public ProductDAO (WebClient.Builder builder) {
		this.client = builder.baseUrl("http://localhost:9080").build();
	}
	
	public List<Products> getAll() {
		Mono<ProductDTO> pdt= this.client.get().uri("/people").accept(MediaType.APPLICATION_JSON)
		 .retrieve()
	     .bodyToMono(ProductDTO.class);
		return pdt.block().get_embedded().getProduct();
		
}
}
