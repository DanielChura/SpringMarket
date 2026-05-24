package com.market_api.SpringMarket.persistence.crud;

import org.springframework.data.repository.CrudRepository;

import com.market_api.SpringMarket.persistence.entity.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> {
    List<Producto> findByIdCategoriaOrderByNombreAsc(Integer idCategoria);

    Optional<List<Producto>> findByCantidadStockLessThanAndEstado(int cantidadStock, boolean estado);
}
