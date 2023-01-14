package jpabook.jpashop.repository.item;

import jpabook.jpashop.domain.item.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ItemRepositoryJpql {
    Page<Item> findAll(ItemSearch itemSearch, Pageable pageable);
}
