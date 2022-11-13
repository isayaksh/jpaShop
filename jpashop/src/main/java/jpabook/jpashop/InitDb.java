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
        initService.dbInit3();
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

        public void dbInit3(){
            Member member1 = Member.createMember("email1@gmail.com", "password", "userA", Address.createAddress("cityA", "streetA", "111111"));
            em.persist(member1);
            Member member2 = Member.createMember("email2@gmail.com", "password", "userB", Address.createAddress("cityB", "streetB", "111111"));
            em.persist(member2);
            Member member3 = Member.createMember("email3@gmail.com", "password", "userC", Address.createAddress("cityC", "streetC", "111111"));
            em.persist(member3);
            Member member4 = Member.createMember("email4@gmail.com", "password", "userD", Address.createAddress("cityD", "streetD", "111111"));
            em.persist(member4);
            Member member5 = Member.createMember("email5@gmail.com", "password", "userE", Address.createAddress("cityE", "streetE", "111111"));
            em.persist(member5);
            Member member6 = Member.createMember("email6@gmail.com", "password", "userF", Address.createAddress("cityF", "streetF", "111111"));
            em.persist(member6);
            Member member7 = Member.createMember("email7@gmail.com", "password", "userG", Address.createAddress("cityG", "streetG", "111111"));
            em.persist(member7);
            Member member8 = Member.createMember("email8@gmail.com", "password", "userH", Address.createAddress("cityH", "streetH", "111111"));
            em.persist(member8);
            Member member9 = Member.createMember("email9@gmail.com", "password", "userI", Address.createAddress("cityI", "streetI", "111111"));
            em.persist(member9);
            Member member10 = Member.createMember("email01@gmail.com", "password", "userJ", Address.createAddress("cityJ", "streetJ", "111111"));
            em.persist(member10);
            Member member11 = Member.createMember("email11@gmail.com", "password", "userK", Address.createAddress("cityK", "streetK", "111111"));
            em.persist(member11);
            Member member12 = Member.createMember("email12@gmail.com", "password", "userL", Address.createAddress("cityL", "streetL", "111111"));
            em.persist(member12);
            Member member13 = Member.createMember("email13@gmail.com", "password", "userM", Address.createAddress("cityM", "streetM", "111111"));
            em.persist(member13);
            Member member14 = Member.createMember("email14@gmail.com", "password", "userN", Address.createAddress("cityN", "streetN", "111111"));
            em.persist(member14);
            Member member15 = Member.createMember("email15@gmail.com", "password", "userO", Address.createAddress("cityO", "streetO", "111111"));
            em.persist(member15);
            Member member16 = Member.createMember("email16@gmail.com", "password", "userP", Address.createAddress("cityP", "streetP", "111111"));
            em.persist(member16);
            Member member17 = Member.createMember("email17@gmail.com", "password", "userQ", Address.createAddress("cityQ", "streetQ", "111111"));
            em.persist(member17);
            Member member18 = Member.createMember("email18@gmail.com", "password", "userR", Address.createAddress("cityR", "streetR", "111111"));
            em.persist(member18);
            Member member19 = Member.createMember("email19@gmail.com", "password", "userS", Address.createAddress("cityS", "streetS", "111111"));
            em.persist(member19);
            Member member20 = Member.createMember("email20@gmail.com", "password", "userT", Address.createAddress("cityT", "streetT", "111111"));
            em.persist(member20);
            Member member21 = Member.createMember("email21@gmail.com", "password", "userU", Address.createAddress("cityU", "streetU", "111111"));
            em.persist(member21);
            Member member22 = Member.createMember("email22@gmail.com", "password", "userV", Address.createAddress("cityV", "streetV", "111111"));
            em.persist(member22);
            Member member23 = Member.createMember("email23@gmail.com", "password", "userW", Address.createAddress("cityW", "streetW", "111111"));
            em.persist(member23);
            Member member24 = Member.createMember("email24@gmail.com", "password", "userX", Address.createAddress("cityX", "streetX", "111111"));
            em.persist(member24);
            Member member25 = Member.createMember("email25@gmail.com", "password", "userY", Address.createAddress("cityY", "streetY", "111111"));
            em.persist(member25);
            Member member26 = Member.createMember("email26@gmail.com", "password", "userZ", Address.createAddress("cityZ", "streetZ", "111111"));
            em.persist(member26);

        }
    }
}

