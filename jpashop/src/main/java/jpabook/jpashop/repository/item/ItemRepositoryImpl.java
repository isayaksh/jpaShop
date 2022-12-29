package jpabook.jpashop.repository.item;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jpabook.jpashop.domain.item.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import java.util.List;

import static jpabook.jpashop.domain.item.QItem.item;
import static jpabook.jpashop.domain.member.QMember.member;

@RequiredArgsConstructor
public class ItemRepositoryImpl implements ItemRepositoryJpql{

    private final EntityManager em;

    @Override
    public Page<Item> findAll(ItemSearch itemSearch, Pageable pageable) {
        JPAQueryFactory query = new JPAQueryFactory(em);

        List<Item> items = query
                .select(item)
                .from(item)
                .where(typeEq(itemSearch.getItemType()), nameContains(itemSearch.getItemName()))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .orderBy(item.createdDate.desc())
                .fetch();

        Long totalCount = query
                .select(item.count())
                .from(item)
                .where(typeEq(itemSearch.getItemType()), nameContains(itemSearch.getItemName()))
                .fetchOne();

        return new PageImpl<>(items, pageable, totalCount);
    }

    private BooleanExpression nameContains(String itemName) {
        if(!StringUtils.hasText(itemName)){
            return null;
        }
        return item.name.contains(itemName);
    }

    private BooleanExpression typeEq(String dtype) {
        if(!StringUtils.hasText(dtype)){
            return null;
        }
        return item.dtype.eq(dtype);
    }

}
