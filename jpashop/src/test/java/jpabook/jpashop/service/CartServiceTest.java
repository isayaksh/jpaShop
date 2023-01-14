package jpabook.jpashop.service;

import jpabook.jpashop.domain.Address;
import jpabook.jpashop.domain.item.Book;
import jpabook.jpashop.domain.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
@SpringBootTest
@Transactional
class CartServiceTest {

    @Autowired CartService cartService;
    @Autowired MemberService memberService;
    @Autowired ItemService itemService;


    @Test
    public void 카트_아이템_추가() throws Exception {
        // given
        Member member = Member.createMember("email", "password", "name", Address.createAddress("city", "street", "zipcode"));
        memberService.join(member);
        Book book = Book.createBook(member,"book",33000,100,"author","isbn");
        itemService.saveItem(book);

        // when
        cartService.addCartItem(member.getId(),book.getId(), 10);
        // then
    }

}