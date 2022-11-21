package jpabook.jpashop.repository.order;

import jpabook.jpashop.domain.Order;
import jpabook.jpashop.repository.OrderSearch;

import java.util.List;

public interface OrderRepositoryJpql {
    List<Order> findAll(OrderSearch orderSearch);
}
