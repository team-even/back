package com.example.even.controller;

import com.example.even.domain.Store;
import com.example.even.domain.StoreType;
import com.example.even.dto.StoreDto;
import com.example.even.dto.StoreDto.StoreGetRequest;
import com.example.even.dto.StoreDto.StoreGetResponse;
import com.example.even.dto.StoreDto.StoreResponse;
import com.example.even.dto.StoreRequestDTO;
import com.example.even.repository.StoreRepository;
import com.example.even.service.StoreService;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class StoreController {
    private final StoreService storeService;


    /**
     * 지도상의 가게들을 가져옵니다.
     * TODO: 위경도를 받아 리턴하도록 수정
     * // TODO: 유형별 필터
     *
     * @param storeGetRequest
     * @return
     */
    @GetMapping("/stores")
    public List<StoreGetResponse> getStoreList(@RequestBody StoreGetRequest storeGetRequest) {
        return storeService.getStoreList(storeGetRequest);
    }

    // TODO: DTO 변환 시간이 부족행
    @GetMapping("/stores/{storeId}")
    public StoreResponse getStoreList(@PathVariable(name = "storeId") Long storeId) {
        return storeService.getStoreOne(storeId);
    }


    // 가게 유형별 불러오기
    @GetMapping("/category/{storeCategory}")
    public List<StoreRequestDTO.Store> getStoreListByStoreCategory(
            @PathVariable(name = "storeCategory") Integer storeType) {
        List<Store> storeList = storeService.getStoreListByStoreCategory(storeType);
        return storeList.stream()
                .map(store -> StoreRequestDTO.Store.builder()  // 빌더 패턴으로 객체 생성
                        .storeId(store.getStoreId())
                        .name(store.getStoreName())
                        .latitude(store.getLatitude())
                        .longitude(store.getLongitude())
                        .detailInformation(store.getDetailInformation())
                        .storeImageUrl(store.getStoreImageUrl())
                        .build())
                .collect(Collectors.toList());

    }

}
