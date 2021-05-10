package iti.labs.spring.data.repository;

import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import iti.labs.spring.data.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {


    List<Customer> findAll();

    List<Customer> findAll(Sort sort);

    Customer getById(Long id);

    Customer getOne(Long id);

    long count();

    void delete(Customer entity);

    void deleteById(Long id);

    Customer save(Customer entity);

    //Query Creation.
    List<Customer> findByAddress(String address);

    //Using JPA Named Queries:[Annotation on Class Entity]
    List<Customer> findByCustomerName(String customerName);

    @Query("select c from Customer c where c.fullName like %?1")
    List<Customer> findByFullnameEndsWith(String name);


    //  Using SpEL expressions and Using Sort
    @Query("select c.id, LENGTH(c.userName) as fn_len from #{#entityName} c where c.fullName like ?1%")
    List<Object[]> findByAsArrayAndSort(String firstName, Sort sort);


}


