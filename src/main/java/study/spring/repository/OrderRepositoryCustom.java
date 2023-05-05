package study.spring.repository;

import java.util.List;
import study.spring.domain.Order;
import study.spring.domain.OrderSearch;

public interface OrderRepositoryCustom {

    public List<Order> findOrderSearch(OrderSearch orderSearch);
}
