package za.ac.cput.repository.Team;

import za.ac.cput.Domain.Team.TeamMember;
import za.ac.cput.repository.IRepository;

import java.util.Set;


public interface TeamMemberRepository extends IRepository<TeamMember, String> {
    Set<TeamMember> getAll();
}
