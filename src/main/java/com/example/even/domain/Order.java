package com.example.even.domain;

<<<<<<< HEAD:src/main/java/com/example/even/domain/Orders.java
import jakarta.persistence.*;
=======
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;
>>>>>>> 4e798fead049ab886d0310ad95d0179083781cd2:src/main/java/com/example/even/domain/Order.java
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
<<<<<<< HEAD:src/main/java/com/example/even/domain/Orders.java
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class Orders {
=======
@Table(name = "orders")
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Order {
>>>>>>> 4e798fead049ab886d0310ad95d0179083781cd2:src/main/java/com/example/even/domain/Order.java

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderId;

    @Builder.Default
    private OrderCategory orderCategory = OrderCategory.PROCESSING;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

<<<<<<< HEAD:src/main/java/com/example/even/domain/Orders.java
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private Store store;

=======
    @OneToMany
    @Builder.Default
    private List<OrderFood> orderFoodList = new ArrayList<>();
>>>>>>> 4e798fead049ab886d0310ad95d0179083781cd2:src/main/java/com/example/even/domain/Order.java
}
