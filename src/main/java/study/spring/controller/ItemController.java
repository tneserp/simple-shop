package study.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import study.spring.domain.ItemForm;

@Controller
public class ItemController {

    @GetMapping("/items/new")
    public String createItem(Model model) {
        model.addAttribute("itemForm", new ItemForm());
        return "items/createItemForm";
    }
}
