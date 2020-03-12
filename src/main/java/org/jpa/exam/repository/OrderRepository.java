package org.jpa.exam.repository;

import org.jpa.exam.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query("SELECT o FROM Order o JOIN FETCH o.member m JOIN FETCH o.delivery d")
    List<Order> findAllWithMemberDelivery();
}
