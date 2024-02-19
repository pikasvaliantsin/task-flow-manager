package by.it.academy.repositories.teams;

import by.it.academy.entities.Team;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.UUID;

import static by.it.academy.entities.QTeam.team;

public class TeamRepositoryCustomImpl extends QuerydslRepositorySupport implements TeamRepositoryCustom {
    public TeamRepositoryCustomImpl(JPAQueryFactory jpaQueryFactory) {
        super(Team.class);
        this.jpaQueryFactory = jpaQueryFactory;
    }

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public long deleteTeamById(UUID id) {
        return jpaQueryFactory.delete(team)
                .where(team.id.eq(id))
                .execute();
    }
}