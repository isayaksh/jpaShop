package jpabook.jpashop.domain.member;

import lombok.Data;

@Data
public class MemberDto {
    private String username;
    private String city;
    private String street;
    private String zipcode;

    public MemberDto(Member member) {
        this.username = member.getUsername();
        this.city = member.getAddress().getCity();
        this.street = member.getAddress().getStreet();
        this.zipcode = member.getAddress().getZipcode();
    }
}
