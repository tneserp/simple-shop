package study.spring.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import study.spring.domain.Item;
import study.spring.domain.Member;
import study.spring.domain.Order;
import study.spring.domain.OrderSearch;
import study.spring.repository.OrderRepository;
import study.spring.service.ItemService;
import study.spring.service.MemberService;
import study.spring.service.OrderService;

@Controller
@RequiredArgsConstructor
public class OrderController {

    private final ItemService itemService;
    private final MemberService memberService;
    private final OrderService orderService;
    private final OrderRepository orderRepository;

    @GetMapping("/order")
    public String createOrder(Model model) {
        List<Item> items = itemService.findAll();
        List<Member> members = memberService.findAll();

        model.addAttribute("items", items);
        model.addAttribute("members", members);

        return "orders/orderForm";
    }

    @PostMapping("/order")
    public String create(@Param("memberId") Long memberId,
                         @Param("itemId") Long itemId,
                         @Param("count") int count) {
        orderService.join(memberId, itemId, count);
        return "redirect:/";
    }

    @GetMapping("/orders")
    public String orderList(Model model) {
        model.addAttribute("orderSearch", new OrderSearch());

        List<Order> orders = orderRepository.findAll();
        model.addAttribute("orders", orders);
        System.out.println("orders.get(0) = " + orders.get(0));
        return "orders/orderList";
    }

    @PostMapping("orders/{orderId}/cancel")
    public String cancelItem(@PathVariable Long orderId) {
        orderService.cancel(orderId);
        return "redirect:/orders";
    }
}
