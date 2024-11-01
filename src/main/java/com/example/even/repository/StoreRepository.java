package com.example.even.repository;

import com.example.even.domain.Member;
import com.example.even.domain.Store;

import com.example.even.domain.StoreCategory;
import com.example.even.dto.StoreRequestDTO;
import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface StoreRepository extends JpaRepository<Store, Long> {

    // 전체 가게 불러오기
    List<Store> findAll();

    // 유형별 가게 불러오기
    List<Store> findAllByStoreCategory(@Param("storeCategory")StoreCategory storeCategory);

    @EntityGraph(attributePaths = {"foodList"})
    default Store safeFindById(Long storeId) {
        return findById(storeId).orElseThrow();
    }

}
