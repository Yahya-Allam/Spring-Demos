package iti.labs.spring.remoting.controller;

import iti.labs.spring.remoting.entities.Product;
import iti.labs.spring.remoting.services.impl.CustomerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController

public class ProductController {
    private CustomerImpl customerImpl;

    @Autowired
    public void setCustomerImpl(CustomerImpl customerImpl){
        this.customerImpl = customerImpl;
    }

 
    @PostMapping("product")
    public Product addProduct(@RequestBody Product product){
        return customerImpl.addProduct( product);
    }
 
    @DeleteMapping("/product/{id}")
    public void deleteProduct(@PathVariable("id") Long id){
         customerImpl.deleteProduct(id);
    }
    @GetMapping("/products")
    public Set<Product> getAll(){
        return customerImpl.getAllProducts();
    }


    @GetMapping("/product/{id}")
    public Product getProduct(@PathVariable("id") Long id){
        return customerImpl.getProductById(id);
    }



}
