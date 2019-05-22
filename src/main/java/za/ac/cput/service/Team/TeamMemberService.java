package za.ac.cput.service.Team;

import za.ac.cput.Domain.Team.TeamMember;
import za.ac.cput.service.IService;

import java.util.Set;

public interface TeamMemberService extends IService<TeamMember, String> {
    Set<TeamMember> getAll();
}
