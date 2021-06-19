package iti.labs.spring.remoting.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(catalog = "spring-remote",name = "products")

public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    @NonNull
    private String name ;
    @NonNull
    private String description ;
    @NonNull
    private Long quantity ;
    @NonNull
    private Double price ;

    @JsonIgnore
    @ManyToMany(mappedBy = "products")
    private List<Order> orders = new ArrayList<>();

}
