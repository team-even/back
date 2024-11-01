package com.example.even;

import com.example.even.domain.Food;
import com.example.even.domain.Store;
import com.example.even.repository.FoodRepository;
import com.example.even.repository.MemberRepository;
import com.example.even.repository.OrderFoodRepository;
import com.example.even.repository.OrderRepository;
import com.example.even.repository.StoreRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class AddDummy {
    @Autowired
    MemberRepository memberRepository;

    @Autowired
    FoodRepository foodRepository;

    @Autowired
    StoreRepository storeRepository;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderFoodRepository orderFoodRepository;

    @Test
    @Transactional
    @Rollback(value = false)
    void 더미추가() {
        for (int j = 0; j < 10; j++) {
            Store store = storeRepository.save(Store.builder()
                    .storeName("가게" + j)
                    .detailInformation("가게 상세 설명입니다.")
                    .latitude(32.123123f)
                    .longitude(127.123123f)
                    .hasMultiUseContainer(true)
                    .storeImageUrl("http://store.png")
                    .build());

            for (int i = 0; i < 5; i++) {
                Food food = foodRepository.save(Food.builder()
                        .price(10000 + i)
                        .discountRate(10.0f)
                        .foodName("음식 이름" + i)
                        .foodImageUrl("http://food" + i + ".png")
                        .build());

                food.addStore(store);
            }
        }
    }
}
