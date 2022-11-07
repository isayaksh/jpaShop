package jpabook.jpashop;

import jpabook.jpashop.domain.*;
import jpabook.jpashop.domain.item.Book;
import jpabook.jpashop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;

@Component
@RequiredArgsConstructor
public class InitDb {

    private final InitService initService;

    @PostConstruct
    public void init(){
        initService.dbInit1();
        initService.dbInit2();
    }

    @Component
    @Transactional
    @RequiredArgsConstructor
    static class InitService {

        private final EntityManager em;
        public void dbInit1(){
            Address address1 = Address.createAddress("수원", "행궁동", "23541");
            Member member1 = Member.createMember("ID1","PASSWORD1","userA", address1);
            em.persist(member1);
            Book book1 = Book.createBook("JPA1 BOOK", 38700, 100, "김영한", "12321");
            em.persist(book1);
            Book book2 = Book.createBook("JPA2 BOOK", 28700, 200, "김영한", "23451");
            em.persist(book2);

            /** order 만 persist 하는 이유! **/
            /** cascade 로 엮어져 있기 때문! **/
            OrderItem orderItem1 = OrderItem.createOrderItem(book1, book1.getPrice(), 1);
            OrderItem orderItem2 = OrderItem.createOrderItem(book2, book2.getPrice(), 2);
            Delivery delivery1 = Delivery.createDelivery(address1);
            Order order = Order.createOrder(member1, delivery1, orderItem1, orderItem2);
            em.persist(order);
        }

        public void dbInit2(){
            Address address1 = Address.createAddress("동탄", "동탄 순환대로", "10988");
            Member member1 = Member.createMember("ID2","PASSWORD2","userB", address1);
            em.persist(member1);
            Book book1 = Book.createBook("SPRING1 BOOK", 15000, 100, "김영한", "54321");
            em.persist(book1);
            Book book2 = Book.createBook("SPRING2 BOOK", 25000, 200, "김영한", "12345");
            em.persist(book2);

            /** order 만 persist 하는 이유! **/
            /** cascade 로 엮어져 있기 때문! **/
            OrderItem orderItem1 = OrderItem.createOrderItem(book1, book1.getPrice(), 1);
            OrderItem orderItem2 = OrderItem.createOrderItem(book2, book2.getPrice(), 2);
            Delivery delivery1 = Delivery.createDelivery(address1);
            Order order = Order.createOrder(member1, delivery1, orderItem1, orderItem2);
            em.persist(order);
        }
    }
}

