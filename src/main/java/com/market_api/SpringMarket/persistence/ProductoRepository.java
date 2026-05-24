package com.market_api.SpringMarket.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.market_api.SpringMarket.domain.Product;
import com.market_api.SpringMarket.domain.repository.ProductRepository;
import com.market_api.SpringMarket.persistence.crud.ProductoCrudRepository;
import com.market_api.SpringMarket.persistence.entity.Producto;
import com.market_api.SpringMarket.persistence.mapper.ProductMapper;

@Repository
public class ProductoRepository implements ProductRepository {
    @Autowired
    private ProductoCrudRepository productoCrudRepository;

    @Autowired
    private ProductMapper mapper;

    @Override
    public List<Product> getAll() {
        List<Producto> productos = (List<Producto>) productoCrudRepository.findAll();
        return mapper.toProducts(productos);
    }

    @Override
    public Optional<List<Product>> getByCategory(int categoryId) {
        List<Producto> productos = productoCrudRepository.findByIdCategoriaOrderByNombreAsc(categoryId);
        return Optional.of(mapper.toProducts(productos));
    }

    @Override
    public Optional<Product> getProduct(int idProducto) {
        return productoCrudRepository.findById(idProducto).map(producto -> mapper.toProduct(producto));
    }

    @Override
    public Product save(Product product) {
        Producto producto = mapper.toProducto(product);
        return mapper.toProduct(productoCrudRepository.save(producto));
    }

    @Override
    public void delete(int idProducto) {
        productoCrudRepository.deleteById(idProducto);
    }

    @Override
    public Optional<List<Product>> getScarseProducts(int quantity) {
        Optional<List<Producto>> productos = productoCrudRepository.findByCantidadStockLessThanAndEstado(quantity,
                true);
        return productos.map(prods -> mapper.toProducts(prods));
    }

}
