package by.it.academy.repositories.employees;

import by.it.academy.entities.Employee;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;
import java.util.UUID;

import static by.it.academy.entities.QEmployee.employee;
import static by.it.academy.entities.QTeam.team;

public class EmployeeRepositoryCustomImpl extends QuerydslRepositorySupport implements EmployeeRepositoryCustom {
    public EmployeeRepositoryCustomImpl(JPAQueryFactory jpaQueryFactory) {
        super(Employee.class);
        this.jpaQueryFactory = jpaQueryFactory;
    }

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<Employee> findAllEmployeesByTeamId(UUID team_id) {
        return jpaQueryFactory.select(employee)
                .from(employee)
                .join(employee.teams, team)
                .where(team.id.eq(team_id))
                .fetch();
    }

    public long deleteEmployeeById(UUID id){
        return jpaQueryFactory.delete(employee)
                .where(employee.id.eq(id))
                .execute();
    }
}