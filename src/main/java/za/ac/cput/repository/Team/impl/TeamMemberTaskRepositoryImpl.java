package za.ac.cput.repository.Team.impl;

import org.springframework.stereotype.Repository;
import za.ac.cput.Domain.Team.TeamMemberTask;
import za.ac.cput.repository.Team.TeamMemberTaskRepository;

import java.util.*;

@Repository("teamMemberTaskRepository")
public class TeamMemberTaskRepositoryImpl  implements TeamMemberTaskRepository {

    private static TeamMemberTaskRepositoryImpl repository = null;
    private Map<String, TeamMemberTask> teamMemberTasks;

    private TeamMemberTaskRepositoryImpl() {
        this.teamMemberTasks = new HashMap<>();
    }

    public static TeamMemberTaskRepository getRepository(){
        if(repository == null) repository = new TeamMemberTaskRepositoryImpl();
        return repository;
    }

    public TeamMemberTask create(TeamMemberTask teamMemberTask){
        this.teamMemberTasks.put(teamMemberTask.getTaskId(),teamMemberTask);
        return teamMemberTask;
    }

    public TeamMemberTask read(String taskId){
        return this.teamMemberTasks.get(taskId);
    }

    public TeamMemberTask update(TeamMemberTask teamMemberTask) {
        this.teamMemberTasks.replace(teamMemberTask.getTaskId(),teamMemberTask);
        return this.teamMemberTasks.get(teamMemberTask.getTaskId());
    }

    public void delete(String taskId) {
        this.teamMemberTasks.remove(taskId);
    }

    public Set<TeamMemberTask> getAll(){
        Collection<TeamMemberTask> teamMemberTasks = this.teamMemberTasks.values();
        Set<TeamMemberTask> set = new HashSet<>();
        set.addAll(teamMemberTasks);
        return set;
    }

}