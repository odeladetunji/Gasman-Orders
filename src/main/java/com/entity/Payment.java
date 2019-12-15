package com.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    public Long id;

    @Column(name = "ccv")
    public int ccv;

    @Column(name = "card_number")
    public Long cardNumber;

    @Column(name = "pin")
    public int pin;

    public Payment(){ }

}
