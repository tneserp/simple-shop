package study.spring.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Item {

    @Id @GeneratedValue
    private Long id;

    private String name;
    private int price;
    private int stockQuantity;
    private String author;
    private String isbn;

    public Item(String name, int price, int stockQuantity, String author, String isbn) {
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.author = author;
        this.isbn = isbn;
    }
}
