package com.market_api.SpringMarket.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.market_api.SpringMarket.domain.Product;
import com.market_api.SpringMarket.domain.repository.ProductRepository;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAll() {
        return productRepository.getAll();
    };

    public Optional<Product> getProduct(int productId) {
        return productRepository.getProduct(productId);
    }

    public List<Product> getByCategory(int categoryId) {
        return productRepository.getByCategory(categoryId).orElse(java.util.Collections.emptyList());
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public boolean delete(int productId) {
        return productRepository.getProduct(productId).map(product -> {
            productRepository.delete(productId);
            return true;
        }).orElse(false);
    }
}