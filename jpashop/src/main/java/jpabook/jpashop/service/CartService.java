package jpabook.jpashop.service;

import jpabook.jpashop.domain.cart.Cart;
import jpabook.jpashop.domain.cart.CartItem;
import jpabook.jpashop.domain.cart.CartItemDto;
import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.domain.member.Member;
import jpabook.jpashop.exception.NotCorrespondingException;
import jpabook.jpashop.repository.cart.CartItemRepository;
import jpabook.jpashop.repository.cart.CartRepository;
import jpabook.jpashop.repository.item.ItemRepository;
import jpabook.jpashop.repository.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true) // 모든 통신활동 설정을 readOnly = true로 설정한다.
@RequiredArgsConstructor
public class CartService {

    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;
    private final MemberRepository memberRepository;
    private final ItemRepository itemRepository;

    @Transactional
    public Long addCartItem(Long memberId, Long itemId, int count){
        // Member, Item 객체 찾기
        Member member = memberRepository.findById(memberId).orElseThrow(() -> new NotCorrespondingException("CartService/addCartItem : memberId에 해당하는 Member 객체가 존재하지 않습니다."));
        Item item = itemRepository.findById(itemId).orElseThrow(() -> new NotCorrespondingException("CartService/addCartItem : itemId에 해당하는 Item 객체가 존재하지 않습니다."));

        // Cart 객체 찾기, 존재하지 않을 경우 새로운 Cart 객체 생성
        Cart cart = cartRepository.findOne(memberId).orElseGet(() -> Cart.createCart());
        member.setCart(cart);
        // CartItem 객체 찾기, 존재하지 않을 경우 새로운 CartItem 객체 생성
        CartItem cartItem = cartItemRepository.findByCartIdAndItemId(cart.getId(), item.getId()).orElseGet(() -> CartItem.createCartItem(cart, item));

        // Item 개수 및 Cart 의 Item 개수 갱신
        cartItem.addCount(count);
        cart.addCount();
        cartRepository.save(cart);
        cartItemRepository.save(cartItem);
        return cartItem.getId();
    }

    public List<CartItemDto> cartItems(Long memberId){
        // Member, Item 객체 찾기
        Member member = memberRepository.findById(memberId).orElseThrow(() -> new NotCorrespondingException("CartService/addCartItem : memberId에 해당하는 Member 객체가 존재하지 않습니다."));
        // Cart 객체 찾기, 존재하지 않을 경우 새로운 Cart 객체 생성
        Cart cart = cartRepository.findOne(memberId).orElseGet(() -> Cart.createCart());

        return cart.getCartItems().stream().map(i -> new CartItemDto(i)).collect(Collectors.toList());
    }
}
