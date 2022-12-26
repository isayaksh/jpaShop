package jpabook.jpashop.repository.cart;

import jpabook.jpashop.domain.cart.Cart;
import jpabook.jpashop.domain.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart, Long> {

    @Query("select c from Cart c where c.member.id =:memberId")
    Optional<Cart> findOne(@Param("memberId") Long memberId);
}
