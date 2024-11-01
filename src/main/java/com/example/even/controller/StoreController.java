package com.example.even.controller;

import com.example.even.dto.StoreDto.StoreGetRequest;
import com.example.even.dto.StoreDto.StoreGetResponse;
import com.example.even.service.StoreService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class StoreController {
    private final StoreService storeService;


    /**
     * 지도상의 가게들을 가져옵니다.
     * TODO: 위경도를 받아 리턴하도록 수정
     * @param storeGetRequest
     * @return
     */
    @GetMapping("/stores")
    public List<StoreGetResponse> getStoreList(StoreGetRequest storeGetRequest) {
        return storeService.getStoreList(storeGetRequest);
    }
}
