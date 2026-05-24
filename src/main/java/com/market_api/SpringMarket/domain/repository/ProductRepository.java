package com.market_api.SpringMarket.domain.repository;

import java.util.List;
import java.util.Optional;

import com.market_api.SpringMarket.domain.Product;

public interface ProductRepository {
    List<Product> getAll();

    Optional<List<Product>> getByCategory(int categoryId);

    Optional<List<Product>> getScarseProducts(int stock);

    Optional<Product> getProduct(int productId);

    Product save(Product product);

    void delete(int productId);
}
