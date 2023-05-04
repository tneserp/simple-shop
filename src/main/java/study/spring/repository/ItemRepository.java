package study.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import study.spring.domain.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item,Long> {
}
