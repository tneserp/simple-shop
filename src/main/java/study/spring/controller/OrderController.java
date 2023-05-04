package study.spring.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import study.spring.domain.Item;
import study.spring.domain.Member;
import study.spring.service.ItemService;
import study.spring.service.MemberService;

@Controller
@RequiredArgsConstructor
public class OrderController {

    private final ItemService itemService;
    private final MemberService memberService;

    @GetMapping("/order")
    public String createOrder(Model model) {
        List<Item> items = itemService.findAll();
        List<Member> members = memberService.findAll();

        model.addAttribute("items", items);
        model.addAttribute("members", members);

        return "orders/orderForm";
    }
}
