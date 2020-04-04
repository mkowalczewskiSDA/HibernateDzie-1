package model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
@EqualsAndHashCode(exclude = "country")
@ToString(exclude = "country")
public class Address implements ModelClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ADD_ID")
    private int id;
    @Column(name = "ADD_STREET")
    private String street;
    @Column(name = "ADD_BUILDING_NO")
    private String buildingNo;
    @Column(name = "ADD_APARTAMENT_NO")
    private String appartamentNo;
    @Column(name = "ADD_CITY")
    private String city;
    @Column(name = "ADD_POSTAL_CODE")
    private String postalCode;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ADD_CO_ID", referencedColumnName = "CO_ID")
    private Country country;

}
