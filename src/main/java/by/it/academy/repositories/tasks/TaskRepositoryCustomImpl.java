package by.it.academy.repositories.tasks;

import by.it.academy.entities.Task;
import by.it.academy.enums.Priority;
import by.it.academy.enums.Status;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

import static by.it.academy.entities.QTask.task;

public class TaskRepositoryCustomImpl extends QuerydslRepositorySupport implements TaskRepositoryCustom {
    public TaskRepositoryCustomImpl(JPAQueryFactory jpaQueryFactory) {
        super(Task.class);
        this.jpaQueryFactory = jpaQueryFactory;
    }

    private final JPAQueryFactory jpaQueryFactory;

    @Transactional
    @Override
    public long changeStatus(UUID id, String status) {
        Status newStatus = Status.valueOf(status);
        return jpaQueryFactory.update(task)
                .set(task.status, newStatus)
                .where(task.id.eq(id))
                .execute();
    }

    @Override
    public long changePriority(UUID id, String priority) {
        return jpaQueryFactory.update(task)
                .set(task.priority, Priority.valueOf(priority))
                .where(task.id.eq(id))
                .execute();
    }

    @Override
    public long deleteTaskById(UUID id) {
        return jpaQueryFactory.delete(task)
                .where(task.id.eq(id))
                .execute();
    }
}