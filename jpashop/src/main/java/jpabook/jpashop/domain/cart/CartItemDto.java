package jpabook.jpashop.domain.cart;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CartItemDto {
    private Long id;
    private Long itemId;
    private Long memberId;
    private String name;
    private int price;
    private int count;
    private int totalPrice;


    public CartItemDto(CartItem cartItem) {
        this.id = cartItem.getId();
        this.itemId = cartItem.getItem().getId();
        this.memberId = cartItem.getItem().getMember().getId();
        this.name = cartItem.getItem().getName();
        this.price = cartItem.getItem().getPrice();
        this.count = cartItem.getCount();
        this.totalPrice = this.price * this.count;
    }
}
