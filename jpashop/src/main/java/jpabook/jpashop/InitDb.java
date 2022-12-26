package jpabook.jpashop;

import jpabook.jpashop.domain.*;
import jpabook.jpashop.domain.cart.Cart;
import jpabook.jpashop.domain.item.Album;
import jpabook.jpashop.domain.item.Book;
import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.domain.item.Movie;
import jpabook.jpashop.domain.member.Member;
import jpabook.jpashop.repository.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
@RequiredArgsConstructor
public class InitDb {

    private final InitService initService;

    @PostConstruct
    public void init(){
        initService.createAdmin();
        initService.dbInit2();
        initService.createMember();
        initService.createItem();
    }

    @Component
    @Transactional
    @RequiredArgsConstructor
    static class InitService {

        private final EntityManager em;
        private final MemberRepository memberRepository;
        public void createAdmin(){
            Address address1 = Address.createAddress("화성시", "동탄 순환대로 10길", "23541");
            Member member1 = Member.createMember("ADMIN","PASSWORD","운영자", address1, Cart.createCart());
            em.persist(member1);
        }

        public void dbInit2(){
            Address address1 = Address.createAddress("동탄", "동탄 순환대로", "10988");
            Member member1 = Member.createMember("ID2","PASSWORD2","userB", address1, Cart.createCart());
            em.persist(member1);
            Book book1 = Book.createBook(member1, "SPRING1 BOOK", 15000, 100, "김영한", "54321");
            em.persist(book1);
            Book book2 = Book.createBook(member1, "SPRING2 BOOK", 25000, 200, "김영한", "12345");
            em.persist(book2);

            /** order 만 persist 하는 이유! **/
            /** cascade 로 엮어져 있기 때문! **/
            OrderItem orderItem1 = OrderItem.createOrderItem(book1, book1.getPrice(), 1);
            OrderItem orderItem2 = OrderItem.createOrderItem(book2, book2.getPrice(), 2);
            Delivery delivery1 = Delivery.createDelivery(address1);
            Order order = Order.createOrder(member1, delivery1, orderItem1, orderItem2);
            em.persist(order);
        }

        public void createMember(){
            // 무작위 문자열 ID를 생성하기 위한 값
            int leftLimit = 97; // letter 'a'
            int rightLimit = 122; // letter 'z'
            int targetStringLength = 5;
            Random random = new Random();

            // 비밀번호 값
            String password = "password";

            String[] name1 = {"김", "이", "박", "최", "정", "강"};
            String[] name2 = {"상", "시", "창", "재", "민", "승"};
            String[] name3 = {"현", "영", "준", "용", "아", "구"};
            // 도시 값
            String[] cities = {"서울시", "부산시", "인천시", "대구시", "대전시", "광주시", "울산시", "세종시"};
            // 주소 값
            String[] streets = {"송죽동", "정자동", "인계동", "메탄동", "세류동", "고색동"};

            for(int i = 0; i < 30; i++){
                String id = random.ints(leftLimit, rightLimit + 1)
                        .limit(targetStringLength)
                        .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                        .toString();
                String name = name1[(int)(Math.random()*5)] + name2[(int)(Math.random()*5)] + name3[(int)(Math.random()*5)];
                String city = cities[(int)(Math.random()*7)];
                String street = streets[(int)(Math.random()*5)];
                String zipcode = random.ints(48, 57)
                        .limit(targetStringLength)
                        .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                        .toString();
                Member member = Member.createMember(id + "@gmail.com", password, name, Address.createAddress(city,street,zipcode), Cart.createCart());
                em.persist(member);
            }
        }

        public void createItem(){
            int stockQuantity = 100;
            String artist = "artist";
            String etc = "etc";
            String author = "author";
            String isbn = "isbn";
            String actor = "actor";
            String director = "director";

            List<Member> members = memberRepository.findAll();
            for(int i = 1; i <30; i++){
                int price = 10000 + (int)(Math.random()*20000);
                int j = (int)(Math.random()*3);
                int k = (int)(Math.random()*3);
                if(j == 0){
                    Book book = Book.createBook(members.get(k), "Book" + i, price, stockQuantity, author + i, isbn);
                    em.persist(book);
                } else if(j==1){
                    Album album = Album.createAlbum(members.get(k),"Album" + i, price, stockQuantity, artist + i, etc);
                    em.persist(album);
                } else {
                    Movie movie = Movie.createMovie(members.get(k), "Movie" + i, price, stockQuantity, director + i, actor);
                    em.persist(movie);
                }
            }

        }
    }
}

