package com.example.even.dto;

import com.example.even.dto.FoodDto.FoodInfo;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class StoreDto {

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class StoreGetRequest {
        private Double latitude;
        private Double longitude;
        private Integer zoomRatio;       //확대 비율
//        private Integer storeType;
    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class StoreResponse {
        private String storeName;
        private String detailInformation;
        private String storeImageUrl;
        private List<FoodInfo> foodInfoList;
    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class StoreGetResponse {
        private String storeName;
        private String multiUseContainerAvailable;
        private String detailInformation;
        private List<FoodInfo> foodDtoList;
    }


}
