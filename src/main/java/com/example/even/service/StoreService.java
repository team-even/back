package com.example.even.service;

import com.example.even.domain.StoreCategory;
import com.example.even.dto.StoreRequestDTO;
import com.example.even.dto.StoreRequestDTO.store;
import com.example.even.repository.StoreRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class StoreServiceImpl {
    private final StoreRepository storeRepository;

    @Override
    @Transactional
    public List<StoreRequestDTO.store>  getStoreListByStoreCategory(StoreCategory storeCategory){
        return storeRepository.findAllByStoreCategory(storeCategory);
    }

}
