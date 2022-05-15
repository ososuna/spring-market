package com.spring.market.springmarket.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "compras")
@Getter
@Setter
@NoArgsConstructor
public class Purchase {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_compra")
  private Integer id;

  @Column(name = "fecha")
  private LocalDateTime date;

  @Column(name = "medio_pago")
  private String paymentMethod;

  @Column(name = "comentario")
  private String comment;

  @Column(name = "estado")
  private String status;

  @JoinColumn(
    name = "id_cliente",
    insertable = false,
    updatable = false
  )
  @ManyToOne
  private Client client;

  @OneToMany(mappedBy = "purchase")
  private List<PurchasesProduct> purchasesProducts;

}
