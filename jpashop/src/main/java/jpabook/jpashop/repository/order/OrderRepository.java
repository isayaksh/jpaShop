package jpabook.jpashop.repository.order;

import jpabook.jpashop.domain.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long>, OrderRepositoryJpql {

    Optional<Order> findById(Long id);

}
