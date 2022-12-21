package jpabook.jpashop.domain.member;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jpabook.jpashop.domain.Address;
import jpabook.jpashop.domain.BaseEntity;
import jpabook.jpashop.domain.Order;
import jpabook.jpashop.domain.item.Item;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@NoArgsConstructor(access = PROTECTED)
@DynamicUpdate // [add] 변경된 필드의 값만 업데이트
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
