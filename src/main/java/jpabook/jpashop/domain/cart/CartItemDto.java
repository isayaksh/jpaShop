package jpabook.jpashop.domain.cart;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter @Setter
public class CartItemDto {
    private Long id;
    private Long itemId;
    private Long memberId;
    private String name;
    private String date;
    private int price;
    private int count;
    private int totalPrice;


    public CartItemDto(CartItem cartItem) {
        this.id = cartItem.getId();
        this.itemId = cartItem.getItem().getId();
        this.memberId = cartItem.getItem().getMember().getId();
        this.name = cartItem.getItem().getName();
        this.date = cartItem.getCreatedDate().format(DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss"));
        this.price = cartItem.getItem().getPrice();
        this.count = cartItem.getCount();
        this.totalPrice = this.price * this.count;
    }
}
