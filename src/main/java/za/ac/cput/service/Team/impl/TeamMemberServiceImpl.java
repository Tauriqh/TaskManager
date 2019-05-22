package za.ac.cput.service.Team.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import za.ac.cput.Domain.Team.TeamMember;
import za.ac.cput.repository.Team.TeamMemberRepository;
import za.ac.cput.service.Team.TeamMemberService;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Service("teamMemberServiceImpl")
public class TeamMemberServiceImpl implements TeamMemberService {
    @Autowired
    @Qualifier("teamMemberRepository")

    private TeamMemberRepository repository;

    @Override
    public TeamMember create(TeamMember teamMember) {
        return repository.create(teamMember);
    }

    @Override
    public TeamMember update(TeamMember teamMember) {
        return repository.update(teamMember);
    }

    @Override
    public void delete(String s) {
        repository.delete(s);
    }

    @Override
    public TeamMember read(String s) {
        return repository.read(s);
    }

    @Override
    public Set<TeamMember> getAll() {
        return repository.getAll();
    }
}