package org.jpa.exam.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.jpa.exam.domain.Address;
import org.jpa.exam.domain.OrderStatus;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class SimpleOrderQueryDto {
    private Long orderId;
    private String name;
    private LocalDateTime orderDate;
    private OrderStatus orderStatus;
    private Address address;
}