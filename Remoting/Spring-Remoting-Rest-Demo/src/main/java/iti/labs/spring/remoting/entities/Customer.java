package iti.labs.spring.remoting.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.stereotype.Controller;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@Entity
@Controller
@Table(name = "customers" ,schema = "spring-remote")
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String name;
    @NonNull
    private String address;
    @NonNull
    private String phone ;

    @JsonIgnore
    @OneToMany(mappedBy = "customer",cascade = CascadeType.REMOVE)
    List<Order> orders ;
}
