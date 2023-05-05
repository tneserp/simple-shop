package study.spring;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import study.spring.domain.Address;
import study.spring.domain.Item;
import study.spring.domain.Member;
import study.spring.domain.Order;
import study.spring.domain.OrderItem;

@Component
@Transactional
@RequiredArgsConstructor
public class AddBasicData {

    private final addData addData;

    @PostConstruct
    public void init() {
        addData.add1();
        addData.add2();
    }

    @Component
    @Transactional
    @RequiredArgsConstructor
    static class addData {

        private final EntityManager em;

        public void add1() {
            Member memberA = new Member("userA", new Address("서울", "1", "1111"));
            em.persist(memberA);

            Item item = new Item("book1", 1000, 888, "aaa", "bbb");
            em.persist(item);

            OrderItem orderItem1 = OrderItem.createOrderItem(item, 1000, 1);

            Order order = Order.createOrder(memberA, orderItem1);
            em.persist(order);
        }

        public void add2() {
            Member memberB = new Member("userA", new Address("부산", "2", "2222"));
            em.persist(memberB);

            Item item = new Item("book2", 2000, 999, "ccc", "ddd");
            em.persist(item);

            OrderItem orderItem2 = OrderItem.createOrderItem(item, 2000, 2);

            Order order = Order.createOrder(memberB, orderItem2);
            em.persist(order);
        }
    }
}
