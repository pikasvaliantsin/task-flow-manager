package by.it.academy.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

import static jakarta.persistence.CascadeType.PERSIST;
import static jakarta.persistence.GenerationType.IDENTITY;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "EMPLOYEE")
public class Employee {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID")
    private UUID id;

    @Column(name = "FIRSTNAME")
    private String firstname;

    @Column(name = "SECONDNAME")
    private String secondName;

    @Column(name = "EMAIL")
    private String email;

    @ManyToMany(mappedBy = "employees", cascade = PERSIST)
    private List<Team> teams;

    public Employee(UUID id, String firstname, String secondName, String email) {
        this.id = id;
        this.firstname = firstname;
        this.secondName = secondName;
        this.email = email;
    }
}