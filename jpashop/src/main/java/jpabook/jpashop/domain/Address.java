package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

import static lombok.AccessLevel.PROTECTED;

@Embeddable
@Getter
@NoArgsConstructor(access = PROTECTED)
public class Address {
    private String city;
    private String street;
    private String zipcode;

    public static Address createAddress(String city, String street, String zipcode) {
        Address address = new Address();
        address.city = city;
        address.street = street;
        address.zipcode = zipcode;
        return address;
    }
}
