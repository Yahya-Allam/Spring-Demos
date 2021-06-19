package iti.labs.spring.remoting.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;



@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(catalog = "spring-remote", name = "orders")
public class Order {

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "customerId")
    Customer customer;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date;
    private String status;
    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "orders_products",
            joinColumns = {@JoinColumn(name = "fk_order")},
            inverseJoinColumns = {@JoinColumn(name = "fk_product")}
    )
    private List<Product> products = new ArrayList<>();

}
