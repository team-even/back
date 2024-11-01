package com.example.even.service;

import com.example.even.common.CommonConverter;
import com.example.even.domain.Store;
import com.example.even.domain.StoreCategory;
import com.example.even.dto.StoreDto.StoreGetRequest;
import com.example.even.dto.StoreDto.StoreGetResponse;
import com.example.even.repository.StoreRepository;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class StoreService {
    private final StoreRepository storeRepository;

    @Transactional
    public List<Store> getStoreListByStoreCategory(StoreCategory storeCategory){
        return storeRepository.findAllByStoreCategory(storeCategory);
    }


     public List<StoreGetResponse> getStoreList(StoreGetRequest storeGetRequest) {
         List<Store> storeList = storeRepository.findAll();
         // TODO: 유형별 필터

         List<StoreGetResponse> storeGetResponseList = new ArrayList<>();
         for (Store store : storeList) {
             StoreGetResponse storeGetResponse = CommonConverter.toStoreGetResponse(store);
             storeGetResponseList.add(storeGetResponse);
         }

         return storeGetResponseList;
     }
}
