package study.spring.domain;

import javax.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Embeddable
@NoArgsConstructor
public class Address {

    private String city;
    private String street;
    private String zipcode;
}
