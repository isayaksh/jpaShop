package jpabook.jpashop.service;

import jpabook.jpashop.domain.Address;
import jpabook.jpashop.domain.Member;
import jpabook.jpashop.domain.Order;
import jpabook.jpashop.domain.item.Book;
import jpabook.jpashop.exception.NotEnoughStockException;
import jpabook.jpashop.repository.OrderRepositoryOld;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static jpabook.jpashop.domain.OrderStatus.CANCEL;
import static jpabook.jpashop.domain.OrderStatus.ORDER;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class OrderServiceTest {
    
    @Autowired EntityManager em;
    @Autowired OrderService orderService;
    @Autowired
    OrderRepositoryOld orderRepository;
    
    @Test
    public void 상품주문() throws Exception {
        // given
        Member member = createMember();
        Book book = createBook();

        // when
        int orderCount = 2;
        Long orderId = orderService.order(member.getId(), book.getId(), orderCount);

        // then
        Order findOrder = orderRepository.findOne(orderId);
        assertEquals("상품 주문시 상태는 ORDER", ORDER, findOrder.getStatus());
        assertEquals("주문한 상품 종류 수가 정확해야 한다.", 1, findOrder.getOrderItems().size());
        assertEquals("주문 가격은 가격 * 수량이다.", 10000 * orderCount, findOrder.getTotalPrice());
        assertEquals("주문 수량만큼 재고가 줄어야 한다.", 10 - orderCount, book.getStockQuantity());


    }

    @Test
    public void 주문취소() throws Exception {
        // given
        Member member = createMember();
        Book book = createBook();
        int orderCount = 2;
        Long orderId = orderService.order(member.getId(), book.getId(), orderCount);

        // when
        orderService.cancelOrder(orderId);

        // then
        Order findOrder = orderRepository.findOne(orderId);
        assertEquals("상품 주문시 상태는 CANCEL", CANCEL, findOrder.getStatus());
        assertEquals("주문 수량만큼 재고가 늘어야 한다.", 10, book.getStockQuantity());
    }

    @Test
    public void 상품주문_재고수량초과() throws Exception {
        // given
        Member member = createMember();
        Book book = createBook();
        // when
        int orderCount = 11;
        try{
            orderService.order(member.getId(), book.getId(), orderCount);
        } catch (NotEnoughStockException e){
            return;
        }

        // then
        fail("예외가 발생해야 합니다.");
    }

    private Book createBook() {
        Book book = Book.createBook("JPA",10000,10,"김영한", "7531");
        em.persist(book);
        return book;
    }

    private Member createMember() {
        Member member = Member.createMember("null","null","user",Address.createAddress("수원시", "행궁동","123-123"));
        em.persist(member);
        return member;
    }
}