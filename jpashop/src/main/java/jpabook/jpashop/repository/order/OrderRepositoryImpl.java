package jpabook.jpashop.repository.order;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jpabook.jpashop.domain.Order;
import jpabook.jpashop.domain.OrderStatus;
import jpabook.jpashop.domain.QMember;
import jpabook.jpashop.domain.QOrder;
import lombok.RequiredArgsConstructor;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import java.util.List;

@RequiredArgsConstructor
public class OrderRepositoryImpl implements OrderRepositoryJpql{

    private final EntityManager em;

    @Override
    public List<Order> findAll(OrderSearch orderSearch) {
        JPAQueryFactory query = new JPAQueryFactory(em);

        QOrder order = QOrder.order;
        QMember member = QMember.member;

        return query
                .select(order)
                .from(order)
                .join(order.member, member)
                .where(statusEq(orderSearch.getOrderStatus()), nameLike(orderSearch.getMemberName()))
                .limit(1000)
                .fetch();
    }

    private BooleanExpression nameLike(String username) {
        if(!StringUtils.hasText(username)){
            return null;
        }
        return QMember.member.username.like(username);
    }

    private BooleanExpression statusEq(OrderStatus statusCond){
        if(statusCond == null){
            return null;
        }
        return QOrder.order.status.eq(statusCond);
    }
}
