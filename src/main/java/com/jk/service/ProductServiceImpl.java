package com.jk.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jk.entity.ProductEntity;
import com.jk.repo.ProductRepo;

@Service
public class ProductServiceImpl implements ProductService {

	private ProductRepo productRepo;

	public ProductServiceImpl(ProductRepo productRepo) {
		this.productRepo = productRepo;
	}

	@Override
	public String addProduct(ProductEntity productEntity) {
		ProductEntity save = productRepo.save(productEntity);
		return save.getId() != null ? "Success" : "Error";
	}

	@Override
	public List<ProductEntity> getAllProducts() {
		return productRepo.findAll();
	}

	@Override
	public ProductEntity getProductById(Integer id) {
		return productRepo.findById(id).orElse(null);
	}

	@Override
	public String deleteById(Integer id) {
		productRepo.deleteById(id);
		return "Success";
	}

	@Override
	public String addProducts(List<ProductEntity> entities) {
		productRepo.saveAll(entities);
		return "Success";
	}

}
