package org.jpa.exam.api;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.jpa.exam.domain.Address;
import org.jpa.exam.domain.Order;
import org.jpa.exam.domain.OrderStatus;
import org.jpa.exam.repository.OrderRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

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
    @GetMapping("/api/v1/simple-orders")
    public List<Order> orderV1() {
        List<Order> all = orderRepository.findAll();
        return all;
    }

    @GetMapping("/api/v2/simple-orders")
    public List<SimpleOrderDto> orderV2() {

        // N + 1의 문제 -> 1 + 회원 N + 배송 N
        List<Order> orders = orderRepository.findAll();

        return orders.stream()
                .map(SimpleOrderDto::new)
                .collect(Collectors.toList()) ;
    }

    @Data
    static class SimpleOrderDto {
        private Long orderId;
        private String name;
        private LocalDateTime orderDate;
        private OrderStatus orderStatus;
        private Address address;

        public SimpleOrderDto(Order order) {
            this.orderId = order.getId();
            this.name = order.getMember().getName(); //Lazy 초기화
            this.orderDate = order.getOrderDate();
            this.orderStatus = order.getStatus();
            this.address = order.getDelivery().getAddress(); //Lazy 초기화
        }
    }


}
