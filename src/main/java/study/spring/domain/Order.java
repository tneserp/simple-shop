package study.spring.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "orders")
@NoArgsConstructor
public class Order {

    @Id @GeneratedValue
    @Column(name = "order_Id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_Id")
    private Member member;

    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItem = new ArrayList<>();

    private OrderStatus status;

    private LocalDateTime orderDate;

    // 연관관계 메서드
    private void setMember(Member member) {
        this.member = member;
        member.getOrder().add(this);
    }

    private void addOrderItem(OrderItem orderItem) {
        this.orderItem.add(orderItem);
        orderItem.setOrder(this);
    }

    public Order(Member member, List<OrderItem> orderItem, OrderStatus status) {
        this.member = member;
        this.orderItem = orderItem;
        this.status = status;
    }

    // 생성 메서드
    public static Order createOrder(Member member, OrderItem... orderItems) {
        Order order = new Order();
        order.setMember(member);
        order.orderItem.addAll(Arrays.asList(orderItems));
        order.status = OrderStatus.COMPLETE;
        order.orderDate = LocalDateTime.now();

        return order;
    }
}
