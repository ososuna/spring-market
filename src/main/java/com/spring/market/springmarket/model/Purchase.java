package com.spring.market.springmarket.model;

import java.time.LocalDateTime;

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
@Table(name = "compras")
@Getter
@Setter
@NoArgsConstructor
public class Purchase {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_compra")
  private Integer id;

  @Column(name = "cliente")
  private String idClient;

  @Column(name = "fecha")
  private LocalDateTime date;

  @Column(name = "medio_pago")
  private String paymentMethod;

  @Column(name = "comentario")
  private String comment;

  @Column(name = "estado")
  private String status;

}
