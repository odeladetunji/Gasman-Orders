package com.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "orders")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long Id;

    @Column(name = "order_options")
    public String orderOption;

    @Column(name = "gasSize")
    public double gasSize;

    @Column(name = "quantity")
    public int quantity;

    @Column(name = "amount")
    public int amount;

    @Column(name = "deliveryAddress")
    public String deliveryAddress;

    public Orders(){}

}
