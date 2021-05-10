package iti.labs.spring.data;

import java.time.LocalDate;
import java.util.List;
import com.mysql.cj.jdbc.AbandonedConnectionCleanupThread;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Sort;
import iti.labs.spring.data.model.Customer;
import iti.labs.spring.data.repository.CustomerRepository;


public class Application {

        public static void main(String[] args) {

                // Create a new application context. this processes the Spring config
                ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");



                System.out.println("\nInside JpaCustomerDao:");
                CustomerRepository customerRepository =
                                ctx.getBean("customerRepository", CustomerRepository.class);

                System.out.printf("The number of customers is %s %n", customerRepository.count());

                System.out.println("Get customer 1 : " + customerRepository.findById(1L));

                System.out.println("Retrieve All Customers: ");

                List<Customer> allCustomers = customerRepository.findAll();

                for (Customer customer : allCustomers) {
                        System.out.println("\n" + customer);
                }

                System.out.println("Insert New Customer : ");
                Customer newCustomer = new Customer();
                newCustomer.setAddress("Giza, Egypt");
                newCustomer.setBirthday(LocalDate.of(1980, 02, 12));
                newCustomer.setUserName("Spring");
                newCustomer.setFullName("Spring Data");
                newCustomer.setPassword("123");
                newCustomer.setPhone("01234567890");

                try {
                        System.out.println(
                                        "\nIs iserted :  " + customerRepository.save(newCustomer));
                } catch (Exception e1) {
                        // TODO Auto-generated catch block
                        // e1.printStackTrace();
                        System.out.println("Insertion Error Message : " + e1.getMessage());
                }


                System.out.println("\nUpdate Exsiting Customer : ");
                Customer updatedCustomer = new Customer(91, "Updated", "Updated Address",
                                "01234567890", LocalDate.now(), "Updated Full Name",
                                "new password");

                try {
                   customerRepository.save(updatedCustomer);
                } catch (Exception e1) {

                        // e1.printStackTrace();
                        System.out.println("Update Error Message : " + e1.getMessage());
                }

                System.out.println("\nFind by address : " + customerRepository.findByAddress("Alexandria, Egypt"));

                System.out.println("\nUsing JPA Named Queries: "+ customerRepository.findByCustomerName("sasd"));
                
                System.out.println("\nUsing JPA Query Annotation on method with like expression: "+ customerRepository.findByFullnameEndsWith("all"));

                System.out.println("\nUsing SpEL expressions and Using Sort: ");
                List<Object[]> findByAsArrayAndSort = customerRepository.findByAsArrayAndSort("A", Sort.by("fn_len"));
                for (Object[] objects : findByAsArrayAndSort) {

                        System.out.println("id : " + objects[0] + " ,user name length : "+ objects[1]);
                        
                }



                // System.out.println(
                // "\nIs updated : " + customerDao.updateCustomer(updatedCustomer));

                // System.out.println("\nDelete Exsiting Customer : ");
                // System.out.println("Is Deleted : " + customerDao.deleteCustomer(17));



                AbandonedConnectionCleanupThread.checkedShutdown();

        }

}
