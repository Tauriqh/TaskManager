package za.ac.cput.service.Team.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import za.ac.cput.Domain.Team.ProjectTeamMember;
import za.ac.cput.repository.Team.ProjectTeamMemberRepository;
import za.ac.cput.service.Team.ProjectTeamMemberService;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Service("projectTeamMemberServiceImpl")
public class ProjectTeamMemberServiceImpl implements ProjectTeamMemberService {
    @Autowired
    @Qualifier("projectTeamMemberRepository")

    private ProjectTeamMemberRepository repository;

    @Override
    public ProjectTeamMember create(ProjectTeamMember projectTeamMember) {
        return repository.create(projectTeamMember);
    }

    @Override
    public ProjectTeamMember update(ProjectTeamMember projectTeamMember) {
        return repository.update(projectTeamMember);
    }

    @Override
    public void delete(String s) {
        repository.delete(s);
    }

    @Override
    public ProjectTeamMember read(String s) {
        return repository.read(s);
    }

    @Override
    public Set<ProjectTeamMember> getAll() {
        return repository.getAll();
    }
}