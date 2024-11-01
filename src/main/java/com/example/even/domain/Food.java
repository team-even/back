package com.example.even.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Builder
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long foodId;

    private String name;

    private Integer price;

    private Float discountRate;

    private String foodImageUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private Store store;
}
