package za.ac.cput.controller.team;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.Domain.Team.ProjectTeamMember;
import za.ac.cput.Factory.Team.ProjectTeamMemberFactory;
import za.ac.cput.service.Team.ProjectTeamMemberService;

import java.util.Set;

@RestController
@RequestMapping("/projectTeamMember")
public class ProjectTeamMemberController {
    @Autowired
    @Qualifier("projectTeamMemberServiceImpl")
    private ProjectTeamMemberService service;

    @PostMapping("/create/{projectId, memberId}")
    @ResponseBody
    public ProjectTeamMember create(@PathVariable String projectId, String memberId) {
        ProjectTeamMember projectTeamMember = ProjectTeamMemberFactory.buildProjectTeamMember(projectId, memberId);
        return service.create(projectTeamMember);
    }

    @PostMapping("/update")
    @ResponseBody
    public ProjectTeamMember update(ProjectTeamMember projectTeamMember) {
        return service.update(projectTeamMember);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public ProjectTeamMember read(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Set<ProjectTeamMember> getAll() {
        return service.getAll();
    }
}
