package com.example.even.controller;

import com.example.even.domain.Store;
import com.example.even.domain.StoreCategory;
import com.example.even.dto.StoreRequestDTO;
import com.example.even.service.StoreService;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class StoreController {

    private final StoreService storeService;

    // 가게 전체 불러오기
    @GetMapping("/")
    public List<StoreRequestDTO.store> getStoreList() {
        List<Store> storeList = storeService.getStoreList();
        return storeList.stream().map(store -> StoreRequestDTO.store.builder()
                .storeId(store.getStoreId())
                .name(store.getName())
                .latitude(store.getLatitude())
                .longitude(store.getLongitude())
                .detailInformation(store.getDetailInformation())
                .storeImageUrl(store.getStoreImageUrl())
                .build())
                .collect(Collectors.toList());

    }

    // 가게 유형별 불러오기
    @GetMapping("/{storeCategory}")
    public List<StoreRequestDTO.store> getStoreListByStoreCategory(@PathVariable(name = "storeCategory") StoreCategory storeCategory) {
        List<Store> storeList = storeService.getStoreListByStoreCategory(storeCategory);
        return storeList.stream()
                .map(store -> StoreRequestDTO.store.builder()  // 빌더 패턴으로 객체 생성
                        .storeId(store.getStoreId())
                        .name(store.getName())
                        .latitude(store.getLatitude())
                        .longitude(store.getLongitude())
                        .detailInformation(store.getDetailInformation())
                        .storeImageUrl(store.getStoreImageUrl())
                        .build())
                .collect(Collectors.toList());

    }



}
