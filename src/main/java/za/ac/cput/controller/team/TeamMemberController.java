package za.ac.cput.controller.team;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.Domain.Team.TeamMember;
import za.ac.cput.Factory.Team.TeamMemberFactory;
import za.ac.cput.service.Team.TeamMemberService;

import java.util.Set;

@RestController
@RequestMapping("/teamMember")
public class TeamMemberController {
    @Autowired
    @Qualifier("teamMemberServiceImpl")
    private TeamMemberService service;

    @PostMapping("/create/{memberId, memberName}")
    @ResponseBody
    public TeamMember create(@PathVariable String memberId, String memberName) {
        TeamMember teamMember = TeamMemberFactory.buildTeamMember(memberId, memberName);
        return service.create(teamMember);
    }

    @PostMapping("/update")
    @ResponseBody
    public TeamMember update(TeamMember teamMember) {
        return service.update(teamMember);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public TeamMember read(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Set<TeamMember> getAll() {
        return service.getAll();
    }
}
