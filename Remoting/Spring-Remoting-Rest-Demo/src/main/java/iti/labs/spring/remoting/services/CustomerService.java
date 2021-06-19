package iti.labs.spring.remoting.services;

import iti.labs.spring.remoting.entities.Customer;
import iti.labs.spring.remoting.entities.Order;
import iti.labs.spring.remoting.entities.Product;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface CustomerService {
    public Customer save(Customer customer);

    public Customer update(Customer customer);

    public void delete(Long id);

    public Set<Customer> getAll();

    public Customer getCustomerById(Long id);

    public Order addOrder(Long id, Order order);

    public Order updateOrder(Long id, Order Order);

    public void deleteOrder(Long id);

    public Set<Order> getAllOrders();

    public Order getOrderById(Long id);

    Product addProduct(Product product);


    void deleteProduct(Long id);

    Set<Product> getAllProducts();


    Product getProductById(Long id);


    Order addOrder(Order order);

    Order addProductToOrder(Long id, Product product);
}
