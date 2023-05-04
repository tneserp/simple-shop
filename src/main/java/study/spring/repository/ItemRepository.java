package study.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.spring.domain.Item;

public interface ItemRepository extends JpaRepository<Item, Long>{
}
