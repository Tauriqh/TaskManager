package za.ac.cput.service.Team.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import za.ac.cput.Domain.Team.TeamMemberTask;
import za.ac.cput.repository.Team.TeamMemberTaskRepository;
import za.ac.cput.service.Team.TeamMemberTaskService;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Service("teamMemberTaskServiceImpl")
public class TeamMemberTaskServiceImpl implements TeamMemberTaskService {
    @Autowired
    @Qualifier("teamMemberTaskRepository")

    private TeamMemberTaskRepository repository;

    @Override
    public TeamMemberTask create(TeamMemberTask teamMemberTask) {
        return repository.create(teamMemberTask);
    }

    @Override
    public TeamMemberTask update(TeamMemberTask teamMemberTask) {
        return repository.update(teamMemberTask);
    }

    @Override
    public void delete(String s) {
        repository.delete(s);
    }

    @Override
    public TeamMemberTask read(String s) {
        return repository.read(s);
    }

    @Override
    public Set<TeamMemberTask> getAll() {
        return repository.getAll();
    }
}