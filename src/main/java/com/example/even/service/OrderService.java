package com.example.even.service;

import com.example.even.common.CommonConverter;
import com.example.even.domain.Food;
import com.example.even.domain.Member;
import com.example.even.domain.Order;
import com.example.even.domain.OrderFood;
import com.example.even.domain.Store;
import com.example.even.dto.OrderDto.FoodInfo;
import com.example.even.dto.OrderDto.OrderHistory;
import com.example.even.dto.OrderDto.OrderRequest;
import com.example.even.repository.MemberRepository;
import com.example.even.repository.OrderFoodRepository;
import com.example.even.repository.OrderRepository;
import com.example.even.repository.StoreRepository;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final MemberRepository memberRepository;
    private final StoreRepository storeRepository;
    private final OrderFoodRepository orderFoodRepository;

    @Transactional
    public void createOrder(OrderRequest dto) throws Exception {
        Member member = memberRepository.safeFindById(dto.getMemberId());
        Store store = storeRepository.safeFindById(dto.getStoreId());
        List<Food> foodList = store.getFoodList();

        List<FoodInfo> foodInfo = dto.getFoodInfo();

        Order order = CommonConverter.toOrder(member, store);
        orderRepository.save(order);

        List<OrderFood> orderFoodList = new ArrayList<>();
        // TODO: 시가나면 리팩토링
        foodInfo.stream()
                .forEach(info -> {
                    for(Food food : foodList) {
                        if(food.getFoodId().equals(info.getFoodId())) {
                            OrderFood orderFood = CommonConverter.toOrderFood(order, food, info.getQuantity());
                            orderFood.addOrder(order);
                            orderFoodList.add(orderFood);
                        }
                    }
                });

        orderFoodRepository.saveAll(orderFoodList);
    }

    /**
     * 사용자의 주문 목록을 가져옵니다.
     * @param memberId
     */
    @Transactional
    public List<OrderHistory> getOrderList(Long memberId) throws Exception {
        Member member = memberRepository.safeFindById(memberId);
        List<Order> orderList = member.getOrderList();

        List<OrderHistory> orderHistoryList = new ArrayList<>();
        for (Order order : orderList) {
            OrderHistory orderHistory = CommonConverter.toOrderHistory(order);
            orderHistoryList.add(orderHistory);
        }

        return orderHistoryList;
    }
}
