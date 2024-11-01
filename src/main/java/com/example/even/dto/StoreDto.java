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
        private Float latitude;
        private Float longitude;
        private Float magnificationRatio;       //확대 비율
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
