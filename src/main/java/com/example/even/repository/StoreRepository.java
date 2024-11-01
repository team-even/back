package com.example.even.repository;

import com.example.even.domain.Member;
import com.example.even.domain.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store, Long> {
}
