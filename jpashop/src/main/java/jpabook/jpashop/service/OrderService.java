package jpabook.jpashop.service;

import jpabook.jpashop.domain.Delivery;
import jpabook.jpashop.domain.Member;
import jpabook.jpashop.domain.Order;
import jpabook.jpashop.domain.OrderItem;
import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.exception.NotCorrespondingItemException;
import jpabook.jpashop.exception.NotCorrespondingOrderException;
import jpabook.jpashop.repository.ItemRepository;
import jpabook.jpashop.repository.MemberRepository;
import jpabook.jpashop.repository.OrderRepository;
import jpabook.jpashop.repository.OrderSearch;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final MemberRepository memberRepository;
    private final ItemRepository itemRepository;

    // COMMENT 주문
    @Transactional
    public Long order(Long memberId, Long itemId, int count){
        // 엔티티 조회
        Member member = memberRepository.findById(memberId).get();
        Optional<Item> findItem = itemRepository.findById(itemId);
        Item item = findItem.orElseThrow(() -> new NotCorrespondingItemException("해당하는 아이템이 존재하지 않습니다."));

        // 배송정보 생성
        Delivery delivery = Delivery.createDelivery(member.getAddress());

        // 주문 상품 생성
        OrderItem orderItem = OrderItem.createOrderItem(item, item.getPrice(), count);

        // 주문 생성
        Order order = Order.createOrder(member, delivery, orderItem);

        // 주문 저장
        orderRepository.save(order);

        return order.getId();
    }

    // COMMENT 주문 취소
    @Transactional
    public void cancelOrder(Long orderId){
        // 엔티티 조회

        Optional<Order> findOrder = orderRepository.findById(orderId);
        Order order = findOrder.orElseThrow(() -> new NotCorrespondingOrderException("해당하는 주문이 존재하지 않습니다."));
        // 주문 취소
        order.cancel();
    }

    // 검색
    public List<Order> findOrders(OrderSearch orderSearch){
        return orderRepository.findAll(orderSearch);
    }
}
