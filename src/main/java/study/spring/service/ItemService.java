package study.spring.service;

import java.util.List;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import study.spring.domain.Item;
import study.spring.repository.ItemRepository;

@Service
@Transactional
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    public void join(Item item) {
        itemRepository.save(item);
    }

    public List<Item> findAll() {
        return itemRepository.findAll();
    }

    public Item findById(Long id) {
        return itemRepository.findById(id).get();
    }

    public void updateItem(Long id, Item item) {
        /**
         * id를 굳이 파라미터로 받아야할까
         * 일단 get() 사용
         */
        Item findItem = itemRepository.findById(id).get();
        findItem.setName(item.getName());
        findItem.setPrice(item.getPrice());
        findItem.setStockQuantity(item.getStockQuantity());
        findItem.setIsbn(item.getIsbn());
        findItem.setAuthor(findItem.getAuthor());
    }

}
