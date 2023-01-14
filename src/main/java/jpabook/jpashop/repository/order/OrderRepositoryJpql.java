package jpabook.jpashop.repository.order;

import jpabook.jpashop.domain.order.Order;

import java.util.List;

public interface OrderRepositoryJpql {
    List<Order> findAll(OrderSearch orderSearch);
}
