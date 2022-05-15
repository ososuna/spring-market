package com.spring.market.springmarket.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class PurchasesProductPK implements Serializable {
  
  @Column(name = "id_compra")
  private Integer idPurchase;

  @Column(name = "id_producto")
  private Integer idProduct;

}
