package com.spring.market.springmarket.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "clientes")
public class Client {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_producto")
  private Integer id;

  @Column(name = "nombre")
  private String name;

  @Column(name = "apellidos")
  private String lastName;

  @Column(name = "celular")
  private String cellPhone;

  @Column(name = "direccion")
  private String address;

  @Column(name = "correo_electronico")
  private String email;

  @OneToMany(mappedBy = "client")
  private List<Purchase> purchases;

}
