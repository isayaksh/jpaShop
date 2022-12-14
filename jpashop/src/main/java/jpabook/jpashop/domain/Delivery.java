package jpabook.jpashop.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jpabook.jpashop.domain.order.Order;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.EnumType.STRING;
import static javax.persistence.FetchType.LAZY;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@NoArgsConstructor(access = PROTECTED)
public class Delivery {

    @Id @GeneratedValue
    @Column(name = "delivery_id")
    private Long id;

    @JsonIgnore
    @OneToOne(fetch = LAZY,mappedBy = "delivery")
    private Order order;

    @Embedded
    private Address address;

    @Enumerated(value = STRING)
    private DeliveryStatus status;

    public static Delivery createDelivery(Address address) {
        Delivery delivery = new Delivery();
        delivery.address = address;
        return delivery;
    }

    public void setOrder(Order order){
        this.order = order;
    }
}
