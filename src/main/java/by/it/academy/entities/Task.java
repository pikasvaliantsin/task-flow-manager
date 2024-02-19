package by.it.academy.entities;

import by.it.academy.enums.Priority;
import by.it.academy.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

import static by.it.academy.enums.Status.COMPLETED;
import static by.it.academy.enums.Status.IN_PROGRESS;
import static jakarta.persistence.EnumType.STRING;
import static jakarta.persistence.GenerationType.IDENTITY;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TASK")
public class Task {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID")
    private UUID id;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "DESCRIPTION")
    private String description;

    @Enumerated(STRING)
    @Column(name = "PRIORITY")
    private Priority priority;

    @Enumerated(STRING)
    @Column(name = "STATUS")
    private Status status;

    @Column(name = "CREATE_TASK_TIME")
    private LocalDateTime createTaskTime;

    @Column(name = "START_TASK_TIME")
    private LocalDateTime startTaskTime;

    @Column(name = "FINISH_TASK_TIME")
    private LocalDateTime finishTaskTime;

    @ManyToOne
    @JoinColumn(name = "TEAM_ID")
    private Team team;

    @PrePersist
    public void prePersist() {
        this.createTaskTime = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        if (this.status == IN_PROGRESS && this.startTaskTime == null) {
            this.startTaskTime = LocalDateTime.now();
        }
        if (this.status == COMPLETED && this.finishTaskTime == null) {
            this.finishTaskTime = LocalDateTime.now();
        }
    }
}