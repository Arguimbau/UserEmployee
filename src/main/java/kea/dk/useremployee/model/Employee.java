package kea.dk.useremployee.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
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
    private User user;

    public Employee( String name, LocalDateTime born, Gender gender, boolean vegetarian ) {
        this.name = name;
        this.born = born;
        this.gender = gender;
        this.vegetarian = vegetarian;
    }


}
