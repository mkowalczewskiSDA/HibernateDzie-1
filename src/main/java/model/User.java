package model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@NamedQueries({@NamedQuery(name = "user.select", query = "Select u from User u where u.email=:email")})
@EqualsAndHashCode(exclude = "address")
@ToString(exclude = "address")
public class User implements ModelClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USR_ID")
    private int id;
    @Column(name = "USR_FIRSTNAME")
    private String firstName;
    @Column(name = "USR_LASTNAME")
    private String lastName;
    @Column(name = "USR_PASSWORD")
    private String password;
    @Column(name = "USR_EMAIL")
    private String email;
    @Column(name = "USR_BIRTH_DATE")
    private LocalDateTime birthDate;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USR_ADD_ID", referencedColumnName = "ADD_ID")
    private Address address;
    @Transient
    private String fullName;

    public String getFullName(){
        return fullName = firstName + " "+lastName;
    }
}
