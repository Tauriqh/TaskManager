package za.ac.cput.service.Team;

import za.ac.cput.Domain.Team.TeamMemberTask;
import za.ac.cput.service.IService;

import java.util.Set;

public interface TeamMemberTaskService  extends IService<TeamMemberTask, String> {
    Set<TeamMemberTask> getAll();
}
