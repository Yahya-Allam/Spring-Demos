package iti.labs.spring.remoting.controller;

import iti.labs.spring.remoting.entities.Order;
import iti.labs.spring.remoting.entities.Product;
import iti.labs.spring.remoting.services.impl.CustomerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController

public class OrderController {
    private CustomerImpl customerImpl;

    @Autowired
    public void setCustomerImpl(CustomerImpl customerImpl){
        this.customerImpl = customerImpl;
    }

    @PostMapping("/order")
    public Order addOrder(@RequestBody Order order){
        return customerImpl.addOrder(order);
    }
    @PostMapping("/customer/{id}/order")
    public Order addOrder(@PathVariable("id")Long id ,@RequestBody Order order){
        return customerImpl.addOrder(id , order);
    }
    @PostMapping("/order/{id}/product")
    public Order addProductToOrder(@PathVariable("id")Long id ,@RequestBody Product product){
        return customerImpl.addProductToOrder(id , product);
    }
    @PutMapping("/order/{id}")
    public Order update(@PathVariable("id") Long id , @RequestBody Order order){
        return customerImpl.updateOrder(id , order);
    }
    @DeleteMapping("/order/{id}")
    public void delete(@PathVariable("id") Long id){
         customerImpl.deleteOrder(id);
    }
    @GetMapping("/orders")
    public Set<Order> getAll(){
        return customerImpl.getAllOrders();
    }
    @GetMapping("/order/{id}")
    public Order getOrderById(@PathVariable("id") Long id){
        return customerImpl.getOrderById(id);
    }


}
