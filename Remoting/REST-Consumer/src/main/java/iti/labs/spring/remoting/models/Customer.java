package iti.labs.spring.remoting.models;

import lombok.Data;
import lombok.NonNull;

@Data
//@AllArgsConstructor
public class Customer {

    private int id;

    @NonNull
    private String name;
    @NonNull
    private String address;
    @NonNull
    private String phone;


}
