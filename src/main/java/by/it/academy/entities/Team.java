package by.it.academy.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

import static jakarta.persistence.GenerationType.IDENTITY;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TEAM")
public class Team {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID")
    private UUID id;

    @Column(name = "NAME")
    private String name;

    @ManyToMany()
    @JoinTable(name = "TEAM_EMPLOYEE",
            joinColumns = {@JoinColumn(name = "TEAM_ID")},
            inverseJoinColumns = {@JoinColumn(name = "EMPLOYEE_ID")})
    private List<Employee> employees;

    @OneToMany(mappedBy = "team")
    private List<Task> tasks;
}