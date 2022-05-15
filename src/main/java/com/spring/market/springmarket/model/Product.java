package com.spring.market.springmarket.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "productos")
@Getter
@Setter
@NoArgsConstructor
public class Product {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_producto")
  private Integer id;

  @Column(name = "nombre")
  private String name;

  @Column(name = "id_categoria")
  private Integer category;

  @Column(name = "codigo_barras")
  private String code;

  @Column(name = "precio_venta")
  private Double price;

  @Column(name = "cantidad_stock")
  private Integer stock;

  @Column(name = "estado")
  private boolean active;

}
