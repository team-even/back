package com.example.even.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderFood {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderFoodId;

    @ManyToOne(fetch = FetchType.LAZY)
<<<<<<< HEAD
    @JoinColumn(name = "orders_id")
    private Orders orders;
=======
    @JoinColumn(name = "order_id")
    private Order order;
>>>>>>> 4e798fead049ab886d0310ad95d0179083781cd2

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "food_id")
    private Food food;

    private Integer quantity;

    public void addOrder(Order order){
        this.order = order;
        order.getOrderFoodList().add(this);
    }
}
