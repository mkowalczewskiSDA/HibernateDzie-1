package model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "`order`")
public class Order implements ModelClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORD_ID")
    private int id;
    @Column(name = "ORD_DATE")
    private LocalDateTime orderDate;
    @Column(name = "ORD_PRICE")
    private BigDecimal orderPrice;
    @ManyToOne
    @JoinColumn(name = "ORD_USR_ID", referencedColumnName = "USR_ID")
    private User user;
    @ManyToMany(mappedBy = "orders")
    private Set<Product> products = new HashSet<>();
}
