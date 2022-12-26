package jpabook.jpashop.domain.cart;

import jpabook.jpashop.domain.BaseEntity;
import jpabook.jpashop.domain.member.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.LAZY;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@NoArgsConstructor(access = PROTECTED)
public class Cart {

    @Id @GeneratedValue
    @Column(name = "cart_id")
    private Long id;

    @OneToOne(fetch = LAZY, cascade = ALL)
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany(mappedBy = "cart", cascade = ALL)
    private List<CartItem> cartItems = new ArrayList<>();

    /** 카트에 담겨있는 상품의 수 **/
    private int count;

    public static Cart createCart() {
        Cart cart = new Cart();
        cart.count = 0;
        return cart;
    }

    public void addCount(){
        this.count += 1;
    }

    public void setMember(Member member){
        this.member = member;
    }
}
