package com.example.even.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class StoreRequestDTO {

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Store {
        private Long storeId;
        private String name;
        private Double latitude;
        private Double longitude;
        private String detailInformation;
        private String storeImageUrl;
    }
}