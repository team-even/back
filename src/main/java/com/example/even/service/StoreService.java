package com.example.even.service;

import com.example.even.common.CommonConverter;
import com.example.even.domain.Store;
import com.example.even.dto.StoreDto.StoreGetRequest;
import com.example.even.dto.StoreDto.StoreGetResponse;
import com.example.even.repository.StoreRepository;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StoreService {
    private final StoreRepository storeRepository;

    public List<StoreGetResponse> getStoreList(StoreGetRequest storeGetRequest) {
        List<Store> storeList = storeRepository.findAll();

        List<StoreGetResponse> storeGetResponseList = new ArrayList<>();
        for (Store store : storeList) {
            StoreGetResponse storeGetResponse = CommonConverter.toStoreGetResponse(store);
            storeGetResponseList.add(storeGetResponse);
        }

        return storeGetResponseList;
    }
}
