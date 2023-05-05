package study.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.spring.domain.Order;

public interface OrderRepository extends JpaRepository<Order,Long>, OrderRepositoryCustom {
}
