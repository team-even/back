package com.example.even.service;

import com.example.even.common.CommonConverter;
import com.example.even.common.GeometryUtils;
import com.example.even.domain.Store;
import com.example.even.domain.StoreType;
import com.example.even.dto.StoreDto;
import com.example.even.dto.StoreDto.StoreGetRequest;
import com.example.even.dto.StoreDto.StoreGetResponse;
import com.example.even.dto.StoreDto.StoreResponse;
import com.example.even.repository.StoreRepository;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class StoreService {
    private final StoreRepository storeRepository;

    @Transactional(readOnly = true)
    public StoreResponse getStoreOne(Long storeId) {
        Store store = storeRepository.safeFindById(storeId);
        return StoreDto.StoreResponse.builder()
                .storeName(store.getStoreName())
                .storeImageUrl(store.getStoreImageUrl())
                .detailInformation(store.getDetailInformation())
                .foodInfoList(store.getFoodList().stream()
                        .map(CommonConverter::toFoodInfo)
                        .toList())
                .build();
    }

    @Transactional
    public List<Store> getStoreListByStoreCategory(Integer storeType) {
        StoreType[] values = StoreType.values();
        StoreType filter = StoreType.ALL;
        for (StoreType value : values) {
            if(value.getCode() == storeType)
                filter = value;
        }

        return storeRepository.findAllByStoreType(filter);
    }


    @Transactional
    public List<StoreGetResponse> getStoreList(StoreGetRequest storeGetRequest) {
        Double latitude = storeGetRequest.getLatitude();
        Double longitude = storeGetRequest.getLongitude();
        Integer zoomRatio = storeGetRequest.getZoomRatio();
//        Integer storeType = storeGetRequest.getStoreType();

        // 좌하단 mapBounds[0] ~ mapBounds[1] 우상단 mapBounds[2] ~ mapBounds[3]
        double[] mapBounds = GeometryUtils.getMapBounds(latitude, longitude, zoomRatio);
        List<Store> storeList = new ArrayList<>();

//        StoreType[] values = StoreType.values();
//        StoreType filter = StoreType.ALL;
//        for (StoreType value : values) {
//            if(value.getCode() == storeType)
//                filter = value;
//        }

//        if(storeType == 0) {
            storeList  = storeRepository.findStoresWithinBounds(mapBounds[0], mapBounds[1], mapBounds[2],
                    mapBounds[3]);
//        }
//        else {
//            storeList = storeRepository.findStoresWithinBoundsAndFilter(mapBounds[0], mapBounds[1], mapBounds[2],
//                    mapBounds[3], filter);
//        }

        List<StoreGetResponse> storeGetResponseList = new ArrayList<>();
        for (Store store : storeList) {
            StoreGetResponse storeGetResponse = CommonConverter.toStoreGetResponse(store);
            storeGetResponseList.add(storeGetResponse);
        }

        return storeGetResponseList;
    }
}
