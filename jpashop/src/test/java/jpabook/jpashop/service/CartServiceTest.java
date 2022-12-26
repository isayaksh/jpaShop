package jpabook.jpashop.service;

import jpabook.jpashop.domain.Address;
import jpabook.jpashop.domain.cart.Cart;
import jpabook.jpashop.domain.cart.CartItemDto;
import jpabook.jpashop.domain.item.Book;
import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.domain.member.Member;
import jpabook.jpashop.exception.NotCorrespondingException;
import jpabook.jpashop.repository.cart.CartItemRepository;
import jpabook.jpashop.repository.cart.CartRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional

class CartServiceTest {

    @Autowired CartService cartService;
    @Autowired MemberService memberService;
    @Autowired ItemService itemService;
    @Autowired CartRepository cartRepository;


    @Test
    public void 카트_아이템_추가() throws Exception {
        // given
        Member member = Member.createMember("email", "password", "name", Address.createAddress("city", "street", "zipcode"), Cart.createCart());
        memberService.join(member);
        Book book = Book.createBook(member,"book",33000,100,"author","isbn");
        itemService.saveItem(book);

        // when
        cartService.addCartItem(member.getId(),book.getId(), 10);
        // then
        Cart cart = cartRepository.findOne(member.getId()).orElseThrow(() -> new NotCorrespondingException("일치하는 Cart가 존재하지 않습니다."));
        List<CartItemDto> cartItems = cartService.cartItems(member.getId());
        assertThat(cartItems.size()).isEqualTo(1);
    }

}