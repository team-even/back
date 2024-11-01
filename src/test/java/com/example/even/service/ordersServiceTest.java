package com.example.even.service;

import com.example.even.domain.Food;
import com.example.even.domain.Member;
import com.example.even.domain.Order;
import com.example.even.domain.OrderFood;
import com.example.even.domain.Store;
import com.example.even.dto.OrderDto.FoodInfo;
import com.example.even.dto.OrderDto.OrderHistory;
import com.example.even.dto.OrderDto.OrderRequest;
import com.example.even.repository.FoodRepository;
import com.example.even.repository.MemberRepository;
import com.example.even.repository.OrderFoodRepository;
import com.example.even.repository.OrderRepository;
import com.example.even.repository.StoreRepository;
import jakarta.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
class ordersServiceTest {
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

    @Autowired
    OrderService orderService;

    @Autowired
    EntityManager em;



    // TODO: 테스트 분리
    @Test
    @Transactional
    void 주문목록_생성_조회_테스트() {
        // given
        Member member = memberRepository.save(Member.builder()
                .name("member")
                .email("email")
                .build());

        Store store = Store.builder()
                .storeName("store")
                .build();

        Food food1 = Food.builder()
                .price(123)
                .foodName("food1")
                .build();

        Food food2 = Food.builder()
                .price(1234)
                .foodName("food2")
                .build();

        food1.addStore(store);
        food2.addStore(store);
        
        storeRepository.save(store);

        FoodInfo f1 = FoodInfo.builder()
                .foodId(food1.getFoodId())
                .quantity(1)
                .build();

        ArrayList<FoodInfo> foodInfoList1 = new ArrayList<>();

        foodInfoList1.add(f1);

        OrderRequest dto1 = OrderRequest.builder()
                .memberId(member.getMemberId())
                .storeId(store.getStoreId())
                .FoodInfo(foodInfoList1)
                .build();

        FoodInfo f2 = FoodInfo.builder()
                .foodId(food2.getFoodId())
                .quantity(1)
                .build();

        ArrayList<FoodInfo> foodInfoList2 = new ArrayList<>();
        foodInfoList2.add(f2);

        OrderRequest dto2 = OrderRequest.builder()
                .memberId(member.getMemberId())
                .storeId(store.getStoreId())
                .FoodInfo(foodInfoList2)
                .build();

        // whne
        orderService.createOrder(dto1);
        orderService.createOrder(dto2);



        // then
        em.flush();
        em.clear();
        List<OrderFood> orderFoodList = orderFoodRepository.findAll();
        Assertions.assertThat(orderFoodList.size()).isEqualTo(2);

        List<OrderHistory> orderHistoryList = orderService.getOrderList(member.getMemberId());
        Assertions.assertThat(orderHistoryList.size()).isEqualTo(2);
    }

}