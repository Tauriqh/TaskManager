package za.ac.cput.repository.Team;

import za.ac.cput.Domain.Team.ProjectTeamMember;
import za.ac.cput.repository.IRepository;

import java.util.Set;

public interface ProjectTeamMemberRepository extends IRepository<ProjectTeamMember, String> {
    Set<ProjectTeamMember> getAll();
}
