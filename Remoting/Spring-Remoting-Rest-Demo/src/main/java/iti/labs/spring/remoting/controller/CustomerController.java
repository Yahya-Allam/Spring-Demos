package iti.labs.spring.remoting.controller;

import iti.labs.spring.remoting.entities.Customer;
import iti.labs.spring.remoting.services.impl.CustomerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController

public class CustomerController {
    private CustomerImpl customerImpl;

    @Autowired
    public void setCustomerImpl(CustomerImpl customerImpl){
        this.customerImpl = customerImpl;
    }
    @PostMapping("/customer")
    public Customer add(@RequestBody Customer customer){
        return customerImpl.save(customer);
    }
    @PutMapping("/customer")
    public Customer update(@RequestBody Customer customer){
        return customerImpl.update(customer);
    }
    @DeleteMapping("/customer/{id}")
    public void delete(@PathVariable("id") Long id){
         customerImpl.delete(id);
    }
    @GetMapping("/customer")
    public Set<Customer> getAll(){
        return customerImpl.getAll();
    }
    @GetMapping("/customer/{id}")
    public Customer getCustomerById(@PathVariable("id") Long id){
        return customerImpl.getCustomerById(id);
    }
   
}
