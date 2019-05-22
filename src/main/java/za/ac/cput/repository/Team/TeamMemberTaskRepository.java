package za.ac.cput.repository.Team;

import za.ac.cput.Domain.Team.TeamMemberTask;
import za.ac.cput.repository.IRepository;

import java.util.Set;

public interface TeamMemberTaskRepository extends IRepository<TeamMemberTask, String> {
    Set<TeamMemberTask> getAll();
}
