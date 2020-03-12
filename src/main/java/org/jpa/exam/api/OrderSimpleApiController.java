package org.jpa.exam.api;

import lombok.RequiredArgsConstructor;
import org.jpa.exam.domain.Order;
import org.jpa.exam.repository.OrderRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/*
    xToOne
    Order
    Order -> Member
    Order - Delivery
*/
@RestController
@RequiredArgsConstructor
public class OrderSimpleApiController {

    private final OrderRepository orderRepository;

    // 엔티티를 직접 노출
    @GetMapping("/api/vi/simple-orders")
    public List<Order> orderV1() {
        List<Order> all = orderRepository.findAll();
        return all;
    }




}
