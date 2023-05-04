package study.spring.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import study.spring.domain.Item;
import study.spring.domain.ItemForm;
import study.spring.service.ItemService;

@Controller
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @GetMapping("/items/new")
    public String createItem(Model model) {
        model.addAttribute("itemForm", new ItemForm());
        return "items/createItemForm";
    }

    @PostMapping("/items/new")
    public String create(@ModelAttribute ItemForm itemForm) {
        itemService.join(new Item(itemForm.getName(), itemForm.getPrice(), itemForm.getStockQuantity(),
                itemForm.getAuthor(), itemForm.getIsbn()));
        return "redirect:/items";
    }

    @GetMapping("/items")
    public String itemList(Model model) {
        List<Item> items = itemService.findAll();
        model.addAttribute("items", items);
        return "items/itemList";
    }

    @GetMapping("/items/{id}/edit")
    public String editItem(Model model, @PathVariable Long id) {
        //Dto 넘겨주고 싶은데 id 값이 있어서 고민
        Item findItem = itemService.findById(id);
        model.addAttribute("item", findItem);
        return "items/updateItemForm";
    }

    @PostMapping("/items/{id}/edit")
    public String updateItem(@PathVariable Long id, @ModelAttribute Item item) {
        itemService.updateItem(id, item);
        return "redirect:/items";
    }
}
