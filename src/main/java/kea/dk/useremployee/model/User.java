package kea.dk.useremployee.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    private String email;
    //@JsonIgnore
    private String password;

    @OneToOne(cascade = CascadeType.ALL,mappedBy = "user")
    @JsonBackReference // Do not include in json response
    private Employee employee;

    public User(String email, String password)
    {
        this.email = email;
        this.password = password;
    }



}
