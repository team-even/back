package com.example.even.repository;

import com.example.even.domain.Store;
import com.example.even.domain.StoreType;
import java.util.List;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface StoreRepository extends JpaRepository<Store, Long> {

    // 전체 가게 불러오기
    List<Store> findAll();
    // 유형별 가게 불러오기

    @Query("select s from Store s where s.latitude >= :lLat and s.latitude <= :rLat and s.longitude >= :lLon and s.longitude <= :rLon")
    List<Store> findStoresWithinBounds(double lLat, double lLon, double rLat, double rLon);

    @Query("select s from Store s where s.latitude >= :lLat and s.latitude <= :rLat and s.longitude >= :lLon and s.longitude <= :rLon and s.storeType = :filter")
    List<Store> findStoresWithinBoundsAndFilter(double lLat, double lLon, double rLat, double rLon, StoreType filter);

    List<Store> findAllByStoreType(@Param("storeType") StoreType storeType);

    @EntityGraph(attributePaths = {"foodList"})
    default Store safeFindById(Long storeId) {
        return findById(storeId).orElseThrow();
    }
}
