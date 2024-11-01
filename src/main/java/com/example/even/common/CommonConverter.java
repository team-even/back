package com.example.even.common;

import com.example.even.domain.Food;
import com.example.even.domain.Member;
import com.example.even.domain.Order;
import com.example.even.domain.OrderFood;
import com.example.even.domain.Store;
import com.example.even.dto.FoodDto.FoodInfo;
import com.example.even.dto.FoodDto.FoodInfoHistory;
import com.example.even.dto.OrderDto.OrderHistory;
import com.example.even.dto.StoreDto;
import com.example.even.dto.StoreDto.StoreGetResponse;
import java.util.ArrayList;
import java.util.List;

public class CommonConverter {

    public static Order toOrder(Member member, Store store) {
        return Order.builder()
                .member(member)
                .build();
    }

    public static OrderFood toOrderFood(Order order, Food food, Integer quantity) {
        return OrderFood.builder()
                .order(order)
                .food(food)
                .quantity(quantity)
                .build();
    }
//    public static Food toFood(Order order, List<Food> foodList) {
//    }

    public static StoreGetResponse toStoreGetResponse(Store store) {
        List<FoodInfo> foodDtoList = store.getFoodList().stream()
                .map(CommonConverter::toFoodInfo)
                .toList();

        return StoreDto.StoreGetResponse.builder()
                .storeName(store.getStoreName())
                .detailInformation(store.getDetailInformation())
                .multiUseContainerAvailable(store.isHasMultiUseContainer() ? "다회용기 제공" : "다회용기 지참")
                .foodDtoList(foodDtoList)
                .build();
    }

    public static FoodInfo toFoodInfo(Food food) {
        return FoodInfo.builder()
                .foodId(food.getFoodId())
                .foodName(food.getFoodName())
                .discountRate(food.getDiscountRate())
                .foodImageUrl(food.getFoodImageUrl())
                .price(food.getPrice())
                .build();
    }

    public static FoodInfoHistory toFoodInfoHistory(Food food) {
        return FoodInfoHistory.builder()
                .foodId(food.getFoodId())
                .foodName(food.getFoodName())
                .foodImageUrl(food.getFoodImageUrl())
                .price(food.getPrice())
                .build();
    }

    public static List<FoodInfoHistory> toFoodInfoList(List<OrderFood> orderFoodList) {
        List<FoodInfoHistory> foodInfoHistory = new ArrayList<>();

        for (OrderFood orderFood : orderFoodList) {
            FoodInfoHistory result = toFoodInfoHistory(orderFood.getFood());
            foodInfoHistory.add(result);
        }

        return foodInfoHistory;
    }

    public static OrderHistory toOrderHistory(Order order) {
        List<FoodInfoHistory> foodInfoHistoryList = order.getOrderFoodList().stream()
                .map(orderFood -> {
                    return CommonConverter.toFoodInfoHistory(orderFood.getFood());
                })
                .toList();

        return OrderHistory.builder()
                .orderId(order.getOrderId())
                .orderCategory(order.getOrderCategory().getName())
                .storeName(order.getStore().getStoreName())
                .foodInfoHistoryList(foodInfoHistoryList)
                .build();
    }
}
