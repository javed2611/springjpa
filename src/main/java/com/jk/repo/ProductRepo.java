package com.jk.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jk.entity.ProductEntity;

public interface ProductRepo extends JpaRepository<ProductEntity, Integer>
{

}
