package kea.dk.useremployee.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Employee
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private LocalDateTime born;
    private Gender gender;
    private boolean vegetarian;

    @OneToOne
    @JoinColumn(name = "useridfk", referencedColumnName = "userID", nullable = false)
    private User user;


}
