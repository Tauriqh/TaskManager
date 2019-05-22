package za.ac.cput.service.Team;


import za.ac.cput.Domain.Team.ProjectTeamMember;
import za.ac.cput.service.IService;

import java.util.Set;

public interface ProjectTeamMemberService  extends IService<ProjectTeamMember, String> {
    Set<ProjectTeamMember> getAll();
}
