package study.spring.service;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.spring.domain.Item;
import study.spring.domain.Member;
import study.spring.domain.Order;
import study.spring.domain.OrderItem;
import study.spring.repository.ItemRepository;
import study.spring.repository.MemberRepository;
import study.spring.repository.OrderRepository;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final MemberRepository memberRepository;
    private final ItemRepository itemRepository;

}
