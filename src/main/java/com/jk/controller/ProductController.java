package com.jk.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jk.entity.ProductEntity;
import com.jk.service.ProductService;

@RestController
public class ProductController {

	private ProductService productService;

	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@PostMapping(value = "/saveproduct", consumes = "application/json", produces = "text/plain")
	public ResponseEntity<String> addProduct(@RequestBody ProductEntity entity) {
		String product = productService.addProduct(entity);
		return new ResponseEntity<>(product, HttpStatus.CREATED);
	}

	@PostMapping(value = "/saveall", consumes = "application/json", produces = "text/plain")
	public ResponseEntity<String> addProducts(@RequestBody List<ProductEntity> entities) {
		String products = productService.addProducts(entities);
		return new ResponseEntity<>(products, HttpStatus.OK);
	}

	@GetMapping(value = "/products", produces = "application/json")
	public ResponseEntity<List<ProductEntity>> listProduct() {
		List<ProductEntity> list = productService.getAllProducts();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@GetMapping(value = "/product", produces = "application/json")
	public ResponseEntity<ProductEntity> viewProduct(@RequestParam("id") Integer id) {
		ProductEntity msg = productService.getProductById(id);
		return new ResponseEntity<>(msg, HttpStatus.OK);
	}

	@GetMapping(value = "/delete", produces = "text/plain")
	public ResponseEntity<String> deleteProduct(@RequestParam("id") Integer id) {
		String msg = productService.deleteById(id);
		return new ResponseEntity<>(msg, HttpStatus.OK);
	}

	@PutMapping(value = "/update/{id}", produces = "text/plain", consumes = "application/json")
	public ResponseEntity<String> updateProduct(@PathVariable("id") Integer id, @RequestBody ProductEntity entity) {
		entity.setId(id);
		String msg = productService.addProduct(entity);
		return new ResponseEntity<>(msg, HttpStatus.OK);
	}

}
