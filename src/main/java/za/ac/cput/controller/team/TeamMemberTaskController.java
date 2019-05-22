package za.ac.cput.controller.team;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.Domain.Team.TeamMemberTask;
import za.ac.cput.Factory.Team.TeamMemberTaskFactory;
import za.ac.cput.service.Team.TeamMemberTaskService;

import java.util.Set;

@RestController
@RequestMapping("/teamMemberTask")
public class TeamMemberTaskController {
    @Autowired
    @Qualifier("teamMemberTaskServiceImpl")
    private TeamMemberTaskService service;

    @PostMapping("/create/{taskId, taskDesc, taskDueDate, memberId}")
    @ResponseBody
    public TeamMemberTask create(@PathVariable String taskId, String taskDesc, String taskDueDate, String memberId) {
        TeamMemberTask teamMemberTask = TeamMemberTaskFactory.buildTeamMemberTask(taskId, taskDesc, taskDueDate, memberId);
        return service.create(teamMemberTask);
    }

    @PostMapping("/update")
    @ResponseBody
    public TeamMemberTask update(TeamMemberTask teamMemberTask) {
        return service.update(teamMemberTask);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public TeamMemberTask read(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Set<TeamMemberTask> getAll() {
        return service.getAll();
    }
}
