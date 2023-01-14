package jpabook.jpashop.repository.cart;

import jpabook.jpashop.domain.cart.CartItem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.List;
import java.util.Optional;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {

    Optional<CartItem> findByMemberIdAndItemId(Long memberId, Long itemId);

    Page<CartItem> findAllByMemberId(Long memberId, Pageable pageable);

    @Modifying
    @Query("delete from CartItem c where c.id in :ids")
    void deleteAllByIds(@Param("ids") List<Long> ids);
}
