package com.example.even.service;

import com.example.even.domain.Store;
import com.example.even.domain.StoreCategory;
import com.example.even.dto.StoreRequestDTO;
import com.example.even.repository.StoreRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class StoreService {
    private final StoreRepository storeRepository;

//    @Transactional
//    public List<Store> getStoreList(float lon, float lat) {
//        return storeRepository.findAllByStoreCategory(storeCategory);
//    }

    @Transactional
    public List<Store> getStoreListByStoreCategory(StoreCategory storeCategory){
        return storeRepository.findAllByStoreCategory(storeCategory);
    }

    public List<Store> getStoreList() {
        return storeRepository.findAll();
    }
}
