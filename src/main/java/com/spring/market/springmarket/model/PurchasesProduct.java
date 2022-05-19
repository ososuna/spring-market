package com.spring.market.springmarket.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "compras_productos")
@Getter
@Setter
@NoArgsConstructor
public class PurchasesProduct {

  @EmbeddedId
  private PurchasesProductPK id;

  @Column(name = "cantidad")
  private Integer quantity;

  @Column(name = "total")
  private Double total;

  @Column(name = "estado")
  private boolean active;

  @ManyToOne
  @JoinColumn(
    name = "id_compra",
    insertable = false,
    updatable = false
  )
  private Purchase purchase;

  @ManyToOne
  @JoinColumn(
    name = "id_producto",
    insertable = false,
    updatable = false
  )
  private Product product;

}
