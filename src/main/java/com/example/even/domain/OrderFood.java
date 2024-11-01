package com.example.even.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.RequiredArgsConstructor;

@Entity
@RequiredArgsConstructor
public class OrderFood {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderFoodId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "food_id")
    private Food food;

    private Integer quantity;

    public void addOrder(Order order){
        this.order = order;
        order.getOrderFoodList().add(this);
    }
}
