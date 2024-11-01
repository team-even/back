package com.example.even.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
<<<<<<< HEAD

import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PROTECTED)
=======
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
>>>>>>> 4e798fead049ab886d0310ad95d0179083781cd2
@Getter
@Builder
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long storeId;

    private String storeName;

    private Double latitude;

    private Double longitude;

    private String detailInformation;

    private String storeImageUrl;

    @Builder.Default
    private boolean hasMultiUseContainer = false;       // t = 다회용기 제공 업체

    @Builder.Default
    private StoreType storeType = StoreType.NORMAL;

    @Builder.Default
    @OneToMany(mappedBy = "store", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Food> foodList = new ArrayList<>();

}
