package iti.labs.spring.remoting.services.impl;

import iti.labs.spring.remoting.entities.Customer;
import iti.labs.spring.remoting.entities.Order;
import iti.labs.spring.remoting.entities.Product;
import iti.labs.spring.remoting.repositories.CustomerRepository;
import iti.labs.spring.remoting.repositories.OrderRepository;
import iti.labs.spring.remoting.repositories.ProductRepository;
import iti.labs.spring.remoting.exception.BadRequestException;
import iti.labs.spring.remoting.exception.ResourceNotFoundException;
import iti.labs.spring.remoting.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class CustomerImpl implements CustomerService {
    private static final String NOT_FOUND = "resource not found ";
    private static final String BAD_REQUEST = "resource inserted before  ";

    private CustomerRepository customerRepo;
    private OrderRepository orderRepo ;
    private ProductRepository productRepo ;

    @Autowired
    public void init(CustomerRepository repo,OrderRepository orderRepo,ProductRepository productRepo){
        this.customerRepo = repo;
        this.orderRepo = orderRepo ;
        this.productRepo = productRepo ;
    }

    @Override
    public Customer save(Customer customer) {
        Optional<Customer> customerOptional = customerRepo.findByPhone(customer.getPhone());
        if(customerOptional.isPresent()){
            throw new BadRequestException(BAD_REQUEST);
        }
        Customer customerTemp = customerRepo.save(customer);
        return customerTemp;
    }

    @Override
    public Customer update(Customer customer) {
        Optional<Customer> customerOptional = customerRepo.findById(customer.getId());
        if(customerOptional.isPresent()){
            return customerRepo.save(customer);
        }
        throw new ResourceNotFoundException(NOT_FOUND);
    }

    @Override
    public void delete(Long id) {
        Optional<Customer> customerOptional = customerRepo.findById(id);
        if(customerOptional.isPresent()){
             customerRepo.deleteById(id);
             return ;
        }
        throw new ResourceNotFoundException(NOT_FOUND);
    }

    @Override
    public Set<Customer> getAll() {
        Set<Customer> customers = customerRepo.findAll().stream().filter( Objects::nonNull).collect(Collectors.toSet());

        return customers ;

    }


    @Override
    public Customer getCustomerById(Long id) {
        Optional<Customer> customerOptional = customerRepo.findById(id);
        if(customerOptional.isPresent()){
            return customerOptional.get();
        }
        throw new ResourceNotFoundException(NOT_FOUND);
    }

    @Override
    public Order addOrder(Long id, Order order) {

        Optional<Customer> customerOptional = customerRepo.findById(id);
        if(customerOptional.isPresent()){
            Logger.getLogger(getClass().getName()).info(customerOptional.get().getName());
            order.setCustomer(customerOptional.get());
            Order orderTemp = orderRepo.save(order);
            return orderTemp;
        }
        throw new ResourceNotFoundException(NOT_FOUND);
    }

    @Override
    public Order updateOrder(Long id, Order order) {
        Optional<Order> orderOptional = orderRepo.findById(id);
        if(orderOptional.isPresent()){
            Order temp = orderOptional.get();
            temp.setDate(order.getDate());
            temp.setStatus(order.getStatus());
            return orderRepo.save(temp);
        }
        throw new ResourceNotFoundException(NOT_FOUND);
    }

    @Override
    public void deleteOrder(Long id) {
        Optional<Order> orderOptional = orderRepo.findById(id);
        if(orderOptional.isPresent()){
            orderRepo.deleteById(id);
            return ;
        }
        throw new ResourceNotFoundException(NOT_FOUND);
    }

    @Override
    public Set<Order> getAllOrders() {
        Set<Order> orders = orderRepo.findAll().stream().filter( Objects::nonNull).collect(Collectors.toSet());

        return orders ;
    }

   
    @Override
    public Order getOrderById(Long id) {
        Optional<Order> orderOptional = orderRepo.findById(id);
        if(orderOptional.isPresent()){
            return orderOptional.get();
        }
        throw new ResourceNotFoundException(NOT_FOUND);
    }



    @Override
    public Product addProduct(Product product) {
        System.out.println(" before adding Product "+product);
        return productRepo.save(product);

    }


    @Override
    public void deleteProduct(Long id) {
        Optional<Product> productOptional = productRepo.findById(id);
        if(productOptional.isPresent()){
            productRepo.deleteById(id);
            return ;
        }
        throw new ResourceNotFoundException(NOT_FOUND);
    }

    @Override
    public Set<Product> getAllProducts() {
        return productRepo.findAll()
                .stream()
                .filter(Objects::nonNull)
                .peek((product -> System.out.println(product.getName())))
                .collect(Collectors.toSet());

    }




    @Override
    public Product getProductById(Long id) {
        Optional<Product> optional = productRepo.findById(id);
        if(optional.isPresent()){
            return optional.get();
        }
        throw new ResourceNotFoundException(NOT_FOUND);
    }

    

    @Override
    public Order addOrder(Order order) {
//        Logger.getLogger(getClass().getName()).info(customerOptional.get().getName());
//        order.setCustomer(customerOptional.get());
        Order orderTemp = orderRepo.save(order);
        return orderTemp;
    }

    @Override
    public Order addProductToOrder(Long id, Product product) {
        Optional<Order> optionalOrder = orderRepo.findById(id);
        Order order = optionalOrder.orElseThrow(()->  new ResourceNotFoundException("Not Found "));
        order.getProducts().add(product);
        Order saved = orderRepo.save(order);
        return saved ;
    }


}
