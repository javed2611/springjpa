package com.jk.service;

import java.util.List;

import com.jk.entity.ProductEntity;

public interface ProductService {

	public String addProduct(ProductEntity productEntity);

	public List<ProductEntity> getAllProducts();

	public ProductEntity getProductById(Integer id);

	public String deleteById(Integer id);

	public String addProducts(List<ProductEntity> entities);

}
