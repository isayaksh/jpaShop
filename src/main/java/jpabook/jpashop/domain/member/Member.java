package jpabook.jpashop.domain.member;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jpabook.jpashop.domain.Address;
import jpabook.jpashop.domain.BaseEntity;
import jpabook.jpashop.domain.order.Order;
import jpabook.jpashop.domain.cart.CartItem;
import jpabook.jpashop.domain.item.Item;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.ALL;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@NoArgsConstructor(access = PROTECTED)
public class Member extends BaseEntity {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String email;
    private String password;

    private String username;

    @Embedded
    private Address address;

    @JsonIgnore
    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "member")
    private List<Item> items = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = ALL)
    private List<CartItem> cartItems = new ArrayList<>();

    public static Member createMember(String email, String password, String name, Address address){
        Member member = new Member();
        member.email = email;
        member.password = password;
        member.username = name;
        member.address = address;
        return member;
    }

    public void changeName(String name) {
        this.username = name;
    }
    public boolean checkPassword(String password){
        return this.password.equals(password);
    }

    public void update(String email, String password, String username, String city, String street, String zipcode){
        this.email = email;
        this.password = password;
        this.username = username;
        this.address.update(city,street,zipcode);
    }

}
