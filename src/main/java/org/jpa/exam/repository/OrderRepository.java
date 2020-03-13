package org.jpa.exam.repository;

import org.jpa.exam.domain.Order;
import org.jpa.exam.dto.SimpleOrderQueryDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query("SELECT o FROM Order o JOIN FETCH o.member m JOIN FETCH o.delivery d")
    List<Order> findAllWithMemberDelivery();

    @Query("SELECT new org.jpa.exam.dto.SimpleOrderQueryDto(o.id, m.name, o.orderDate, o.status, d.address) " +
            "FROM Order o " +
            "JOIN o.member m " +
            "JOIN o.delivery d")
    List<SimpleOrderQueryDto> findOrderDtos();

    // DISTINCT: DB의 DISTINCT +
    @Query("SELECT DISTINCT o FROM Order o " +
            "JOIN FETCH o.member m " +
            "JOIN FETCH o.delivery d " +
            "JOIN FETCH  o.orderItems oi " +
            "JOIN FETCH oi.item i")
    List<Order> findAllWithItem();
}
