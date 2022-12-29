package jpabook.jpashop.service;


import jpabook.jpashop.domain.cart.CartItem;
import jpabook.jpashop.domain.cart.CartItemDto;
import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.domain.member.Member;
import jpabook.jpashop.exception.NotCorrespondingException;
import jpabook.jpashop.repository.cart.CartItemRepository;
import jpabook.jpashop.repository.item.ItemRepository;
import jpabook.jpashop.repository.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true) // 모든 통신활동 설정을 readOnly = true로 설정한다.
@RequiredArgsConstructor
public class CartService {

    private final CartItemRepository cartItemRepository;
    private final MemberRepository memberRepository;
    private final ItemRepository itemRepository;
    private final OrderService orderService;

    @Transactional
    public Long addCartItem(Long memberId, Long itemId, int count){
        // Member, Item 객체 찾기
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new NotCorrespondingException("CartService/addCartItem : memberId에 해당하는 Member 객체가 존재하지 않습니다."));
        Item item = itemRepository.findById(itemId)
                .orElseThrow(() -> new NotCorrespondingException("CartService/addCartItem : itemId에 해당하는 Item 객체가 존재하지 않습니다."));

        // CartItem 객체 찾기, 존재하지 않을 경우 새로운 CartItem 객체 생성
        CartItem cartItem = cartItemRepository.findByMemberIdAndItemId(memberId, item.getId()).orElseGet(() -> CartItem.createCartItem(member, item));

        // Item 개수 및 Cart 의 Item 개수 갱신
        cartItem.addCount(count);
        cartItemRepository.save(cartItem);
        return cartItem.getId();
    }

    public Page<CartItemDto> cartItems(Long memberId, Pageable pageable){
        return cartItemRepository.findAllByMemberId(memberId, pageable).map(i -> new CartItemDto(i));
    }

    @Transactional
    public void cancelCartItem(Long cartItemId) {
        cartItemRepository.deleteById(cartItemId);
    }

    @Transactional
    public void cancelCartItems(List<Long> cartItemIds) {
        cartItemRepository.deleteAllByIds(cartItemIds);
    }

    @Transactional
    public void order(List<Long> cartItemIds, Long memberId) {
        cartItemRepository.findAllById(cartItemIds)
                .forEach(item -> orderService.order(memberId, item.getItem().getId(), item.getCount()));
    }
}
