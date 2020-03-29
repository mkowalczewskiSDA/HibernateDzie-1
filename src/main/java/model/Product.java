package model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Product implements ModelClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PRO_ID")
    private int id;
    @Column(name = "PRO_NAME")
    private String name;
    @Column(name = "PRO_PRICE")
    private BigDecimal price;
    @Column(name = "PRO_DESCRIPTION")
    private String description;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "PRO_CAT_ID", referencedColumnName = "CAT_ID")
    private Category category;
    @ManyToMany
    @JoinTable(
            name = "cart",
            joinColumns = {@JoinColumn(name = "CRT_PRO_ID")},
            inverseJoinColumns = {@JoinColumn(name = "CRT_ORD_ID")}
    )
    private Set<Order> orders = new HashSet<>();
}
