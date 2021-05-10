package iti.labs.spring.data.model;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@NamedQuery(name = "Customer.findByCustomerName",
  query = "select c from Customer c where c.userName = ?1")
@Table(name = "customer", uniqueConstraints = {@UniqueConstraint(columnNames = {"user_name"})})
// Vlad Answer
// :https://stackoverflow.com/questions/2020904/when-and-why-jpa-entities-should-implement-the-serializable-interface
// but for this app no need for implementing serializabe
public class Customer implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private long id;

    @Column(name = "user_name")
    @Basic(optional = false)
    private String userName;

    @Column(name = "address")
    private String address;

    @Column(name = "phone")
    private String phone;

    @Column(name = "birthday", columnDefinition = "DATETIME")
    // @Temporal(TemporalType.TIMESTAMP)
    private LocalDate birthday;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "password")
    private String password;
}
