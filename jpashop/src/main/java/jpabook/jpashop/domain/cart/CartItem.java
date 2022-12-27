package jpabook.jpashop.domain.cart;

import jpabook.jpashop.domain.BaseEntity;
import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.domain.member.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.LAZY;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@NoArgsConstructor(access = PROTECTED)
public class CartItem extends BaseEntity {

    @Id @GeneratedValue
    @Column(name = "cart_item_id")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToOne(fetch = LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    /** 주문 상품의 개수 **/
    private int count;

    /** CartItem 생성자 **/
    public static CartItem createCartItem(Member member, Item item){
        CartItem cartItem = new CartItem();
        cartItem.member = member;
        cartItem.item = item;
        cartItem.count = 0;
        return cartItem;
    }

    public void addCount(int count){
        this.count += count;
    }
}
