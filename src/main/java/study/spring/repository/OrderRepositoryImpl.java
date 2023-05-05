package study.spring.repository;

import static org.springframework.util.StringUtils.*;
import static study.spring.domain.QMember.*;
import static study.spring.domain.QOrder.*;

import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.util.StringUtils;
import study.spring.domain.Order;
import study.spring.domain.OrderSearch;
import study.spring.domain.OrderStatus;
import study.spring.domain.QMember;
import study.spring.domain.QOrder;

@RequiredArgsConstructor
public class OrderRepositoryImpl implements OrderRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<Order> findOrderSearch(OrderSearch orderSearch) {
        return queryFactory
                .selectFrom(order)
                .join(order.member,member)
                .where(isSameMemberName(member, orderSearch.getMemberName()),
                        isSameOrderStatus(order, orderSearch.getOrderStatus()))
                .fetch();

    }

    private Predicate isSameMemberName(QMember member, String memberName) {
        return hasText(memberName) ? member.name.eq(memberName) : null;
    }

    private Predicate isSameOrderStatus(QOrder order, OrderStatus orderStatus) {
        return orderStatus != null ? order.status.eq(orderStatus) : null;
    }
}
