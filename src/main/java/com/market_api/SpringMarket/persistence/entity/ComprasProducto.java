package com.market_api.SpringMarket.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "compras_productos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ComprasProducto {

    @Embedded
    private ComprasProductoPK id;

    @Column(name = "cantidad")
    private Integer cantidad;

    @Column(name = "total")
    private Double total;

    @Column(name = "estado")
    private boolean estado;

}
