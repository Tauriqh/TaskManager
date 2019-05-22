package za.ac.cput.repository.Team.impl;

import org.springframework.stereotype.Repository;
import za.ac.cput.Domain.Team.TeamMember;
import za.ac.cput.repository.Team.TeamMemberRepository;

import java.util.*;

@Repository("teamMemberRepository")
public class TeamMemberRepositoryImpl implements TeamMemberRepository {

    private static TeamMemberRepositoryImpl repository = null;
    private Map<String, TeamMember> teamMembers;

    private TeamMemberRepositoryImpl() {
        this.teamMembers = new HashMap<>();
    }

    public static TeamMemberRepository getRepository() {
        if (repository == null) repository = new TeamMemberRepositoryImpl();
        return repository;
    }

    public TeamMember create(TeamMember teamMember) {
        this.teamMembers.put(teamMember.getMemberId(),teamMember);
        return teamMember;
    }

    public TeamMember read(String teamMemberId) {
        return this.teamMembers.get(teamMemberId);
    }

    public TeamMember update(TeamMember teamMember) {
        this.teamMembers.replace(teamMember.getMemberId(),teamMember);
        return this.teamMembers.get(teamMember.getMemberId());
    }

    public void delete(String teamMemberId) {
        this.teamMembers.remove(teamMemberId);
    }

    public Set<TeamMember> getAll() {
        Collection<TeamMember> teamMembers = this.teamMembers.values();
        Set<TeamMember> set = new HashSet<>();
        set.addAll(teamMembers);
        return set;
    }
}
