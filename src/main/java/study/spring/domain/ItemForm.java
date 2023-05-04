package study.spring.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemForm {

    private String name;
    private int price;
    private int stockQuantity;
    private String author;
    private String isbn;
}
