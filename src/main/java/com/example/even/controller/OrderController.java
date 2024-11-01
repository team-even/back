package com.example.even.controller;

import com.example.even.dto.OrderDto;
import com.example.even.dto.OrderDto.OrderHistory;
import com.example.even.service.OrderService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping
public class OrderController {
    private final OrderService orderService;

    @PostMapping("/order")
    public Map<String, Object> createOrder(@RequestBody OrderDto.OrderRequest orderDto) {
        Map<String, Object> map = new HashMap<>();
        orderService.createOrder(orderDto);
        map.put("result:", "성공적으로 주문이 완료되었습니다.");
        return map;
    }

    @GetMapping("/orders")
    public List<OrderHistory> getOrderList(Long memberId) {
        return orderService.getOrderList(memberId);
    }
}
