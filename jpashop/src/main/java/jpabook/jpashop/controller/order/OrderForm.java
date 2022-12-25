package jpabook.jpashop.controller.order;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class OrderForm {
    private Long itemId;
    private int count;
}
