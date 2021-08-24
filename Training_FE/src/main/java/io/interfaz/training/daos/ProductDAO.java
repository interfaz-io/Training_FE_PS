/**
 * 
 */
package io.interfaz.training.daos;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import io.interfaz.training.dto.ProductDTO;
import io.interfaz.training.pojos.Products;
import reactor.core.publisher.Mono;

/**
 * @author María
 *
 */

@Component
public class ProductDAO {
	private final WebClient client;

	public ProductDAO(WebClient.Builder builder) {
		this.client = builder.baseUrl("http://localhost:9080").build();
	}

	public List<Products> getAll() {
		Mono<ProductDTO> pdt = this.client.get().uri("/products").accept(MediaType.APPLICATION_JSON).retrieve()
				.bodyToMono(ProductDTO.class);
		return pdt.block().get_embedded().getProduct();

	}
	
	public Products getById(int id) {
		return this.client.get().uri("/products/" + id).accept(MediaType.APPLICATION_JSON).retrieve()
				.bodyToMono(Products.class).block();
	}
	
	public Products createProduct(Products product) {
		return this.client.post().uri("/products").header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE).body(Mono.just(product), Products.class).retrieve().bodyToMono(Products.class).block();
	}
	
	public Products updateProduct(int id, Products product) {
		return this.client.patch().uri("/products/"+id).header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE).body(Mono.just(product), Products.class).retrieve().bodyToMono(Products.class).block();
	}
}
